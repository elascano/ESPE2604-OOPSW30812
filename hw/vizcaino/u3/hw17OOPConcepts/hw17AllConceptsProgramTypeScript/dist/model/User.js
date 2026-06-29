"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.User = void 0;
class User {
    constructor(name, subscription) {
        this.name = name;
        this.subscription = subscription;
    }
    getName() {
        return this.name;
    }
    getSubscription() {
        return this.subscription;
    }
}
exports.User = User;
