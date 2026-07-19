import { Supervisor } from "./Supervisor";

export class Manager extends Supervisor {
    constructor(name: string) {
        super(name);
    }

    protected getRole(): string {
        return "Manager";
    }
}