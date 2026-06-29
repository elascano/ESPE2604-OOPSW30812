import { PlayableContent } from "./PlayableContent";

export class Movie extends PlayableContent {
    play(): void {
        console.log("Playing movie: " + this.title);
    }
}