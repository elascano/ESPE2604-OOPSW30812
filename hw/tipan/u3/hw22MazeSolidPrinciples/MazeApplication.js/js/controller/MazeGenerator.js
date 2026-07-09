export class MazeGenerator {
  generateMaze() {
    throw new Error('generateMaze() must be implemented by subclass');
  }

  validateMaze() {
    throw new Error('validateMaze() must be implemented by subclass');
  }

  createRooms() {
    throw new Error('createRooms() must be implemented by subclass');
  }

  generateUniquePath() {
    throw new Error('generateUniquePath() must be implemented by subclass');
  }
}
