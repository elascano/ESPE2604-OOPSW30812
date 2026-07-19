import Supervisor from "./Supervisor.js";

export default class Manager extends Supervisor {

    constructor(name) {
        super();
        this.title = "Manager";
        this.name = name;
    }

}