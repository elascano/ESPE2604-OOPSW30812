import { User } from "./User";
import { PlayableContent } from "./PlayableContent";

export class StreamingPlatform {
    constructor(private name: string) {}

    play(user: User, content: PlayableContent) {
        console.log(
            `${user.getName()} is using ${this.name} (${user.getSubscription().getPlan()} plan)`
        );
        content.play();
    }
}