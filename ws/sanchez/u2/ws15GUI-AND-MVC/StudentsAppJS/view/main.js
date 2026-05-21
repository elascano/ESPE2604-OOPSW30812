// view/main.js
// Controlador principal de la aplicación

import { Student } from '../model/student.js';
import { JsonManager } from '../model/jsonManager.js';

// Estado de la aplicación
let students = [];
let tempSubjectsGrades = new Map();
let currentSubject = "";
let selectedRow = -1;
let selectedSubjectIndex = -1;

// Cargar datos al iniciar
async function loadData() {
    students = JsonManager.readStudents();
    loadStudentTable();
    updateStatusBar();
}

// Parsear nota (acepta enteros, decimales y coma)
function parseGrade(input) {
    let value = input.trim().replace(',', '.');
    let grade = parseFloat(value);
    if (isNaN(grade)) throw new Error("Invalid number");
    if (grade < 0 || grade > 20) throw new Error("Grade out of range (0-20)");
    return Math.round(grade * 100) / 100;
}

// Cargar tabla de estudiantes
function loadStudentTable() {
    const tbody = document.getElementById("tableBody");
    tbody.innerHTML = "";
    
    students.forEach((student, index) => {
        const subjects = student.getSubjectNames().join(", ");
        const avg = student.getOverallAverage().toFixed(2);
        const row = tbody.insertRow();
        
        row.onclick = () => {
            document.querySelectorAll("#studentTable tbody tr").forEach(r => r.classList.remove("selected"));
            row.classList.add("selected");
            selectedRow = index;
        };
        
        row.insertCell(0).textContent = student.firstName;
        row.insertCell(1).textContent = student.lastName;
        row.insertCell(2).textContent = student.age;
        row.insertCell(3).textContent = subjects || "No subjects";
        row.insertCell(4).textContent = avg;
    });
    
    updateStatusBar();
}

// Mostrar diálogo para ingresar notas
function showGradeDialog() {
    const subject = document.getElementById("cbSubjects").value;
    currentSubject = subject;
    
    document.getElementById("grade1").value = "";
    document.getElementById("grade2").value = "";
    document.getElementById("grade3").value = "";
    document.getElementById("dialogTitle").innerHTML = `📝 Enter grades for ${subject}`;
    document.getElementById("gradeDialog").style.display = "flex";
}

// Guardar notas desde el diálogo
function saveGrades() {
    try {
        let grades = [];
        for (let i = 1; i <= 3; i++) {
            let grade = parseGrade(document.getElementById(`grade${i}`).value);
            grades.push(grade);
        }
        
        tempSubjectsGrades.set(currentSubject, grades);
        renderSubjectList();
        document.getElementById("gradeDialog").style.display = "none";
        updateStatusMessage(`✅ Grades saved for ${currentSubject}`);
        alert(`✅ Grades saved for ${currentSubject}\n\nGrades: ${grades.join(", ")}`);
    } catch (error) {
        alert(`❌ ${error.message}\nUse: 15 (integer) or 15.5 (decimal)`);
    }
}

// Renderizar lista de materias temporales
function renderSubjectList() {
    const list = document.getElementById("subjectList");
    list.innerHTML = "";
    
    let index = 0;
    for (let [subject, grades] of tempSubjectsGrades) {
        const li = document.createElement("li");
        li.textContent = `${subject} → [${grades.join(", ")}]`;
        li.onclick = (e) => {
            e.stopPropagation();
            document.querySelectorAll("#subjectList li").forEach(l => l.classList.remove("selected"));
            li.classList.add("selected");
            selectedSubjectIndex = index;
        };
        list.appendChild(li);
        index++;
    }
}

// Guardar estudiante desde el formulario rápido
function saveQuickStudent() {
    const firstName = document.getElementById("txtFirstName").value.trim();
    const lastName = document.getElementById("txtLastName").value.trim();
    const age = parseInt(document.getElementById("txtAge").value);
    
    if (!firstName || !lastName) {
        alert("❌ Please enter first and last name");
        return;
    }
    
    if (isNaN(age) || age < 0 || age > 120) {
        alert("❌ Age must be between 0 and 120");
        return;
    }
    
    if (tempSubjectsGrades.size === 0) {
        alert("⚠️ Add at least one subject with grades");
        return;
    }
    
    // Convertir tempSubjectsGrades a objeto
    const subjectsGrades = {};
    for (let [subject, grades] of tempSubjectsGrades) {
        subjectsGrades[subject] = [...grades];
    }
    
    const student = new Student(firstName, lastName, age, subjectsGrades);
    students.push(student);
    JsonManager.saveStudents(students);
    
    loadStudentTable();
    clearQuickForm();
    updateStatusMessage("🎉 Student saved successfully!");
    
    alert(`🎉 Student saved successfully!\n\nName: ${firstName} ${lastName}\nSubjects: ${Object.keys(subjectsGrades).length}\nOverall Average: ${student.getOverallAverage().toFixed(2)}`);
    
    if (confirm("View in list?")) {
        document.querySelector(".tab-btn[data-tab='list']").click();
    }
}

// Limpiar formulario
function clearQuickForm() {
    document.getElementById("txtFirstName").value = "";
    document.getElementById("txtLastName").value = "";
    document.getElementById("txtAge").value = "";
    tempSubjectsGrades.clear();
    renderSubjectList();
    selectedSubjectIndex = -1;
    updateStatusMessage("Form cleared");
}

