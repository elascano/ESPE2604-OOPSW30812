class Customer {
    constructor(id, firstName, lastName, gender, moneySpent, age, typeOfCustomer, hobbies) {
        this._id = id;
        this._firstName = firstName;
        this._lastName = lastName;
        this._gender = gender;
        this._moneySpent = moneySpent;
        this._age = age;
        this._typeOfCustomer = typeOfCustomer;
        this._hobbies = hobbies;
    }

    getId() { return this._id; }
    setId(value) { this._id = value; }

    getFirstName() { return this._firstName; }
    setFirstName(value) { this._firstName = value; }

    getLastName() { return this._lastName; }
    setLastName(value) { this._lastName = value; }

    getGender() { return this._gender; }
    setGender(value) { this._gender = value; }

    getMoneySpent() { return this._moneySpent; }
    setMoneySpent(value) { this._moneySpent = value; }

    getAge() { return this._age; }
    setAge(value) { this._age = value; }

    getTypeOfCustomer() { return this._typeOfCustomer; }
    setTypeOfCustomer(value) { this._typeOfCustomer = value; }

    getHobbies() { return this._hobbies; }
    setHobbies(value) { this._hobbies = value; }

    toString() {
        return `Customer{id=${this._id}, firstName=${this._firstName}, lastName=${this._lastName}, gender=${this._gender}, moneySpent=${this._moneySpent}, age=${this._age}, typeOfCustomer=${this._typeOfCustomer}, hobbies=[${this._hobbies.join(', ')}]}`;
    }
}


