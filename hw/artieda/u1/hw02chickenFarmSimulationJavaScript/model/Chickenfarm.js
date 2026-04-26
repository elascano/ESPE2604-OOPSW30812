export class ChickenFarm {
    constructor(name, chickenCoops = []){
        this.name = name;
        this.chickenCoops = chickenCoops;
    }
    getName(){
        return this.name;
    }
    setName(name){
        this.name = name;
    }
    getChickenCoops(){
        return this.chickenCoops;
    }
    setChickenCoops(chickenCoops){
        this.chickenCoops = chickenCoops;
    }
    toString(){
        return `ChickenFarm{name=${this.name}, chickenCoops=${this.chickenCoops}}`;
    }
    add(chickenCoop){}
    remove(chickenCoopId){}
    resetIteration(){}
    next(){}
}