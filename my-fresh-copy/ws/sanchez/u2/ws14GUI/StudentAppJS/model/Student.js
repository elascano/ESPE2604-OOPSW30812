class Student {
    constructor(idNumber, name, age, career, grades) {
        this.idNumber = idNumber;
        this.name = name;
        this.age = age;
        this.career = career;
        this.grades = grades;
    }

    getIdNumber() { return this.idNumber; }
    getName() { return this.name; }
    getAge() { return this.age; }
    getCareer() { return this.career; }
    getGrades() { return this.grades; }

    calculateGPA() {
        if (!this.grades || this.grades.length === 0) return 0;
        const sum = this.grades.reduce((acc, g) => acc + g, 0);
        return sum / this.grades.length;
    }
}