class Student {

    constructor(id, name, grade1, grade2) {
        this.id = id;
        this.name = name;
        this.grade1 = grade1;
        this.grade2 = grade2;
    }

    getAverage() {
        return (this.grade1 + this.grade2) / 2;
    }
}

export default Student;