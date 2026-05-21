let cart = [];

async function loadProducts() {

    const response =
        await fetch('/api/products');

    const products =
        await response.json();

    const container =
        document.getElementById('products');

    container.innerHTML = '';

    products.forEach(product => {

        container.innerHTML += `

            <div class="card">

                <h3>${product.nombre}</h3>

                <p>
                    Categoría:
                    ${product.categoria}
                </p>

                <p>
                    Precio:
                    $${product.precio}
                </p>

                <button
                    class="buy-btn"
                    onclick="
                        buyProduct(
                            ${product.id},
                            '${product.nombre}',
                            ${product.precio}
                        )
                    "
                >
                    Comprar
                </button>

            </div>
        `;
    });
}

async function addProduct() {

    const nombre =
        document.getElementById('name').value;

    const categoria =
        document.getElementById('category').value;

    const precio =
        document.getElementById('price').value;

    if (!nombre || !categoria || !precio) {

        alert('Complete todos los campos');

        return;
    }

    await fetch('/api/products', {

        method: 'POST',

        headers: {
            'Content-Type': 'application/json'
        },

        body: JSON.stringify({
            nombre,
            categoria,
            precio: parseFloat(precio)
        })
    });

    document.getElementById('name').value = '';
    document.getElementById('category').value = '';
    document.getElementById('price').value = '';

    loadProducts();
}

function buyProduct(id, name, price) {

    const quantity = 1;

    const subtotal = price * quantity;

    const tax = subtotal * 0.12;

    const total = subtotal + tax;

    cart.push({
        name,
        quantity,
        subtotal,
        tax,
        total
    });

    renderInvoice();
}

function renderInvoice() {

    const invoice =
        document.getElementById('invoice');

    invoice.innerHTML = '';

    let totalGeneral = 0;

    cart.forEach(item => {

        totalGeneral += item.total;

        invoice.innerHTML += `

            <div class="card">

                <h4>${item.name}</h4>

                <p>
                    Cantidad:
                    ${item.quantity}
                </p>

                <p>
                    Total:
                    $${item.total.toFixed(2)}
                </p>

            </div>
        `;
    });

    invoice.innerHTML += `

        <h3>
            TOTAL:
            $${totalGeneral.toFixed(2)}
        </h3>
    `;
}

loadProducts();