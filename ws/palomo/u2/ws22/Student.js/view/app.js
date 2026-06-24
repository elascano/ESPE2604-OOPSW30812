import Student from "../model/student.js";
import StudentController from "../controller/studentController.js";

const controller = new StudentController();

const txtId = document.getElementById("id");
const txtName = document.getElementById("name");
const txtGrade1 = document.getElementById("grade1");
const txtGrade2 = document.getElementById("grade2");
const result = document.getElementById("result");

document
    .getElementById("btnCreate")
    .addEventListener("click", createStudent);

document
    .getElementById("btnFind")
    .addEventListener("click", findStudent);

document
    .getElementById("btnDelete")
    .addEventListener("click", deleteStudent);

document
    .getElementById("btnUpdate")
    .addEventListener("click", updateStudent);

document
    .getElementById("btnList")
    .addEventListener("click", listStudents);

function createStudent() {

    const student = new Student(
        parseInt(txtId.value),
        txtName.value,
        parseFloat(txtGrade1.value),
        parseFloat(txtGrade2.value)
    );

    controller.create(student);

    alert("Student created");
}

function findStudent() {

    const student =
        controller.findById(parseInt(txtId.value));

    if (student) {

        result.innerHTML =
            `<b>ID:</b> ${student.id}<br>
             <b>Name:</b> ${student.name}<br>
             <b>Average:</b> ${student.getAverage().toFixed(2)}`;
    }
    else {
        result.innerHTML = "Student not found";
    }
}

function deleteStudent() {

    const deleted =
        controller.delete(parseInt(txtId.value));

    if (deleted) {
        alert("Student deleted");
    } else {
        alert("Student not found");
    }
}

function updateStudent() {

    const updated =
        controller.update(
            parseInt(txtId.value),
            txtName.value,
            parseFloat(txtGrade1.value),
            parseFloat(txtGrade2.value)
        );

    if (updated) {
        alert("Student updated");
    } else {
        alert("Student not found");
    }
}

function listStudents() {

    result.innerHTML = "";

    controller.getAll().forEach(student => {

        result.innerHTML +=
            `ID: ${student.id} |
             Name: ${student.name} |
             Average: ${student.getAverage().toFixed(2)}
             <br>`;
    });
}