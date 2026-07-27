const FileSystemItem = require("./FileSystemItem");

class ImageFile extends FileSystemItem {
    constructor(name, size) {
        super();
        this.name = name;
        this.size = size;
    }

    describe() {
        super.describe();
    }
}

module.exports = ImageFile;
