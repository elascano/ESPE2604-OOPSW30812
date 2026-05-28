class Student {

    constructor(id, name, course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    toString() {
        return `Student{
id=${this.id},
name=${this.name},
course=${this.course}
}`;
    }
}

export default Student;