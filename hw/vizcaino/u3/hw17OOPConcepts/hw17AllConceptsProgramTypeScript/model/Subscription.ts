export class Subscription {
    constructor(private plan: string) {}

    getPlan() {
        return this.plan;
    }
}