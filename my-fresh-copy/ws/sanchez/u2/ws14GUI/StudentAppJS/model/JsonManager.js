class JsonManager {
    constructor() {
        this.STORAGE_KEY = 'students';
        this.students = this.loadStudents();
    }

    getStudents() {
        return this.students;
    }

    addStudent(student) {
        this.students.push(student);
        this.saveStudents();
    }

    saveStudents() {
        try {
            const data = this.students.map(s => ({
                idNumber: s.idNumber,
                name: s.name,
                age: s.age,
                career: s.career,
                grades: s.grades
            }));
            localStorage.setItem(this.STORAGE_KEY, JSON.stringify(data));
        } catch (error) {
            console.log("Error saving: " + error.message);
        }
    }

    loadStudents() {
        try {
            const data = localStorage.getItem(this.STORAGE_KEY);
            if (data) {
                const parsed = JSON.parse(data);
                return parsed.map(s => new Student(s.idNumber, s.name, s.age, s.career, s.grades));
            }
        } catch (error) {
            console.log("Error loading: " + error.message);
        }
        return [];
    }
}