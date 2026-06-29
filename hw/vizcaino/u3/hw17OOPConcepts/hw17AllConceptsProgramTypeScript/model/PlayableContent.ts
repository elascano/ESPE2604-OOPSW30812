export abstract class PlayableContent {
    constructor(protected title: string) {}
    abstract play(): void;
}