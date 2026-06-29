const API_URL = '/api';

function formatDate(date) {
    if (!date) return '--';
    const d = new Date(date);
    return d.toISOString().split('T')[0];
}

function calculateAge(bornOn) {
    if (!bornOn) return 0;
    const now = new Date();
    const born = new Date(bornOn);
    return Math.floor((now - born) / (1000 * 60 * 60 * 24 * 30));
}

function getExtraInfo(animal) {
    switch (animal.type) {
        case 'Cow':
            return `Produces milk: ${animal.isProducingMilk ? 'Yes' : 'No'} | Milk: ${(animal.milkProduced || 0).toFixed(2)}L`;
        case 'Chicken':
            return `Eggs/week: ${animal.numberOfEggsPerWeek || 0}${animal.isMolting ? ' (Molting)' : ''}`;
        case 'Pig':
            return `Ideal weight: ${animal.idealWeight || 0}kg${animal.weight >= animal.idealWeight ? ' (Ready!)' : ''}`;
        case 'Sheep':
            return `Last sheering: ${formatDate(animal.lastSheering)}`;
        default:
            return '';
    }
}

document.querySelectorAll('.tab-btn').forEach(btn => {
    btn.addEventListener('click', function() {
        document.querySelectorAll('.tab-btn').forEach(b => b.classList.remove('active'));
        document.querySelectorAll('.tab-content').forEach(t => t.classList.remove('active'));
        this.classList.add('active');
        document.getElementById(`tab-${this.dataset.tab}`).classList.add('active');
    });
});

document.getElementById('animalType').addEventListener('change', function() {
    const type = this.value;
    const label1 = document.getElementById('extraLabel1');
    const label2 = document.getElementById('extraLabel2');
    const extra1 = document.getElementById('extra1');
    const extra2 = document.getElementById('extra2');

    switch (type) {
        case 'Cow':
            label1.textContent = 'Produces Milk (true/false):';
            extra1.value = 'true';
            label2.textContent = 'Milk Produced (liters):';
            extra2.value = '25.5';
            extra2.parentElement.style.display = 'block';
            break;
        case 'Chicken':
            label1.textContent = 'Is Molting (true/false):';
            extra1.value = 'false';
            label2.textContent = 'Eggs Per Week:';
            extra2.value = '5';
            extra2.parentElement.style.display = 'block';
            break;
        case 'Pig':
            label1.textContent = 'Ideal Weight (kg):';
            extra1.value = '130';
            label2.textContent = 'Ready for Slaughter (true/false):';
            extra2.value = 'false';
            extra2.parentElement.style.display = 'block';
            break;
        case 'Sheep':
            label1.textContent = 'Last Sheering Date (YYYY-MM-DD):';
            extra1.value = new Date().toISOString().split('T')[0];
            extra2.parentElement.style.display = 'none';
            break;
    }
});

document.getElementById('registerForm').addEventListener('submit', async function(e) {
    e.preventDefault();
    
    const type = document.getElementById('animalType').value;
    const id = parseInt(document.getElementById('animalId').value);
    const breed = document.getElementById('breed').value;
    const bornOn = document.getElementById('bornOn').value;
    const weight = parseFloat(document.getElementById('weight').value);
    const extra1 = document.getElementById('extra1').value;
    const extra2 = document.getElementById('extra2').value;

    const animalData = { type, id, breed, bornOn, weight };

    switch (type) {
        case 'Cow':
            animalData.isProducingMilk = extra1.toLowerCase() === 'true';
            break;
        case 'Chicken':
            animalData.isMolting = extra1.toLowerCase() === 'true';
            animalData.numberOfEggsPerWeek = parseInt(extra2) || 0;
            break;
        case 'Pig':
            animalData.idealWeight = parseFloat(extra1) || 0;
            break;
        case 'Sheep':
            animalData.lastSheering = extra1;
            break;
    }

    try {
        const response = await fetch(`${API_URL}/animals`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(animalData)
        });

        const result = await response.json();
        const resultDiv = document.getElementById('registerResult');
        
        if (response.ok) {
            resultDiv.innerHTML = `<div style="color: green; background: #d4edda; padding: 15px; border-radius: 5px;">
                ✅ ${result.message}<br>Type: ${type}<br>ID: ${id}<br>Breed: ${breed}
            </div>`;
            this.reset();
            document.getElementById('bornOn').value = new Date().toISOString().split('T')[0];
            loadAnimals();
        } else {
            resultDiv.innerHTML = `<div style="color: red; background: #f8d7da; padding: 15px; border-radius: 5px;">
                ❌ Error: ${result.error}
            </div>`;
        }
    } catch (error) {
        document.getElementById('registerResult').innerHTML = 
            `<div style="color: red; background: #f8d7da; padding: 15px; border-radius: 5px;">
                ❌ Error: ${error.message}
            </div>`;
    }
});

