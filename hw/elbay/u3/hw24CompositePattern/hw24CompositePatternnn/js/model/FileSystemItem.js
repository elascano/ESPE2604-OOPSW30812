class FileSystemItem {
    constructor() {
        this.name = "unnamed";
        this.size = 0;
    }

    describe() {
        console.log(`${this.name} - ${this.size}KB`);
    }
}

module.exports = FileSystemItem;
