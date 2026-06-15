const readline = require("readline");
const StudentController = require("../controller/studentController");

class GradesStudentApp {
  constructor() {
    this.controller = new StudentController();
    this.rl = readline.createInterface({
      input: process.stdin,
      output: process.stdout,
    });
  }

  ask(question) {
    return new Promise((resolve) => {
      this.rl.question(question, resolve);
    });
  }

  async main() {
    while (true) {
      console.log("\n==================================");
      console.log("       STUDENT GRADES SYSTEM      ");
      console.log("==================================");
      console.log("1. Register Student");
      console.log("2. Input Grades (Option A)");
      console.log("3. Grades and Students Report");
      console.log("4. Exit");

      const optionInput = await this.ask("Select an option: ");
      const option = Number(optionInput.trim());

      if (Number.isNaN(option)) {
        console.log("Invalid input. Please enter a number.");
        continue;
      }

      if (option === 1) {
        const studentId = (await this.ask("Enter ID: ")).trim();
        const firstName = (await this.ask("Enter First Name: ")).trim();
        const lastName = (await this.ask("Enter Last Name: ")).trim();
        const phone = (await this.ask("Enter Phone Number: ")).trim();

        this.controller.registerStudent(studentId, firstName, lastName, phone);
        console.log("Student registered successfully!");
      } else if (option === 2) {
        const students = this.controller.getAllStudents();
        console.log("\n--- Registered Students ---");

        if (students.length === 0) {
          console.log("No students found. Register one first.");
          continue;
        }

        for (const student of students) {
          console.log(`ID: ${student.id} | Name: ${student.firstName} ${student.lastName}`);
        }

        const targetId = (await this.ask("\nEnter the ID of the student to add grades: ")).trim();
        if (!this.controller.findStudentById(targetId)) {
          console.log("Student ID not found.");
          continue;
        }

        const temporaryGrades = [];
        let inputError = false;

        for (let i = 1; i <= 3; i += 1) {
          const gradeInput = (await this.ask(`Enter grade ${i} (0 - 20): `)).trim();
          const gradeValue = Number(gradeInput);
          if (Number.isNaN(gradeValue)) {
            console.log("Invalid grade format. Input cancelled.");
            inputError = true;
            break;
          }
          temporaryGrades.push(gradeValue);
        }

        if (!inputError) {
          if (this.controller.addGradesToStudent(targetId, temporaryGrades)) {
            console.log("All 3 grades added successfully!");
          } else {
            console.log("Grades could not be saved due to validation rules.");
          }
        }
      } else if (option === 3) {
        const students = this.controller.getAllStudents();
        console.log("\n+------------+-----------------+-----------------+---------------------------+---------+-----------+");
        console.log("| ID         | First Name     | Last Name      | Grades                    | Average | Status    |");
        console.log("+------------+-----------------+-----------------+---------------------------+---------+-----------+");

        if (students.length === 0) {
          console.log("| No data available                                                                 |");
        } else {
          for (const student of students) {
            const studentGrades = this.controller.getGradesByStudent(student.id);
            const avg = this.controller.calculateAverage(student.id);
            const status = avg >= 14.0 ? "Pass" : "No pass";
            const gradesStr = JSON.stringify(studentGrades);
            console.log(`| ${student.id.padEnd(10)} | ${student.firstName.padEnd(15)} | ${student.lastName.padEnd(15)} | ${gradesStr.padEnd(25)} | ${avg.toFixed(2).padEnd(7)} | ${status.padEnd(9)} |`);
          }
        }

        console.log("+------------+-----------------+-----------------+---------------------------+---------+-----------+");
      } else if (option === 4) {
        console.log("Exiting the program... Goodbye!");
        break;
      } else {
        console.log("Invalid option. Try again.");
      }
    }

    this.rl.close();
  }
}

if (require.main === module) {
  const app = new GradesStudentApp();
  app.main();
}

module.exports = GradesStudentApp;
