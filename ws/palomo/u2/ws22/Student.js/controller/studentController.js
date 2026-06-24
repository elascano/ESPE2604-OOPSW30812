export default class StudentController {

    constructor() {
        this.students = [];
    }

    create(student) {
        this.students.push(student);
    }

    findById(id) {
        return this.students.find(
            student => student.id == id
        );
    }

    delete(id) {

        const index = this.students.findIndex(
            student => student.id == id
        );

        if (index !== -1) {
            this.students.splice(index, 1);
            return true;
        }

        return false;
    }

    update(id, name, grade1, grade2) {

        const student = this.findById(id);

        if (student) {

            student.name = name;
            student.grade1 = grade1;
            student.grade2 = grade2;

            return true;
        }

        return false;
    }

    getAll() {
        return this.students;
    }
}