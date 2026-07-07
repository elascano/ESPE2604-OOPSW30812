class Cut {
    constructor(id, description, procedure, weight) {
        this.id = id;
        this.description = description;
        this.procedure = procedure;
        this.weight = weight;
    }

    getId() { return this.id; }
    setId(id) { this.id = id; }
    getDescription() { return this.description; }
    setDescription(description) { this.description = description; }
    getProcedure() { return this.procedure; }
    setProcedure(procedure) { this.procedure = procedure; }
    getWeight() { return this.weight; }
    setWeight(weight) { this.weight = weight; }
}

module.exports = Cut;