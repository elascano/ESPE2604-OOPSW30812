/**
 * Customer.js
 * Modelo de cliente para el Shopping Center
 * @author Cristian (convertido a JavaScript)
 */
class Customer {
    /**
     * @param {number} id
     * @param {string} firstName
     * @param {string} lastName
     * @param {string} gender
     * @param {number} moneySpent
     * @param {number} age
     * @param {string} typeCustomer
     * @param {string[]} hobbies
     */
    constructor(id, firstName, lastName, gender, moneySpent, age, typeCustomer, hobbies = []) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.moneySpent = moneySpent;
        this.age = age;
        this.typeCustomer = typeCustomer;
        this.hobbies = hobbies;
    }

    // Getters
    getId() { return this.id; }
    getFirstName() { return this.firstName; }
    getLastName() { return this.lastName; }
    getGender() { return this.gender; }
    getMoneySpent() { return this.moneySpent; }
    getAge() { return this.age; }
    getTypeCustomer() { return this.typeCustomer; }
    getHobbies() { return this.hobbies; }

    // Setters
    setId(id) { this.id = id; }
    setFirstName(firstName) { this.firstName = firstName; }
    setLastName(lastName) { this.lastName = lastName; }
    setGender(gender) { this.gender = gender; }
    setMoneySpent(moneySpent) { this.moneySpent = moneySpent; }
    setAge(age) { this.age = age; }
    setTypeCustomer(typeCustomer) { this.typeCustomer = typeCustomer; }
    setHobbies(hobbies) { this.hobbies = hobbies; }

    toString() {
        return `Customer { id=${this.id}, firstName=${this.firstName}, lastName=${this.lastName}, ` +
               `gender=${this.gender}, moneySpent=${this.moneySpent}, age=${this.age}, ` +
               `typeCustomer=${this.typeCustomer}, hobbies=[${this.hobbies.join(', ')}] }`;
    }
}

module.exports = Customer;
