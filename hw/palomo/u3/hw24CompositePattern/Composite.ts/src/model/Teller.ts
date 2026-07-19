import { Employee } from "./Employee";

export class Teller extends Employee {
    constructor(name: string) {
        super(name);
    }

    protected getRole(): string {
        return "Teller";
    }
}