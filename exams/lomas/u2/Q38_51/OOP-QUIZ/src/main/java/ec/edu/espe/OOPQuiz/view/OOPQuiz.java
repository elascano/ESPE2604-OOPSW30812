package ec.edu.espe.OOPQuiz.view;

import ec.edu.espe.OOPQuiz.controller.QuizController;

public class OOPQuiz {
    public static void main(String[] args) {
        QuizController controller = new QuizController();
        controller.runSimulation();
    }
}