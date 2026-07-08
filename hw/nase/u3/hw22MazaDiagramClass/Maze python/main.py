from model.Maze import Maze
from view.Renderer import ASCIIPrinter
from controller.Path_controller import PathController

def main():
    laberinto = Maze()
    laberinto.generate(width=4, height=4)
    
    impresora_ascii = ASCIIPrinter()
    controlador_ascii = PathController(Renderer=impresora_ascii)
    controlador_ascii.Renderer.render(laberinto)

if __name__ == "__main__":
    main()