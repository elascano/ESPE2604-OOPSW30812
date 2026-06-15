const fs = require("fs");
const path = require("path");
const Student = require("../model/student");
const Grade = require("../model/grade");

const ROOT_PATH = path.resolve(__dirname, "..");
const STUDENTS_FILE = path.join(ROOT_PATH, "students.json");
const GRADES_FILE = path.join(ROOT_PATH, "grades.json");

class JsonManager {
  static saveStudents(students) {
    fs.writeFileSync(STUDENTS_FILE, JSON.stringify(students.map((student) => student.toJson()), null, 2), "utf8");
  }

  static loadStudents() {
    if (!fs.existsSync(STUDENTS_FILE)) {
      return [];
    }
    const data = JSON.parse(fs.readFileSync(STUDENTS_FILE, "utf8"));
    return Array.isArray(data) ? data.map((item) => Student.fromJson(item)) : [];
  }

  static saveGrades(grades) {
    fs.writeFileSync(GRADES_FILE, JSON.stringify(grades.map((grade) => grade.toJson()), null, 2), "utf8");
  }

  static loadGrades() {
    if (!fs.existsSync(GRADES_FILE)) {
      return [];
    }
    const data = JSON.parse(fs.readFileSync(GRADES_FILE, "utf8"));
    return Array.isArray(data) ? data.map((item) => Grade.fromJson(item)) : [];
  }
}

module.exports = JsonManager;