async function loadAnimals(filter = 'All') {
    try {
        const url = filter === 'All' ? `${API_URL}/animals` : `${API_URL}/animals/type/${filter}`;
        const response = await fetch(url);
        const animals = await response.json();

        const tbody = document.getElementById('tableBody');
        tbody.innerHTML = '';

        if (!animals || animals.length === 0) {
            tbody.innerHTML = '<tr><td colspan="7" style="text-align:center;">No animals registered</td></tr>';
            return;
        }

        animals.forEach(animal => {
            const tr = document.createElement('tr');
            tr.innerHTML = `
                <td>${animal.id}</td>
                <td>${animal.type}</td>
                <td>${animal.breed}</td>
                <td>${formatDate(animal.bornOn)}</td>
                <td>${animal.weight.toFixed(1)}</td>
                <td>${calculateAge(animal.bornOn)}</td>
                <td>${getExtraInfo(animal)}</td>
            `;
            tr.addEventListener('click', function() {
                document.querySelectorAll('#animalTable tbody tr').forEach(r => r.style.background = '');
                this.style.background = '#d4edda';
            });
            tbody.appendChild(tr);
        });
    } catch (error) {
        console.error('Error loading animals:', error);
    }
}

document.getElementById('filterBtn').addEventListener('click', function() {
    const filter = document.getElementById('filterType').value;
    loadAnimals(filter);
});

document.getElementById('refreshBtn').addEventListener('click', function() {
    loadAnimals(document.getElementById('filterType').value);
});

document.getElementById('deleteBtn').addEventListener('click', async function() {
    const selected = document.querySelector('#animalTable tbody tr[style*="background: #d4edda"]');
    if (!selected) {
        alert('Please select an animal from the table first');
        return;
    }

    const id = parseInt(selected.children[0].textContent);
    const type = selected.children[1].textContent;

    if (!confirm(`Are you sure you want to delete this animal?\nID: ${id}\nType: ${type}`)) return;

    try {
        const response = await fetch(`${API_URL}/animals/${id}`, { method: 'DELETE' });
        const result = await response.json();
        
        if (response.ok) {
            alert('Animal deleted successfully');
            loadAnimals(document.getElementById('filterType').value);
        } else {
            alert(`Error: ${result.error}`);
        }
    } catch (error) {
        alert(`Error: ${error.message}`);
    }
});

document.getElementById('milkBtn').addEventListener('click', async function() {
    try {
        const response = await fetch(`${API_URL}/statistics/milk`);
        const data = await response.json();
        document.getElementById('businessResult').textContent = 
            `=== TOTAL MILK PRODUCTION ===\nTotal milk produced: ${data.totalMilk} liters`;
    } catch (error) {
        document.getElementById('businessResult').textContent = `Error: ${error.message}`;
    }
});

document.getElementById('eggsBtn').addEventListener('click', async function() {
    try {
        const response = await fetch(`${API_URL}/statistics/eggs`);
        const data = await response.json();
        document.getElementById('businessResult').textContent = 
            `=== TOTAL EGG PRODUCTION ===\nTotal eggs per week: ${data.totalEggs}`;
    } catch (error) {
        document.getElementById('businessResult').textContent = `Error: ${error.message}`;
    }
});

document.getElementById('readyPigsBtn').addEventListener('click', async function() {
    try {
        const response = await fetch(`${API_URL}/statistics/ready-pigs`);
        const pigs = await response.json();
        let text = '=== PIGS READY FOR SLAUGHTER ===\n';
        if (pigs.length === 0) {
            text += 'No pigs ready for slaughter.';
        } else {
            pigs.forEach(pig => {
                text += `ID: ${pig.id}, Breed: ${pig.breed}, Weight: ${pig.weight}kg, Ideal Weight: ${pig.idealWeight}kg\n`;
            });
        }
        document.getElementById('businessResult').textContent = text;
    } catch (error) {
        document.getElementById('businessResult').textContent = `Error: ${error.message}`;
    }
});

document.getElementById('searchBtn').addEventListener('click', async function() {
    const id = prompt('Enter the animal ID to search:');
    if (!id) return;

    try {
        const response = await fetch(`${API_URL}/animals/${id}`);
        if (!response.ok) {
            document.getElementById('businessResult').textContent = `Animal with ID ${id} not found`;
            return;
        }
        const animal = await response.json();
        let text = '=== ANIMAL FOUND ===\n';
        text += `ID: ${animal.id}\n`;
        text += `Type: ${animal.type}\n`;
        text += `Breed: ${animal.breed}\n`;
        text += `Born On: ${formatDate(animal.bornOn)}\n`;
        text += `Weight: ${animal.weight} kg\n`;
        text += `Age: ${calculateAge(animal.bornOn)} months\n`;
        text += `Extra: ${getExtraInfo(animal)}`;
        document.getElementById('businessResult').textContent = text;
    } catch (error) {
        document.getElementById('businessResult').textContent = `Error: ${error.message}`;
    }
});

document.getElementById('clearResultBtn').addEventListener('click', function() {
    document.getElementById('businessResult').textContent = '';
});

document.getElementById('generateStatsBtn').addEventListener('click', async function() {
    try {
        const response = await fetch(`${API_URL}/statistics`);
        const stats = await response.json();
        let text = '=== ZOO STATISTICS ===\n';
        text += `Total animals: ${stats.total}\n`;
        text += `├─ Cows: ${stats.cows}\n`;
        text += `├─ Chickens: ${stats.chickens}\n`;
        text += `├─ Pigs: ${stats.pigs}\n`;
        text += `└─ Sheep: ${stats.sheep}\n`;
        text += `Total weight: ${stats.totalWeight.toFixed(2)} kg\n`;
        text += `Average weight: ${stats.averageWeight.toFixed(2)} kg`;
        document.getElementById('statsResult').textContent = text;
    } catch (error) {
        document.getElementById('statsResult').textContent = `Error: ${error.message}`;
    }
});

loadAnimals();