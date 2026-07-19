const Direction = {
    NORTH: 'NORTH',
    SOUTH: 'SOUTH',
    EAST: 'EAST',
    WEST: 'WEST',
    getOpposite(dir) {
        switch (dir) {
            case this.NORTH: return this.SOUTH;
            case this.SOUTH: return this.NORTH;
            case this.EAST: return this.WEST;
            case this.WEST: return this.EAST;
        }
    }
};
