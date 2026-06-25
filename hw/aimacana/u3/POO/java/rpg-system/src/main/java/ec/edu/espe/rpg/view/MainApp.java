package ec.edu.espe.rpg.view;

import atlantafx.base.theme.PrimerDark;
import ec.edu.espe.rpg.controller.GameController;
import ec.edu.espe.rpg.repository.MongoCharacterRepository;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    private GameController gameController;

    @Override
    public void init() throws Exception {
        // Inicializamos las capas de la arquitectura con Singleton
        MongoCharacterRepository repository = MongoCharacterRepository.getInstance();
        this.gameController = new GameController(repository);
    }

    @Override
    public void start(Stage primaryStage) {
        // Aplicar el tema moderno de AtlantaFX
        Application.setUserAgentStylesheet(new PrimerDark().getUserAgentStylesheet());

        // Inicializar el Layout principal
        CharacterDashboard dashboard = new CharacterDashboard(gameController);

        // Configurar la ventana
        Scene scene = new Scene(dashboard.getView(), 1150, 750);
        java.net.URL cssUrl = getClass().getResource("/styles/theme.css");
        if (cssUrl != null) {
            scene.getStylesheets().add(cssUrl.toExternalForm());
        }
        primaryStage.setTitle("ESPE RPG System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
