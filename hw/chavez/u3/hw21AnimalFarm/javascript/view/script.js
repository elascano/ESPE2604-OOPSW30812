const button = document.getElementById("btnSave");

button.addEventListener("click", () => {

    const animal = {
        id: document.getElementById("id").value,
        breed: document.getElementById("breed").value,
        age: document.getElementById("age").value,
        weight: document.getElementById("weight").value
    };

    console.log(animal);

    alert("Animal registered successfully!");
});