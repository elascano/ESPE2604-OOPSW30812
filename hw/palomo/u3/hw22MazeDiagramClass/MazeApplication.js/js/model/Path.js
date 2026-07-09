export class Path {
  constructor() {
    this.rooms = [];
  }

  addRoom(room) {
    this.rooms.push(room);
  }

  getRoom(index) {
    return this.rooms[index];
  }

  getSize() {
    return this.rooms.length;
  }

  getRooms() {
    return this.rooms;
  }

  contains(room) {
    return this.rooms.includes(room);
  }
}
