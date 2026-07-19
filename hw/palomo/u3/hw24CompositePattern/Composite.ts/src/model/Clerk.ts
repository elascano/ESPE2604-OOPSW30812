import { Employee } from "./Employee";

export class Clerk extends Employee {
    constructor(name: string) {
        super(name);
    }

    protected getRole(): string {
        return "Clerk";
    }
}