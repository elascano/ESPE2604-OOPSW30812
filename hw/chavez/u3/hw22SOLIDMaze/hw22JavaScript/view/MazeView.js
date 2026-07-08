export default class MazeView {

    constructor() {
        this.widthInput = document.getElementById("width");
        this.heightInput = document.getElementById("height");

        this.generateButton = document.getElementById("generateMaze");
        this.printButton = document.getElementById("printMaze");
        this.saveButton = document.getElementById("saveMaze");

        this.canvas = document.getElementById("mazeCanvas");
        this.consoleOutput = document.getElementById("consoleOutput");
    }

    getWidth() {
        return Number(this.widthInput.value) || 0;
    }

    getHeight() {
        return Number(this.heightInput.value) || 0;
    }

    getDimensions() {
        return {
            width: this.getWidth(),
            height: this.getHeight()
        };
    }

    getCanvas() {
        return this.canvas;
    }

    showMessage(message) {

        const messages = this.consoleOutput.value
            .split("\n")
            .filter(line => line.length > 0);

        if (messages.length >= 15) {
            messages.shift();
        }

        messages.push(message);

        this.consoleOutput.value = messages.join("\n");

        this.consoleOutput.scrollTop =
            this.consoleOutput.scrollHeight;
    }

    clearConsole() {
        this.consoleOutput.value = "";
    }

    registerEvent(button, callback) {
        button.addEventListener("click", callback);
    }

    onGenerateMaze(callback) {
        this.registerEvent(this.generateButton, callback);
    }

    onPrintMaze(callback) {
        this.registerEvent(this.printButton, callback);
    }

    onSaveMaze(callback) {
        this.registerEvent(this.saveButton, callback);
    }

}