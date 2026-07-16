import Supervisor from "./Supervisor.js";

export default class President extends Supervisor {

    constructor(name) {
        super(name, "President: ");
    }
}