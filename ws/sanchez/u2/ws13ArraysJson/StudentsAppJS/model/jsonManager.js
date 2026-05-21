const fs = require('fs');
const path = require('path');
const Student = require('./Student');

const FILE_NAME = path.join(__dirname, '..', 'student.json');

function saveStudents(students) {
    try {
        const data = [];
        for (let s of students) {
            data.push({
                first_name: s.firstName,
                last_name: s.lastName,
                subject: s.subject,
                age: s.age,
                grades: s.grades
            });
        }
        fs.writeFileSync(FILE_NAME, JSON.stringify(data, null, 4));
        console.log("\nData saved successfully!");
    } catch (e) {
        console.log(`Error saving file: ${e.message}`);
    }
}

function readStudents() {
    if (!fs.existsSync(FILE_NAME)) return [];
    try {
        const data = JSON.parse(fs.readFileSync(FILE_NAME, 'utf8'));
        const students = [];
        for (let item of data) {
            students.push(new Student(
                item.first_name,
                item.last_name,
                item.subject,
                item.age,
                item.grades
            ));
        }
        return students;
    } catch (e) {
        console.log(`Error reading file: ${e.message}`);
        return [];
    }
}

module.exports = { saveStudents, readStudents };