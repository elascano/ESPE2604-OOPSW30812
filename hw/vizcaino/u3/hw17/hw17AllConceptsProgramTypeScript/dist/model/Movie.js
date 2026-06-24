"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Movie = void 0;
const PlayableContent_1 = require("./PlayableContent");
class Movie extends PlayableContent_1.PlayableContent {
    play() {
        console.log("Playing movie: " + this.title);
    }
}
exports.Movie = Movie;
