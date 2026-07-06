export class Cut {
    constructor(id, description, procedure, weight) {
        this.id = id;
        this.description = description;
        this.procedure = procedure;
        this.weight = weight;
    }

    toString() {
        return `Cut{id=${this.id}, description=${this.description}, procedure=${this.procedure}, weight=${this.weight}}`;
    }
}