const cmbType = document.getElementById("cmbType");

const txtId = document.getElementById("txtId");
const txtBreed = document.getElementById("txtBreed");
const txtBornOnDate = document.getElementById("txtBornOnDate");
const txtWeight = document.getElementById("txtWeight");

const chickenPanel = document.getElementById("chickenPanel");
const cowPanel = document.getElementById("cowPanel");
const pigPanel = document.getElementById("pigPanel");
const sheepPanel = document.getElementById("sheepPanel");

const chkMolting = document.getElementById("chkMolting");
const txtEggs = document.getElementById("txtEggs");

const chkMilk = document.getElementById("chkMilk");

const txtIdealWeight = document.getElementById("txtIdealWeight");

const txtLastShearing = document.getElementById("txtLastShearing");

const btnSave = document.getElementById("btnSave");
const btnUpdate = document.getElementById("btnUpdate");
const btnDelete = document.getElementById("btnDelete");
const btnClear = document.getElementById("btnClear");

const URL = "/api/animals";

cmbType.addEventListener("change", changePanel);
btnSave.addEventListener("click", saveAnimal);
btnUpdate.addEventListener("click", updateAnimal);
btnDelete.addEventListener("click", deleteAnimal);
btnClear.addEventListener("click", clearForm);

function hidePanels() {
    chickenPanel.style.display = "none";
    cowPanel.style.display = "none";
    pigPanel.style.display = "none";
    sheepPanel.style.display = "none";
}

function changePanel() {
    hidePanels();

    switch (cmbType.value) {
        case "Chicken":
            chickenPanel.style.display = "block";
            break;
        case "Cow":
            cowPanel.style.display = "block";
            break;
        case "Pig":
            pigPanel.style.display = "block";
            break;
        case "Sheep":
            sheepPanel.style.display = "block";
            break;
    }
}

hidePanels();
changePanel();

function createAnimalFromForm() {
    const animal = {
        id: parseInt(txtId.value),
        type: cmbType.value,
        breed: txtBreed.value,
        bornOnDate: txtBornOnDate.value,
        weight: parseFloat(txtWeight.value)
    };

    switch (cmbType.value) {
        case "Chicken":
            animal.isMolting = chkMolting.checked;
            animal.numberOfEggs = parseInt(txtEggs.value);
            break;
        case "Cow":
            animal.isProducingMilk = chkMilk.checked;
            break;
        case "Pig":
            animal.idealWeight = parseFloat(txtIdealWeight.value);
            break;
        case "Sheep":
            animal.lastShearing = txtLastShearing.value;
            break;
    }

    return animal;
}

function clearForm() {
    txtId.value = "";
    txtBreed.value = "";
    txtBornOnDate.value = "";
    txtWeight.value = "";
    cmbType.selectedIndex = 0;

    chkMolting.checked = false;
    txtEggs.value = "";

    chkMilk.checked = false;

    txtIdealWeight.value = "";

    txtLastShearing.value = "";

    changePanel();
}

async function saveAnimal() {
    
    if (!txtId.value || !txtBreed.value || !txtBornOnDate.value || !txtWeight.value) {
        alert("⚠️ Please fill all required fields: ID, Breed, Born On Date, and Weight");
        return;
    }

    try {
        const animal = createAnimalFromForm();
        const response = await fetch(URL, {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(animal)
        });

        const result = await response.json();

        if (response.ok) {
            alert("✅ " + result.message);
            clearForm();
            
        } else {
            alert("❌ " + result.message);
        }
    } catch (error) {
        alert("❌ Error: " + error.message);
    }
}

async function updateAnimal() {
    
    if (!txtId.value) {
        alert("Please enter an ID to update");
        return;
    }

    try {
        const animal = createAnimalFromForm();
        const response = await fetch(`${URL}/${animal.id}`, {
            method: "PUT",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(animal)
        });

        const result = await response.json();

        if (response.ok) {
            alert("✅ " + result.message);
            clearForm();
            
        } else {
            alert("❌ " + result.message);
        }
    } catch (error) {
        alert("❌ Error: " + error.message);
    }
}

async function deleteAnimal() {
    const id = txtId.value;

    if (id === "") {
        alert("Please enter an ID to delete");
        return;
    }

    if (!confirm("Are you sure you want to delete animal with ID " + id + "?")) {
        return;
    }

    try {
        const response = await fetch(`${URL}/${id}`, {
            method: "DELETE"
        });

        const result = await response.json();

        if (response.ok) {
            alert("✅ " + result.message);
            clearForm();
            
        } else {
           
        }
    } catch (error) {
        alert("❌ Error: " + error.message);
    }
}