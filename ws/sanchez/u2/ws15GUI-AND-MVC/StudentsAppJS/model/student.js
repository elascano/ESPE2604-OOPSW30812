// model/student.js
// Clase Student - Modelo de datos

export class Student {
    constructor(firstName, lastName, age, subjectsGrades = {}) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.subjectsGrades = subjectsGrades;
    }

    // Calcular promedio general
    getOverallAverage() {
        let total = 0;
        let count = 0;
        
        for (const grades of Object.values(this.subjectsGrades)) {
            for (const grade of grades) {
                total += grade;
                count++;
            }
        }
        
        return count === 0 ? 0 : total / count;
    }

    // Agregar materia con notas
    addSubject(subject, grades) {
        this.subjectsGrades[subject] = grades;
    }

    // Eliminar materia
    removeSubject(subject) {
        delete this.subjectsGrades[subject];
    }

    // Obtener nombres de materias
    getSubjectNames() {
        return Object.keys(this.subjectsGrades);
    }

    // Convertir a objeto plano para JSON
    toJSON() {
        return {
            firstName: this.firstName,
            lastName: this.lastName,
            age: this.age,
            subjectsGrades: this.subjectsGrades
        };
    }

    // Crear desde objeto plano
    static fromJSON(data) {
        return new Student(
            data.firstName,
            data.lastName,
            data.age,
            data.subjectsGrades || {}
        );
    }
}