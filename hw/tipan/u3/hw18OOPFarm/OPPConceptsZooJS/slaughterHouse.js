class SlaughterHouse {

    constructor(name) {
        this.name = name;
        this.cuts = [];
    }

    addCut(cut) {
        this.cuts.push(cut);
    }

}

module.exports = SlaughterHouse;