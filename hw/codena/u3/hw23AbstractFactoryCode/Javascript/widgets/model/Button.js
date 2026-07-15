export default class Button {

    constructor() {
        this.caption = "";
    }

    paint() {
        throw new Error("paint() must be implemented");
    }

}