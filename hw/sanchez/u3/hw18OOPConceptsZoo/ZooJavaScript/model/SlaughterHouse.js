class SlaughterHouse {
  constructor(id, name, location) {
    this.id = id;
    this.name = name;
    this.location = location;
  }

  toJSON() {
    return {
      id: this.id,
      name: this.name,
      location: this.location
    };
  }
}

module.exports = SlaughterHouse;