export class Poop {
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
        return `Poop{id=${this.id}}`;
    }
}