
const EmployeeModel = require('../model/EmployeeModel');
const model = new EmployeeModel();


model.loadFromFile();
updateUI();

document.getElementById('employeeForm').addEventListener('submit', function(e) {
    e.preventDefault(); // Stop page from refreshing

    
    const id = document.getElementById('empId').value.trim();
    const name = document.getElementById('empName').value.trim();
    const clockIn = document.getElementById('clockIn').value;
    const clockOut = document.getElementById('clockOut').value;
    const role = document.getElementById('role').value.trim();
    const salary = parseFloat(document.getElementById('salary').value);

    
    if (isNaN(salary) || salary < 0) {
        alert("Please enter a valid salary amount.");
        return;
    }

   
    model.addEmployee(id, name, clockIn, clockOut, role, salary);
    
    if (model.saveToFile()) {
        alert("Employee saved successfully to JSON!");
        document.getElementById('employeeForm').reset(); 
        updateUI();
    } else {
        alert("Error saving employee data.");
    }
});

function updateUI() {
    const tbody = document.querySelector('#employeeTable tbody');
    tbody.innerHTML = ''; 

    const employees = model.getEmployees();
    employees.forEach(emp => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.clockIn}</td>
            <td>${emp.clockOut}</td>
            <td>${emp.role}</td>
            <td>$${emp.salary.toFixed(2)}</td>
        `;
        tbody.appendChild(row);
    });

    
    const total = model.calculateTotalSalaries();
    document.getElementById('totalSalary').textContent = total.toFixed(2);
}

