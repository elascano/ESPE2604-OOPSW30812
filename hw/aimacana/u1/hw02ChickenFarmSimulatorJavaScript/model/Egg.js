export class Egg {
    constructor(id){
        this.id = id;
    }
    getId(){
        return this.id;
    }
    setId(id){
        this.id = id;
    }
    toString(){
        return `Egg{id=${this.id}}`;
    }
}