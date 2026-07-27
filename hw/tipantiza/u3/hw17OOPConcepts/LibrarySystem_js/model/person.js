class Person {
    constructor(id = null, firstName = null, lastName = null, email = null) {
        this._id = id;
        this._firstName = firstName;
        this._lastName = lastName;
        this._email = email;
    }
    
    get id() {
        return this._id;
    }
    
    set id(value) {
        this._id = value;
    }
    
    get firstName() {
        return this._firstName;
    }
    
    set firstName(value) {
        this._firstName = value;
    }
    
    get lastName() {
        return this._lastName;
    }
    
    set lastName(value) {
        this._lastName = value;
    }
    
    get email() {
        return this._email;
    }
    
    set email(value) {
        this._email = value;
    }
    
    getPersonType() {
        throw new Error("Method not implemented");
    }
    
    getFullName() {
        return `${this._firstName} ${this._lastName}`;
    }
    
    toString() {
        return `${this.getFullName()} (${this._email})`;
    }
}

module.exports = Person;