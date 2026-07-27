const FileSystemItem = require("./FileSystemItem");

class TextFile extends FileSystemItem {
    constructor(name, size) {
        super();
        this.name = name;
        this.size = size;
    }

    describe() {
        super.describe();
    }
}

module.exports = TextFile;
