import Supervisor from "./Supervisor.js";

export default class President extends Supervisor {

    static instance = null;

    constructor(name) {

        if (President.instance) {
            President.instance.name = name;
            return President.instance;
        }

        super();

        this.title = "President";
        this.name = name;

        President.instance = this;
    }

}