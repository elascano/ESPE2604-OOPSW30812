const lblId = document.getElementById("lblId");
const lblType = document.getElementById("lblType");
const lblAge = document.getElementById("lblAge");

const lblAttribute1 = document.getElementById("lblAttribute1");
const lblValue1 = document.getElementById("lblValue1");

const lblAttribute2 = document.getElementById("lblAttribute2");
const lblValue2 = document.getElementById("lblValue2");

const cmbFood = document.getElementById("cmbFood");

const btnFeed = document.getElementById("btnFeed");
const btnCalculateAge = document.getElementById("btnCalculateAge");
const btnOperation1 = document.getElementById("btnOperation1");
const btnOperation2 = document.getElementById("btnOperation2");
const btnClear = document.getElementById("btnClear");

const tableBody = document.querySelector("#tblAnimals tbody");

const ANIMAL_URL = "/api/animals";
const FOOD_URL = "/api/foods";
const CUT_URL = "/api/cuts";

let selectedAnimal = null;
let foods = [];

btnFeed.addEventListener("click", feed);

btnCalculateAge.addEventListener(
    "click",
    calculateAge
);

btnClear.addEventListener(
    "click",
    clear
);

async function loadAnimals() {

    tableBody.innerHTML = "";

    const response = await fetch(ANIMAL_URL);
    const animals = await response.json();

    animals.forEach(animal => {
        const row = document.createElement("tr");

        row.innerHTML = `
            <td>${animal.id}</td>
            <td>${animal.type}</td>
            <td>${animal.breed}</td>
            <td>${new Date(animal.bornOnDate).toLocaleDateString()}</td>
            <td>${animal.weight}</td>
        `;

        row.addEventListener("click", () => {
            selectAnimal(animal);
        });

        tableBody.appendChild(row);

    });

}

async function loadFoods() {

    const response = await fetch(FOOD_URL);
    foods = await response.json();

    cmbFood.innerHTML = "";

    foods.forEach(food => {

        const option = document.createElement("option");
        option.value = food.id;
        option.textContent = `${food.id} - ${food.typeOfFood}`;
        cmbFood.appendChild(option);

    });

}

btnOperation1.style.display = "none";

btnOperation2.style.display = "none";

loadAnimals();

loadFoods();

clear();

function selectAnimal(animal) {
    selectedAnimal = animal;
    loadAnimal();

}

function loadAnimal() {

    if (selectedAnimal == null) {
        return;
    }

    lblId.textContent = selectedAnimal.id;
    lblType.textContent = selectedAnimal.type;
    lblAge.textContent = "-";
    btnOperation1.style.display = "inline-block";
    btnOperation2.style.display = "none";

    switch (selectedAnimal.type) {

        case "Chicken":

            lblAttribute1.textContent = "Number Of Eggs";
            lblValue1.textContent = selectedAnimal.numberOfEggs;
            lblAttribute2.textContent = "Is Molting";
            lblValue2.textContent = selectedAnimal.isMolting;
            btnOperation1.textContent = "Lay An Egg";
            btnOperation1.onclick = layAnEgg;
            break;

        case "Cow":

            lblAttribute1.textContent = "Producing Milk";
            lblValue1.textContent = selectedAnimal.isProducingMilk;
            lblAttribute2.textContent = "";
            lblValue2.textContent = "";
            btnOperation1.textContent = "Milk";
            btnOperation1.onclick = milk;
            btnOperation2.style.display = "inline-block";
            btnOperation2.textContent = "Cut";
            btnOperation2.onclick = cutCow;
            break;

        case "Pig":

            lblAttribute1.textContent = "Weight";
            lblValue1.textContent = selectedAnimal.weight;
            lblAttribute2.textContent = "Ideal Weight";
            lblValue2.textContent = selectedAnimal.idealWeight;
            btnOperation1.textContent = "Cut";
            btnOperation1.onclick = cutPig;
            break;

        case "Sheep":

            lblAttribute1.textContent = "Last Shearing";
            lblValue1.textContent =
                new Date(
                    selectedAnimal.lastShearing
                ).toLocaleDateString();

            lblAttribute2.textContent = "";
            lblValue2.textContent = "";
            btnOperation1.style.display = "none";
            btnOperation2.style.display = "none";
            break;
    }

}

function calculateAge() {

    if (selectedAnimal == null) {
        alert("Select an animal.");
        return;
    }

    const birth = new Date(selectedAnimal.bornOnDate);
    const today = new Date();

    let months = (today.getFullYear() - birth.getFullYear()) * 12;
    months += today.getMonth() - birth.getMonth();

    if (today.getDate() < birth.getDate()) {
        months--;
    }

    lblAge.textContent = months;

}

