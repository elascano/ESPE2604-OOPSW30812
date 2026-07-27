
package ec.edu.espe.templatemethod.model;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */

public class Chocolate extends CaffeineBeverage {
    @Override
    public void brew() {
        System.out.println("Mixing chocolate powder with hot water");
    }

    @Override
    public void addCondiments() {
        System.out.println("Adding whipped cream");
    }

    @Override
    public boolean wantsCondiments() {
        String answer = getUserInput();
        if (answer.toLowerCase().startsWith("y")) {
            return true;
        } else {
            return false;
        }
    }

    private String getUserInput() {
        String answer = null;
        System.out.println("Would you like whipped cream with your chocolate (y/n)? ");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException e) {
            System.err.println("IO error trying to read your answer");
        }
        if (answer == null) {
            return "no";
        }
        return answer;
    }
}
