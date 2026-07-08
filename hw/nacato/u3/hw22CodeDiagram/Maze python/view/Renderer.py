from abc import ABC, abstractmethod
from model.Maze import Maze
from model.Direction import Direction

class MazeRenderer(ABC):
    @abstractmethod
    def render(self, maze: Maze) -> None:
        pass

class ASCIIPrinter(MazeRenderer):
    def render(self, maze: Maze) -> None:
        print("\n--- [MAze] ---")
        grid = {(r.x, r.y): r for r in maze.rooms}
        
        for y in range(maze.height):
            top_row = ""
            for x in range(maze.width):
                room = grid[(x, y)]
                has_north_wall = any(w.direction == Direction.NORTH for w in room.walls)
                has_entrance = any(d.direction == Direction.NORTH and d.__class__.__name__ == "EntranceDoor" for d in room.doors)
                
                top_row += "+"
                if has_entrance:
                    top_row += " E "
                else:
                    top_row += "---" if has_north_wall else "   "
            top_row += "+"
            print(top_row)

            mid_row = ""
            for x in range(maze.width):
                room = grid[(x, y)]
                has_west_wall = any(w.direction == Direction.WEST for w in room.walls)
                
                mid_row += "|" if has_west_wall else " "
                
                if maze.player and maze.player.current_room.x == x and maze.player.current_room.y == y:
                    mid_row += " P "
                else:
                    mid_row += "   "
                    
            last_room = grid[(maze.width - 1, y)]
            has_east_wall = any(w.direction == Direction.EAST for w in last_room.walls)
            mid_row += "|" if has_east_wall else " "
            print(mid_row)

        bot_row = ""
        for x in range(maze.width):
            room = grid[(x, maze.height - 1)]
            has_south_wall = any(w.direction == Direction.SOUTH for w in room.walls)
            has_exit = any(d.direction == Direction.SOUTH and d.__class__.__name__ == "ExitDoor" for d in room.doors)
            
            bot_row += "+"
            if has_exit:
                bot_row += " S "
            else:
                bot_row += "---" if has_south_wall else "   "
        bot_row += "+"
        print(bot_row)
        print("_______________________\n")