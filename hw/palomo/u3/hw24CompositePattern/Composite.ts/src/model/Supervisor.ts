import { Employee } from "./Employee";

export class Supervisor extends Employee {
    protected subordinates: Employee[] = [];

    constructor(name: string) {
        super(name);
    }

    protected getRole(): string {
        return "Supervisor";
    }

    addEmployee(employee: Employee): void {
        this.subordinates.push(employee);
    }

    removeEmployee(employee: Employee): void {
        this.subordinates = this.subordinates.filter((e) => e !== employee);
    }

    stateName(): void {
        super.stateName();
        for (const employee of this.subordinates) {
            employee.stateName();
        }
    }
}
