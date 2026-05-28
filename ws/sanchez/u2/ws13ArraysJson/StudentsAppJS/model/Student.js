class Student {
    constructor(firstName = "", lastName = "", subject = "", age = 0, grades = []) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
        this.age = age;
        this.grades = grades;
    }

    getAverage() {
        if (this.grades.length === 0) return 0;
        let sum = 0;
        for (let g of this.grades) {
            sum += g;
        }
        return sum / this.grades.length;
    }

    toString() {
        return `\nName: ${this.firstName} ${this.lastName}\nSubject: ${this.subject}\nAge: ${this.age}\nGrades: [${this.grades.join(", ")}]\nAverage: ${this.getAverage().toFixed(2)}`;
    }
}

module.exports = Student;