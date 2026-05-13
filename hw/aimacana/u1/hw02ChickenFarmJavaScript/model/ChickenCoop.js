export class ChickenCoop {
    constructor(id, chickens = []) {
        this.id = id;
        this.chickens = chickens;
    }
    getId(){
        return this.id;
    }
    setId(id){
        this.id = id;
    }
    getChickens(){
        return this.chickens;
    }
    setChickens(chickens){
        this.chickens = chickens;
    }
    toString(){
        return `ChickenCoop{id=${this.id}, chickens=${this.chickens}}`;
    }
    add(chicken){}
    remove(chickenId){}
    resetIteration(){}
    next(){}
}