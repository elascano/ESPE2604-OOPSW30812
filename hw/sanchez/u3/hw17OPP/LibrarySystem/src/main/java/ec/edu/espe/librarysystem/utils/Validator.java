package ec.edu.espe.librarysystem.utils;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class Validator {

    public static boolean isEmpty(String text) {
        return text == null || text.trim().isEmpty();
    }
}
