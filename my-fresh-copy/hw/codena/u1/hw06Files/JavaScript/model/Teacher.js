class Teacher {

    constructor(id, name, career) {
        this.id = id;
        this.name = name;
        this.career = career;
    }

    toString() {
        return `Teacher{
id=${this.id},
name=${this.name},
career=${this.career}
}`;
    }
}

export default Teacher;