const FileSystemItem = require("./FileSystemItem");

class Directory extends FileSystemItem {
    constructor(name) {
        super();
        this.name = name;
        this.contents = [];
    }

    describe() {
        super.describe();
        for (const item of this.contents) {
            item.describe();
        }
    }

    add(item) {
        this.contents.push(item);
    }
}

module.exports = Directory;
