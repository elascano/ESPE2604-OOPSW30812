package ec.edu.espe.rpg.view;

/**
 * Clase lanzadora para evadir la restricción de módulos de JavaFX 11+.
 * Si intentamos correr MainApp (que hereda de Application) directamente sin module-info,
 * el compilador a veces lanza errores o no detecta el main correctamente.
 */
public class Launcher {
    public static void main(String[] args) {
        MainApp.main(args);
    }
}
