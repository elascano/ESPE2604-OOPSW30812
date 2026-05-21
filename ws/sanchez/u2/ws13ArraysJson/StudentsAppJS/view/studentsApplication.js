const Student = require('../model/Student');
const jsonManager = require('../model/jsonManager');
const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let students = jsonManager.readStudents();

function question(prompt) {
    return new Promise((resolve) => {
        rl.question(prompt, resolve);
    });
}

async function showMenu() {
    console.log("\n===== STUDENT MENU =====");
    console.log("1. Display JSON data");
    console.log("2. Enter student data");
    console.log("3. Reload JSON file");
    console.log("4. Calculate average (select student)");
    console.log("5. Exit");
    return await question("Choose: ");
}

async function addStudent() {
    const firstName = await question("First Name: ");
    const lastName = await question("Last Name: ");
    const subject = await question("Subject: ");
    const age = parseInt(await question("Age: "));
    
    const grades = [];
    for (let i = 1; i <= 3; i++) {
        let grade;
        do {
            grade = parseInt(await question(`Grade ${i} (0-20): `));
        } while (grade < 0 || grade > 20);
        grades.push(grade);
    }
    
    students.push(new Student(firstName, lastName, subject, age, grades));
    jsonManager.saveStudents(students);
    console.log("Student added successfully!");
}

function displayJson() {
    if (students.length === 0) {
        console.log("No students found.");
        return;
    }
    console.log("\n===== STUDENTS =====");
    for (let i = 0; i < students.length; i++) {
        console.log(`\nStudent #${i + 1}`);
        console.log(students[i].toString());
    }
}

function readJson() {
    students = jsonManager.readStudents();
    console.log("File reloaded successfully.");
}

async function calculateAverageByStudent() {
    if (students.length === 0) {
        console.log("No students available.");
        return;
    }
    console.log("\nSelect student:");
    for (let i = 0; i < students.length; i++) {
        console.log(`${i + 1}. ${students[i].firstName} ${students[i].lastName}`);
    }
    const index = parseInt(await question("Enter number: ")) - 1;
    if (index >= 0 && index < students.length) {
        const s = students[index];
        console.log(`Average of ${s.firstName}: ${s.getAverage().toFixed(2)}`);
    } else {
        console.log("Invalid student selection.");
    }
}

async function main() {
    let option;
    do {
        option = parseInt(await showMenu());
        if (option === 1) displayJson();
        else if (option === 2) await addStudent();
        else if (option === 3) readJson();
        else if (option === 4) await calculateAverageByStudent();
        else if (option === 5) console.log("Exiting...");
        else console.log("Invalid option");
    } while (option !== 5);
    rl.close();
}

main();