import { Subscription } from "./Subscription";

export class User {
    constructor(
        private name: string,
        private subscription: Subscription
    ) {}

    getName() {
        return this.name;
    }

    getSubscription() {
        return this.subscription;
    }
}