async function feed() {

    if (selectedAnimal == null) {
        alert("Select an animal.");
        return;

    }

    const food = foods.find(f =>
        f.id == cmbFood.value
    );

    if (!food) {
        alert("Select a food.");
        return;
    }

    const type = food.typeOfFood;

    let canFeed = false;

    switch (selectedAnimal.type) {

        case "Chicken":

        case "Pig":
            canFeed = type === "Corn" || type === "Mixed Feed";
            break;

        case "Cow":

        case "Sheep":

            canFeed =type === "Grass" || type === "Hay";
            break;
    }

    if (!canFeed) {
        alert("This animal cannot eat that food.");
        return;

    }

    selectedAnimal.weight++;

    await fetch(

        `${ANIMAL_URL}/${selectedAnimal.id}`,

        {

            method: "PUT",
            headers: { "Content-Type": "application/json"},
            body: JSON.stringify(selectedAnimal)

        }

    );

    await fetch(

        `${FOOD_URL}/${food.id}`,

        {
            method: "DELETE"
        }

    );

    alert("Animal fed.");
    loadAnimals();
    loadFoods();
    loadAnimal();

}

async function layAnEgg() {

    if (selectedAnimal.isMolting) {
        alert("Chicken is molting.");
        return;

    }

    selectedAnimal.numberOfEggs++;

    await fetch(

        `${ANIMAL_URL}/${selectedAnimal.id}`,

        {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(selectedAnimal)
        }

    );

    alert("Chicken laid an egg.");
    loadAnimals();
    loadAnimal();

}

function milk() {

    if (!selectedAnimal.isProducingMilk) {
        alert("This cow cannot produce milk.");
        return;
    }

    const quantity = selectedAnimal.weight / 100;

    alert( `Milk produced: ${quantity.toFixed(2)} liters`);

}

async function cutPig() {

    if (selectedAnimal == null) {
        alert("Select a pig.");
        return;
    }

    if (selectedAnimal.weight < selectedAnimal.idealWeight) {
        alert("Pig has not reached its ideal weight.");
        return;
    }

    const cuts = [

        {
            id: selectedAnimal.id * 10 + 1,
            description: "Ham",
            procedure: "Pig",
            weight: 12.0
        },

        {
            id: selectedAnimal.id * 10 + 2,
            description: "Bacon",
            procedure: "Pig",
            weight: 8.0
        },

        {
            id: selectedAnimal.id * 10 + 3,
            description: "Ribs",
            procedure: "Pig",
            weight: 6.5
        }

    ];

    for (const cut of cuts) {

        await fetch(CUT_URL, {
            method: "POST",
            headers: {"Content-Type": "application/json" },
            body: JSON.stringify(cut)
        });

    }

    await fetch(
        `${ANIMAL_URL}/${selectedAnimal.id}`,
        {
            method: "DELETE"
        }
    );

    alert("Pig cut successfully.");

    selectedAnimal = null;
    clear();
    loadAnimals();

}

async function cutCow() {

    if (selectedAnimal == null) {
        alert("Select a cow.");
        return;
    }

    const cuts = [

        {
            id: selectedAnimal.id * 10 + 1,
            description: "Steak",
            procedure: "Cow",
            weight: 25.0
        },

        {
            id: selectedAnimal.id * 10 + 2,
            description: "Ribs",
            procedure: "Cow",
            weight: 12.5
        },

        {
            id: selectedAnimal.id * 10 + 3,
            description: "Ground Beef",
            procedure: "Cow",
            weight: 18.0
        }

    ];

    for (const cut of cuts) {

        await fetch(CUT_URL, {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(cut)

        });

    }

    await fetch(

        `${ANIMAL_URL}/${selectedAnimal.id}`,
        {
            method: "DELETE"
        }

    );

    alert("Cow cut successfully.");
    selectedAnimal = null;
    clear();
    loadAnimals();

}

function clear() {

    selectedAnimal = null;
    lblId.textContent = "-";
    lblType.textContent = "-";
    lblAge.textContent = "-";
    lblAttribute1.textContent = "Attribute 1";
    lblValue1.textContent = "-";
    lblAttribute2.textContent = "Attribute 2";
    lblValue2.textContent = "-";

    btnOperation1.style.display = "none";
    btnOperation2.style.display = "none";

}