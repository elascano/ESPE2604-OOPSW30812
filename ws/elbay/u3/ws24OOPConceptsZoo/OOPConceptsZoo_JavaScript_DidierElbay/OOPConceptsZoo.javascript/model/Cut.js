/**
 * Cut - Represents a meat cut produced from a slaughtered animal.
 * @author Didier Elbay
 */
export class Cut {
    constructor(id, description, procedure, weight) {
        this.id = id;
        this.description = description;
        this.procedure = procedure;
        this.weight = weight;
    }
}
