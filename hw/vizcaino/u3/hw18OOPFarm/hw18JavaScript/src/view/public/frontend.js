const fields = ['cowFields', 'pigFields', 'chickenFields', 'sheepFields'];
const actions = ['cowAction', 'pigAction', 'chickenAction', 'sheepAction'];

function switchAnimalType() {
    const type = document.getElementById('animalSelector').value;
    document.getElementById('formTitle').innerText = `${type} Form`;
    
    fields.forEach(f => document.getElementById(f).classList.add('hidden'));
    actions.forEach(a => document.getElementById(a).classList.add('hidden'));

    document.getElementById(`${type.toLowerCase()}Fields`).classList.remove('hidden');
    document.getElementById(`${type.toLowerCase()}Action`).classList.remove('hidden');
    loadTable();
}

async function loadTable() {
    const type = document.getElementById('animalSelector').value;
    const res = await fetch(`/api/animals/${type}`);
    const data = await res.json();
    
    const header = document.getElementById('tableHeader');
    const body = document.getElementById('tableBody');
    body.innerHTML = "";

    let commonHeaders = `<th>ID</th><th>Raza (Breed)</th><th>Edad (Meses)</th><th>Peso (kg)</th>`;
    if (type === 'Cow') header.innerHTML = commonHeaders + `<th>Produciendo?</th><th>Prod. Leche (L)</th>`;
    else if (type === 'Pig') header.innerHTML = commonHeaders + `<th>Peso Ideal</th><th>Corral #</th><th>Estado</th>`;
    else if (type === 'Chicken') header.innerHTML = commonHeaders + `<th>Pelecha?</th><th>Huevos/Semana</th><th>Color Huevo</th>`;
    else if (type === 'Sheep') header.innerHTML = commonHeaders + `<th>Última Esquila</th><th>Calidad Lana</th>`;

    data.forEach(a => {
        let row = `<tr><td>${a.id}</td><td>${a.breed}</td><td>${a.ageInMonths}</td><td>${a.weight}</td>`;
        if (type === 'Cow') row += `<td>${a.isProducingMilk}</td><td>${a.dailyMilkYield}L</td>`;
        else if (type === 'Pig') row += `<td>${a.idealWeight}kg</td><td>${a.penNumber}</td><td>${a.slaughterStatus}</td>`;
        else if (type === 'Chicken') row += `<td>${a.isMolting}</td><td>${a.numberOfEggsPerWeek}</td><td>${a.eggColor}</td>`;
        else if (type === 'Sheep') row += `<td>${a.lastSheering}</td><td>${a.woolQuality}</td>`;
        row += `</tr>`;
        body.innerHTML += row;
    });
}

function getFormData() {
    const type = document.getElementById('animalSelector').value;
    return {
        type,
        id: document.getElementById('animalId').value,
        breed: document.getElementById('breed').value,
        bornOn: document.getElementById('bornOn').value,
        weight: document.getElementById('weight').value,
        isProducingMilk: document.getElementById('isProducingMilk').value,
        dailyMilkYield: document.getElementById('dailyMilkYield').value,
        idealWeight: document.getElementById('idealWeight').value,
        penNumber: document.getElementById('penNumber').value,
        isMolting: document.getElementById('isMolting').value,
        numberOfEggsPerWeek: document.getElementById('numberOfEggsPerWeek').value,
        eggColor: document.getElementById('eggColor').value,
        lastSheering: document.getElementById('lastSheering').value,
        woolQuality: document.getElementById('woolQuality').value
    };
}

async function saveAnimal() {
    const res = await fetch('/api/animals', { method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify(getFormData()) });
    const data = await res.json();
    alert(data.message || data.error);
    loadTable();
}

async function updateAnimal() {
    const res = await fetch('/api/animals', { method: 'PUT', headers: {'Content-Type': 'application/json'}, body: JSON.stringify(getFormData()) });
    const data = await res.json();
    alert(data.message || data.error);
    loadTable();
}

async function deleteAnimal() {
    const id = document.getElementById('deleteId').value;
    const type = document.getElementById('animalSelector').value;
    if(!id) return alert("Ingresa una ID");
    const res = await fetch(`/api/animals/${type}/${id}`, { method: 'DELETE' });
    const data = await res.json();
    alert(data.message || data.error);
    loadTable();
}

function updateLogs(logArray) {
    const display = document.getElementById('logsDisplay');
    display.innerHTML = logArray.map(l => `<div>${l}</div>`).join('');
}

async function triggerFeed() {
    const id = document.getElementById('animalId').value;
    const type = document.getElementById('animalSelector').value;
    if(!id) return alert("Ingresa la ID del animal en el formulario");
    const res = await fetch('/api/actions/feed', { method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify({type, id}) });
    const data = await res.json();
    if(data.log) updateLogs(data.log);
    loadTable();
}

async function triggerMilk() {
    const id = document.getElementById('animalId').value;
    const liters = document.getElementById('milkInput').value;
    if(!id) return alert("Ingresa la ID");
    const res = await fetch('/api/actions/milk', { method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify({id, liters}) });
    const data = await res.json();
    if(data.log) updateLogs(data.log);
    loadTable();
}

async function triggerLayEgg() {
    const id = document.getElementById('animalId').value;
    if(!id) return alert("Ingresa la ID");
    const res = await fetch('/api/actions/layegg', { method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify({id}) });
    const data = await res.json();
    if(data.log) updateLogs(data.log);
    loadTable();
}

async function triggerShear() {
    const id = document.getElementById('animalId').value;
    if(!id) return alert("Ingresa la ID");
    const res = await fetch('/api/actions/shear', { method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify({id}) });
    const data = await res.json();
    if(data.log) updateLogs(data.log);
    loadTable();
}

async function triggerCut() {
    const id = document.getElementById('animalId').value;
    if(!id) return alert("Ingresa la ID");
    const res = await fetch('/api/actions/cut', { method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify({id}) });
    const data = await res.json();
    alert(data.message);
    if(data.log) updateLogs(data.log);
    loadTable();
}

window.onload = switchAnimalType;