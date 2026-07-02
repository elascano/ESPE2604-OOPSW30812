class Cut {

    constructor(id, description, procedure, weight) {
        this.id = id;
        this.description = description;
        this.procedure = procedure;
        this.weight = weight;

    }

    toDocument() {

        return {
            _id: this.id,
            description: this.description,
            procedure: this.procedure,
            weight: this.weight
        };

    }

}

module.exports = Cut;