import { Supervisor } from "./Supervisor";

export class President extends Supervisor {
    constructor(name: string) {
        super(name);
    }

    protected getRole(): string {
        return "President";
    }
}
