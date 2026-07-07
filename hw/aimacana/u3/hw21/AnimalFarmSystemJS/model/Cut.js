class Cut {
    constructor(name = "") {
        this.name = name;
    }

    toString() {
        return `Cut{name=${this.name}}`;
    }
}

module.exports = Cut;