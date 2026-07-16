export abstract class Employee {
    protected name: string;

    protected constructor(name: string) {
        this.name = name;
    }

    protected abstract getRole(): string;

    stateName(): void {
        console.log(`${this.name} - ${this.getRole()}`);
    }

    getName(): string {
        return this.name;
    }
}