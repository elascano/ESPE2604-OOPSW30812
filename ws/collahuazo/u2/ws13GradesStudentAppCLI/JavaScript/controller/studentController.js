const Grade = require("../model/grade");
const JsonManager = require("./jsonManager");
const Student = require("../model/student");

class StudentController {
  constructor() {
    this.students = JsonManager.loadStudents();
    this.grades = JsonManager.loadGrades();
  }

  registerStudent(studentId, firstName, lastName, phoneNumber) {
    const newStudent = new Student(studentId, firstName, lastName, phoneNumber);
    this.students.push(newStudent);
    JsonManager.saveStudents(this.students);
  }

  findStudentById(studentId) {
    return this.students.find((student) => student.id.toLowerCase() === studentId.toLowerCase()) || null;
  }

  addGradesToStudent(studentId, values) {
    const student = this.findStudentById(studentId);
    if (!student) {
      return false;
    }

    for (const value of values) {
      if (value < 0 || value > 20) {
        console.log("Error: All grades must be between 0 and 20.");
        return false;
      }
    }

    for (const value of values) {
      this.grades.push(new Grade(studentId, value));
    }

    JsonManager.saveGrades(this.grades);
    return true;
  }

  getGradesByStudent(studentId) {
    return this.grades.filter((grade) => grade.studentId.toLowerCase() === studentId.toLowerCase()).map((grade) => grade.value);
  }

  calculateAverage(studentId) {
    const studentGrades = this.getGradesByStudent(studentId);
    if (studentGrades.length === 0) {
      return 0.0;
    }
    return studentGrades.reduce((sum, value) => sum + value, 0) / studentGrades.length;
  }

  getAllStudents() {
    this.students = JsonManager.loadStudents();
    this.grades = JsonManager.loadGrades();
    return this.students;
  }
}

module.exports = StudentController;
