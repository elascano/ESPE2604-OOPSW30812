class Person {
    constructor(personId, name, email) {
        this.personId = personId;
        this.name = name;
        this.email = email;
    }

    toDict() {
        return {
            _id: this.personId,
            name: this.name,
            email: this.email
        };
    }
}

module.exports = Person;