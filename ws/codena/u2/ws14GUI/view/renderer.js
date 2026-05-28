const controller = require('../controller/productController');

const btnAdd = document.getElementById('btnAdd');
const btnShow = document.getElementById('btnShow');
const btnExit = document.getElementById('btnExit');

const message = document.getElementById('message');
const productsDiv = document.getElementById('products');

btnAdd.addEventListener('click', () => {

    const name = document.getElementById('name').value.trim();
    const id = document.getElementById('id').value.trim();
    const price = document.getElementById('price').value.trim();
    const weight = document.getElementById('weight').value.trim();

    // ===== VALIDATIONS =====

    // Name validation
    const nameRegex = /^[a-zA-Z\s]+$/;

    if (!nameRegex.test(name)) {
        message.innerHTML =
            "Product name must contain letters only.";
        message.style.color = "red";
        return;
    }

    // ID validation
    if (isNaN(id) || id === "") {
        message.innerHTML =
            "Product ID must be numeric.";
        message.style.color = "red";
        return;
    }

    // Price validation
    if (isNaN(price) || Number(price) < 0) {
        message.innerHTML =
            "Price must be a positive number.";
        message.style.color = "red";
        return;
    }

    // Weight validation
    if (isNaN(weight) || Number(weight) <= 0) {
        message.innerHTML =
            "Weight must be greater than 0.";
        message.style.color = "red";
        return;
    }

    // Save product
    const result = controller.saveProduct(
        name,
        Number(id),
        Number(price),
        Number(weight)
    );

    message.innerHTML = result;
    message.style.color = "green";

    // Clear fields
    document.getElementById('name').value = '';
    document.getElementById('id').value = '';
    document.getElementById('price').value = '';
    document.getElementById('weight').value = '';
});

btnShow.addEventListener('click', () => {

    const products = controller.getProducts();

    productsDiv.innerHTML = '';

    if (products.length === 0) {
        productsDiv.innerHTML =
            "<p>No products registered.</p>";
        return;
    }

    products.forEach(p => {

        productsDiv.innerHTML += `
            <div class="product-card">
                <h3>${p.name}</h3>
                <p><strong>ID:</strong> ${p.id}</p>
                <p><strong>Price:</strong> $${p.price}</p>
                <p><strong>Weight (LB):</strong> ${p.weightLb}</p>
                <p><strong>Weight (KG):</strong> ${p.weightKg}</p>
            </div>
        `;
    });
});

btnExit.addEventListener('click', () => {
    window.close();
});