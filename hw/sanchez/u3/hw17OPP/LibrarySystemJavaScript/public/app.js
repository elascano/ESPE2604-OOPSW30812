async function saveBook() {
    try {
        const bookId = document.getElementById("bookId").value;
        const title = document.getElementById("title").value;
        const author = document.getElementById("author").value;

        if (!bookId || !title || !author) {
            alert("Por favor completa todos los campos");
            return;
        }

        const response = await fetch("/books", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                bookId: bookId,
                title: title,
                author: author
            })
        });

        if (!response.ok) {
            const error = await response.json();
            alert("Error: " + error.error);
            return;
        }

        const data = await response.json();
        alert(data.message);
        showBooks();
        limpiarCampos();
    } catch (error) {
        alert("Error al guardar: " + error.message);
    }
}

async function searchBook() {
    try {
        const id = document.getElementById("bookId").value;
        if (!id) {
            alert("Ingresa un ID para buscar");
            return;
        }

        const response = await fetch(`/books/${id}`);
        
        if (!response.ok) {
            if (response.status === 404) {
                alert("Libro no encontrado");
            } else {
                const error = await response.json();
                alert("Error: " + error.error);
            }
            return;
        }

        const book = await response.json();
        document.getElementById("title").value = book.title;
        document.getElementById("author").value = book.author;
    } catch (error) {
        alert("Error al buscar: " + error.message);
    }
}

async function showBooks() {
    try {
        const response = await fetch("/books");
        
        if (!response.ok) {
            const error = await response.json();
            alert("Error al cargar libros: " + error.error);
            return;
        }

        const books = await response.json();
        const tbody = document.querySelector("#booksTable tbody");
        tbody.innerHTML = "";
        
        if (books.length === 0) {
            tbody.innerHTML = `<tr><td colspan="3" style="text-align:center;">No hay libros</td></tr>`;
            return;
        }

        books.forEach(book => {
            tbody.innerHTML += `
                <tr>
                    <td>${book.bookId}</td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                </tr>`;
        });
    } catch (error) {
        alert("Error al mostrar libros: " + error.message);
    }
}

async function updateBook() {
    try {
        const id = document.getElementById("bookId").value;
        const title = document.getElementById("title").value;
        const author = document.getElementById("author").value;

        if (!id) {
            alert("Ingresa un ID para actualizar");
            return;
        }

        if (!title || !author) {
            alert("Ingresa título y autor");
            return;
        }

        const response = await fetch(`/books/${id}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                title: title,
                author: author
            })
        });

        if (!response.ok) {
            const error = await response.json();
            alert("Error: " + error.error);
            return;
        }

        const data = await response.json();
        alert(data.message);
        showBooks();
        limpiarCampos();
    } catch (error) {
        alert("Error al actualizar: " + error.message);
    }
}

async function deleteBook() {
    try {
        const id = document.getElementById("bookId").value;
        
        if (!id) {
            alert("Ingresa un ID para eliminar");
            return;
        }

        if (!confirm(`¿Eliminar libro ${id}?`)) {
            return;
        }

        const response = await fetch(`/books/${id}`, {
            method: "DELETE"
        });

        if (!response.ok) {
            const error = await response.json();
            alert("Error: " + error.error);
            return;
        }

        const data = await response.json();
        alert(data.message);
        showBooks();
        limpiarCampos();
    } catch (error) {
        alert("Error al eliminar: " + error.message);
    }
}

function limpiarCampos() {
    document.getElementById("bookId").value = "";
    document.getElementById("title").value = "";
    document.getElementById("author").value = "";
}

showBooks();