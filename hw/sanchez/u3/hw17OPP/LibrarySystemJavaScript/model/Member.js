const Person = require("./Person");

class Member extends Person {

    constructor(id, name, email) {
        super(id, name);
        this.email = email;
    }

    getInfo() {
        return `${this.name} - ${this.email}`;
    }
}

module.exports = Member;