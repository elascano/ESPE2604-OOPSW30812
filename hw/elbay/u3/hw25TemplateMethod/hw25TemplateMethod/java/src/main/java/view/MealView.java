package view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MealView {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void showMessage(String message) {
        System.out.println(message);
    }

    public String getUserInput(String prompt) {
        System.out.println(prompt);
        try {
            return reader.readLine();
        } catch (IOException e) {
            return "n";
        }
    }
}
