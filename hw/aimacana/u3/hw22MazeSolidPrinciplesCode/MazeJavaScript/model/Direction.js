const Direction = {
    NORTH: 'NORTH',
    SOUTH: 'SOUTH',
    EAST: 'EAST',
    WEST: 'WEST',

    getOpposite(dir) {
        switch (dir) {
            case Direction.NORTH: return Direction.SOUTH;
            case Direction.SOUTH: return Direction.NORTH;
            case Direction.EAST: return Direction.WEST;
            case Direction.WEST: return Direction.EAST;
            default: return null;
        }
    }
};

export default Direction;
