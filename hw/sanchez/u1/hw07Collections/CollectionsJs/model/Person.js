/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
export class Person {
    constructor(id, fullName, bornOnDate, alive) {
        this.id = id;
        this.fullName = fullName;
        this.bornOnDate = bornOnDate;
        this.alive = alive;
    }

    computeAgeInYears() {
        const currentDate = new Date();
        let age = currentDate.getFullYear() - this.bornOnDate.getFullYear();
        const monthDiff = currentDate.getMonth() - this.bornOnDate.getMonth();
        
        if (monthDiff < 0 || (monthDiff === 0 && currentDate.getDate() < this.bornOnDate.getDate())) {
            age--;
        }
        return age;
    }

    toString() {
        const isAlive = this.alive ? "YES" : "NO";
        const birthStr = this.bornOnDate.toISOString().split('T')[0];
        return `Person ${this.id} --> Name: ${this.fullName}, BirthDate: ${birthStr}, alive: ${isAlive} <--`;
    }

    getId() { return this.id; }
    setId(id) { this.id = id; }
    getFullName() { return this.fullName; }
    setFullName(fullName) { this.fullName = fullName; }
    getBornOnDate() { return this.bornOnDate; }
    setBornOnDate(bornOnDate) { this.bornOnDate = bornOnDate; }
    isAlive() { return this.alive; }
    setAlive(alive) { this.alive = alive; }
}