// Eliminar estudiante seleccionado
function deleteSelectedStudent() {
    if (selectedRow === -1) {
        alert("Please select a student to delete");
        return;
    }
    
    const student = students[selectedRow];
    if (confirm(`Delete ${student.firstName} ${student.lastName}?`)) {
        students.splice(selectedRow, 1);
        JsonManager.saveStudents(students);
        loadStudentTable();
        selectedRow = -1;
        updateStatusMessage("🗑️ Student deleted successfully");
        alert("Student deleted!");
    }
}

// Mostrar diálogo de promedios
function showAverageDialog() {
    if (students.length === 0) {
        alert("No students registered");
        return;
    }
    
    let message = "═".repeat(55) + "\n";
    message += "              CLASS AVERAGES REPORT\n";
    message += "═".repeat(55) + "\n\n";
    
    let classTotal = 0;
    for (const student of students) {
        const avg = student.getOverallAverage();
        classTotal += avg;
        message += `📌 ${student.firstName.padEnd(15)} ${student.lastName.padEnd(15)} → ${avg.toFixed(2)}\n`;
    }
    
    message += "\n" + "═".repeat(55) + "\n";
    message += `🏆 CLASS AVERAGE: ${(classTotal / students.length).toFixed(2)}\n`;
    message += "═".repeat(55) + "\n";
    
    alert(message);
}

// Recargar datos
function reloadData() {
    students = JsonManager.readStudents();
    loadStudentTable();
    updateStatusMessage("🔄 Data reloaded from localStorage");
    alert("✅ Data reloaded successfully!");
}

// Exportar JSON
function exportJSON() {
    JsonManager.exportToFile();
    updateStatusMessage("💾 JSON exported");
}

// Importar JSON
function importJSON(file) {
    if (!file) return;
    JsonManager.importFromFile(file, (success, error) => {
        if (success) {
            reloadData();
            updateStatusMessage("📂 JSON imported successfully");
            alert("✅ Data imported successfully!");
        } else {
            alert(`❌ Error importing: ${error}`);
        }
    });
}

// Eliminar materia seleccionada
function removeSelectedSubject() {
    if (selectedSubjectIndex !== -1) {
        const subjects = Array.from(tempSubjectsGrades.keys());
        const subject = subjects[selectedSubjectIndex];
        tempSubjectsGrades.delete(subject);
        renderSubjectList();
        selectedSubjectIndex = -1;
        updateStatusMessage(`Removed: ${subject}`);
    }
}

// Mostrar pestaña de agregar
function showAddTab() {
    document.querySelector(".tab-btn[data-tab='add']").click();
}

// Actualizar barra de estado
function updateStatusMessage(message) {
    const statusBar = document.getElementById("statusBar");
    statusBar.innerHTML = ` ${message} | Total students: ${students.length}`;
}

function updateStatusBar() {
    const statusBar = document.getElementById("statusBar");
    statusBar.innerHTML = ` ✅ Ready | Total students: ${students.length} | Accepts integers (15) and decimals (15.5)`;
}

// Inicializar eventos
function init() {
    loadData();
    
    // Cambio de pestañas
    document.querySelectorAll(".tab-btn").forEach(btn => {
        btn.addEventListener("click", () => {
            const tab = btn.dataset.tab;
            document.querySelectorAll(".tab-btn").forEach(b => b.classList.remove("active"));
            document.querySelectorAll(".tab-content").forEach(c => c.classList.remove("active"));
            btn.classList.add("active");
            document.getElementById(`tab-${tab}`).classList.add("active");
        });
    });
    
    // Botones principales
    document.getElementById("btnAddStudent").addEventListener("click", showAddTab);
    document.getElementById("btnReload").addEventListener("click", reloadData);
    document.getElementById("btnAverage").addEventListener("click", showAverageDialog);
    document.getElementById("btnExit").addEventListener("click", () => window.close());
    
    // Botones de la tabla
    document.getElementById("btnRefresh").addEventListener("click", loadStudentTable);
    document.getElementById("btnDelete").addEventListener("click", deleteSelectedStudent);
    document.getElementById("btnExport").addEventListener("click", exportJSON);
    
    // Importar archivo
    document.getElementById("btnImport").addEventListener("change", (e) => {
        if (e.target.files.length > 0) {
            importJSON(e.target.files[0]);
            e.target.value = "";
        }
    });
    
    // Botones del formulario
    document.getElementById("btnAddSubject").addEventListener("click", showGradeDialog);
    document.getElementById("btnRemoveSubject").addEventListener("click", removeSelectedSubject);
    document.getElementById("btnSave").addEventListener("click", saveQuickStudent);
    document.getElementById("btnClear").addEventListener("click", clearQuickForm);
    
    // Botones del modal
    document.getElementById("btnSaveGrades").addEventListener("click", saveGrades);
    document.getElementById("btnCancelGrades").addEventListener("click", () => {
        document.getElementById("gradeDialog").style.display = "none";
    });
    
    // Cerrar modal al hacer clic fuera
    window.onclick = (event) => {
        const modal = document.getElementById("gradeDialog");
        if (event.target === modal) {
            modal.style.display = "none";
        }
    };
}

// Iniciar aplicación
init();