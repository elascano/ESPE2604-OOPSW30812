function saveAnimal() {

    const id = document.getElementById("txtId").value;
    const breed = document.getElementById("txtBreed").value;
    const weight = document.getElementById("txtWeight").value;
    const bornOn = document.getElementById("txtBornOn").value;
    const animal = document.getElementById("cmbAnimal").value;

    const table = document.getElementById("tblAnimals");

    const row = table.insertRow();

    row.insertCell(0).innerHTML = id;
    row.insertCell(1).innerHTML = breed;
    row.insertCell(2).innerHTML = animal;
    row.insertCell(3).innerHTML = weight;
    row.insertCell(4).innerHTML = bornOn;

    alert("Animal saved successfully");

    document.getElementById("txtId").value = "";
    document.getElementById("txtBreed").value = "";
    document.getElementById("txtWeight").value = "";
    document.getElementById("txtBornOn").value = "";
}