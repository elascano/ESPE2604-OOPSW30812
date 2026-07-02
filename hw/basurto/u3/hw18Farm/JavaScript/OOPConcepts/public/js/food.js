const txtId = document.getElementById("txtId");

const cmbTypeOfFood = document.getElementById("cmbTypeOfFood");

const btnSave = document.getElementById("btnSave");
const btnUpdate = document.getElementById("btnUpdate");
const btnDelete = document.getElementById("btnDelete");
const btnClear = document.getElementById("btnClear");

const tableBody = document.querySelector("#tblFood tbody");

const URL = "/api/foods";


btnSave.addEventListener("click", saveFood);
btnUpdate.addEventListener("click", updateFood);
btnDelete.addEventListener("click", deleteFood);
btnClear.addEventListener("click", clearForm);


async function loadFoods() {

    tableBody.innerHTML = "";
    const response = await fetch(URL);
    const foods = await response.json();
    foods.forEach(food => {

        const row = document.createElement("tr");

        row.innerHTML = `

            <td>${food.id}</td>

            <td>${food.typeOfFood}</td>

        `;

        row.addEventListener("click", () => {
            loadFood(food);
        });

        tableBody.appendChild(row);

    });

}


function loadFood(food) {
    txtId.value = food.id;
    cmbTypeOfFood.value = food.typeOfFood;

}


function createFoodFromForm() {

    return {
        id: parseInt(txtId.value),
        typeOfFood: cmbTypeOfFood.value
    };

}

async function saveFood() {

    const food = createFoodFromForm();
    const response = await fetch(URL, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(food)

    });

    const result = await response.json();

    alert(result.message);

    if (response.ok) {
        clearForm();
        loadFoods();

    }

}

async function updateFood() {

    const food = createFoodFromForm();
    const response = await fetch(

        `${URL}/${food.id}`,

        {
            method: "PUT",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(food)
        }

    );

    const result = await response.json();

    alert(result.message);

    if (response.ok) {
        clearForm();
        loadFoods();

    }

}

async function deleteFood() {

    const id = txtId.value;

    if (id === "") {
        alert("Select a food.");
        return;
    }

    if (!confirm("Delete selected food?")) {
        return;
    }

    const response = await fetch(
        `${URL}/${id}`,

        {
            method: "DELETE"
        }

    );

    const result = await response.json();

    alert(result.message);

    if (response.ok) {
        clearForm();
        loadFoods();
    }

}

function clearForm() {
    txtId.value = "";
    cmbTypeOfFood.selectedIndex = 0;
}

loadFoods();