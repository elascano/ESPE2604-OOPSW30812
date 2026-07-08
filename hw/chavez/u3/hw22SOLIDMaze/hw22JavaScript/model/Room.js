export default class Room {

    constructor(id, row, column) {

        this.id = id;
        this.row = row;
        this.column = column;

        this.visited = false;

        this.north = true;
        this.south = true;
        this.east = true;
        this.west = true;
    }

    visit() {
        this.visited = true;
    }

    isVisited() {
        return this.visited;
    }

    getId() {
        return this.id;
    }

    getRow() {
        return this.row;
    }

    getColumn() {
        return this.column;
    }

}