import fs from "fs";

import Student from "./Student.js";
import Teacher from "./Teacher.js";

// SAVE STUDENT CSV
export function saveStudentCSV(student) {

    const data =
        `${student.id},${student.name},${student.course}\n`;

    fs.appendFileSync("students.csv", data);
}

// SAVE TEACHER CSV
export function saveTeacherCSV(teacher) {

    const data =
        `${teacher.id},${teacher.name},${teacher.career}\n`;

    fs.appendFileSync("teachers.csv", data);
}

// READ STUDENTS CSV
export function readStudentsCSV() {

    let students = [];

    if (!fs.existsSync("students.csv")) {
        return students;
    }

    const data =
        fs.readFileSync("students.csv", "utf-8");

    const lines = data.split("\n");

    for (let line of lines) {

        if (line.trim() !== "") {

            const values = line.split(",");

            const student = new Student(
                Number(values[0]),
                values[1],
                values[2]
            );

            students.push(student);
        }
    }

    return students;
}

// READ TEACHERS CSV
export function readTeachersCSV() {

    let teachers = [];

    if (!fs.existsSync("teachers.csv")) {
        return teachers;
    }

    const data =
        fs.readFileSync("teachers.csv", "utf-8");

    const lines = data.split("\n");

    for (let line of lines) {

        if (line.trim() !== "") {

            const values = line.split(",");

            const teacher = new Teacher(
                Number(values[0]),
                values[1],
                values[2]
            );

            teachers.push(teacher);
        }
    }

    return teachers;
}

// SAVE STUDENT JSON
export function saveStudentJSON(student) {

    let students = [];

    if (fs.existsSync("students.json")) {

        const data =
            fs.readFileSync("students.json", "utf-8");

        if (data.trim() !== "") {
            students = JSON.parse(data);
        }
    }

    students.push(student);

    fs.writeFileSync(
        "students.json",
        JSON.stringify(students, null, 4)
    );
}

// SAVE TEACHER JSON
export function saveTeacherJSON(teacher) {

    let teachers = [];

    if (fs.existsSync("teachers.json")) {

        const data =
            fs.readFileSync("teachers.json", "utf-8");

        if (data.trim() !== "") {
            teachers = JSON.parse(data);
        }
    }

    teachers.push(teacher);

    fs.writeFileSync(
        "teachers.json",
        JSON.stringify(teachers, null, 4)
    );
}

// READ STUDENTS JSON
export function readStudentsJSON() {

    let students = [];

    if (!fs.existsSync("students.json")) {
        return students;
    }

    const data =
        fs.readFileSync("students.json", "utf-8");

    if (data.trim() === "") {
        return students;
    }

    const jsonData = JSON.parse(data);

    for (let item of jsonData) {

        const student = new Student(
            item.id,
            item.name,
            item.course
        );

        students.push(student);
    }

    return students;
}

// READ TEACHERS JSON
export function readTeachersJSON() {

    let teachers = [];

    if (!fs.existsSync("teachers.json")) {
        return teachers;
    }

    const data =
        fs.readFileSync("teachers.json", "utf-8");

    if (data.trim() === "") {
        return teachers;
    }

    const jsonData = JSON.parse(data);

    for (let item of jsonData) {

        const teacher = new Teacher(
            item.id,
            item.name,
            item.career
        );

        teachers.push(teacher);
    }

    return teachers;
}