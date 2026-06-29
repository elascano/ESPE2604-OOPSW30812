"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.StreamingPlatform = void 0;
class StreamingPlatform {
    constructor(name) {
        this.name = name;
    }
    play(user, content) {
        console.log(`${user.getName()} is using ${this.name} (${user.getSubscription().getPlan()} plan)`);
        content.play();
    }
}
exports.StreamingPlatform = StreamingPlatform;
