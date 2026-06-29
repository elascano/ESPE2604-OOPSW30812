async function createUser() {
    const name = document.getElementById("name").value;
    const plan = document.getElementById("plan").value;

    await fetch("http://localhost:3000/users", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ name, plan })
    });

    loadUsers();
}

async function loadUsers() {
    const res = await fetch("http://localhost:3000/users");
    const users = await res.json();

    const table = document.getElementById("table");
    table.innerHTML = "";

    users.forEach(u => {
        const row = document.createElement("tr");
        row.innerHTML = `<td>${u.name}</td><td>${u.plan}</td>`;
        table.appendChild(row);
    });
}

async function updateUser() {
    alert("Update no implementado aún");
}

async function deleteUser() {
    alert("Delete no implementado aún");
}

window.createUser = createUser;
window.loadUsers = loadUsers;
window.updateUser = updateUser;
window.deleteUser = deleteUser;

loadUsers();