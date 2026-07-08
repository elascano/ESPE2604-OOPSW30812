class Path {
  constructor(coordinates = []) {
    this.coordinates = coordinates;
  }

  toString() {
    return `Path{coordinates=${JSON.stringify(this.coordinates)}}`;
  }
}

export { Path };
