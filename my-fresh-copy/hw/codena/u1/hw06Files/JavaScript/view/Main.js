import promptSync from "prompt-sync";

import Student from "../model/Student.js";
import Teacher from "../model/Teacher.js";

import {
    saveStudentCSV,
    saveTeacherCSV,
    readStudentsCSV,
    readTeachersCSV,
    saveStudentJSON,
    saveTeacherJSON,
    readStudentsJSON,
    readTeachersJSON
} from "../model/FileManager.js";

const prompt = promptSync();

let running = true;

while (running) {

    console.log("\n=== MENU ===");
    console.log("1. Add Student");
    console.log("2. Add Teacher");
    console.log("3. Show Students CSV");
    console.log("4. Show Teachers CSV");
    console.log("5. Show Students JSON");
    console.log("6. Show Teachers JSON");
    console.log("7. Exit");

    let option =
        Number(prompt("Choose an option: "));

    switch (option) {

        case 1:

            console.log("\n--- ENTER STUDENT DATA ---");

            let sId =
                Number(prompt("ID: "));

            let sName =
                prompt("Name: ");

            let sCourse =
                prompt("Course: ");

            let student = new Student(
                sId,
                sName,
                sCourse
            );

            saveStudentCSV(student);
            saveStudentJSON(student);

            console.log("Student saved.");

            break;

        case 2:

            console.log("\n--- ENTER TEACHER DATA ---");

            let tId =
                Number(prompt("ID: "));

            let tName =
                prompt("Name: ");

            let tCareer =
                prompt("Career: ");

            let teacher = new Teacher(
                tId,
                tName,
                tCareer
            );

            saveTeacherCSV(teacher);
            saveTeacherJSON(teacher);

            console.log("Teacher saved.");

            break;

        case 3:

            console.log("\n--- STUDENTS CSV ---");

            let studentsCSV =
                readStudentsCSV();

            for (let student of studentsCSV) {
                console.log(student.toString());
            }

            break;

        case 4:

            console.log("\n--- TEACHERS CSV ---");

            let teachersCSV =
                readTeachersCSV();

            for (let teacher of teachersCSV) {
                console.log(teacher.toString());
            }

            break;

        case 5:

            console.log("\n--- STUDENTS JSON ---");

            let studentsJSON =
                readStudentsJSON();

            for (let student of studentsJSON) {
                console.log(student.toString());
            }

            break;

        case 6:

            console.log("\n--- TEACHERS JSON ---");

            let teachersJSON =
                readTeachersJSON();

            for (let teacher of teachersJSON) {
                console.log(teacher.toString());
            }

            break;

        case 7:

            running = false;

            console.log("Program finished.");

            break;

        default:

            console.log("Invalid option.");
    }
}