export class SIMCard {
    constructor(private operator: string) {}

    public getOperator(): string {
        return this.operator;
    }
}