package ec.edu.espe.rpg.view.components;

import ec.edu.espe.rpg.controller.GameController;
import ec.edu.espe.rpg.model.entities.Character;
import ec.edu.espe.rpg.model.entities.Mage;
import ec.edu.espe.rpg.model.entities.Warrior;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.util.List;
import java.util.function.Consumer;

public class ControlPanelComponent extends VBox {

    private final GameController gameController;
    private final Runnable onUpdate;
    private final Consumer<String> logger;

    private TextField txtName;
    private ComboBox<String> cmbClass;
    private ComboBox<CharacterItem> cmbSavedGames;
    private Button btnSave;

    private static class CharacterItem {
        private final String id;
        private final String displayName;
        public CharacterItem(String id, String displayName) {
            this.id = id;
            this.displayName = displayName;
        }
        public String getId() { return id; }
        @Override
        public String toString() { return displayName; }
    }

    public ControlPanelComponent(GameController gameController, Runnable onUpdate, Consumer<String> logger) {
        this.gameController = gameController;
        this.onUpdate = onUpdate;
        this.logger = logger;
        setSpacing(15);
        buildUI();
        refreshSavedGamesList();
    }

    private void buildUI() {
        getChildren().addAll(buildCreationCard(), buildDatabaseCard());
    }

    private VBox buildCreationCard() {
        VBox card = new VBox(15);
        card.setPadding(new Insets(20));
        card.getStyleClass().add("card");

        Label lblTitle = new Label("Crear Nuevo Personaje");
        lblTitle.getStyleClass().add("card-title");
        
        txtName = new TextField();
        txtName.setPromptText("Nombre...");
        txtName.getStyleClass().add("custom-textfield");
        
        cmbClass = new ComboBox<>();
        cmbClass.getItems().addAll("Warrior", "Mage");
        cmbClass.setValue("Warrior");
        cmbClass.setMaxWidth(Double.MAX_VALUE);
        cmbClass.getStyleClass().add("custom-combobox");

        Button btnCreate = new Button("Crear Personaje");
        btnCreate.setMaxWidth(Double.MAX_VALUE);
        btnCreate.getStyleClass().addAll("btn", "btn-primary");
        btnCreate.setOnAction(e -> handleCreateCharacter());
        
        card.getChildren().addAll(lblTitle, txtName, cmbClass, btnCreate);
        return card;
    }

    private VBox buildDatabaseCard() {
        VBox card = new VBox(15);
        card.setPadding(new Insets(20));
        card.getStyleClass().add("card");

        Label lblTitle = new Label("Persistencia (MongoDB)");
        lblTitle.getStyleClass().add("card-title");
        
        cmbSavedGames = new ComboBox<>();
        cmbSavedGames.setPromptText("Selecciona partida...");
        cmbSavedGames.setMaxWidth(Double.MAX_VALUE);
        cmbSavedGames.getStyleClass().add("custom-combobox");

        Button btnLoad = new Button("Cargar Partida");
        btnLoad.setMaxWidth(Double.MAX_VALUE);
        btnLoad.getStyleClass().addAll("btn", "btn-warning");
        btnLoad.setOnAction(e -> handleLoadCharacter());

        btnSave = new Button("Guardar Partida");
        btnSave.setMaxWidth(Double.MAX_VALUE);
        btnSave.getStyleClass().addAll("btn", "btn-success");
        btnSave.setDisable(true);
        btnSave.setOnAction(e -> {
            logger.accept(gameController.saveGame());
            refreshSavedGamesList();
        });

        Button btnRest = new Button("⛺ Descansar (Curar)");
        btnRest.setMaxWidth(Double.MAX_VALUE);
        btnRest.getStyleClass().addAll("btn", "btn-info");
        btnRest.setOnAction(e -> {
            Character c = gameController.getCurrentCharacter();
            if (c != null) {
                c.heal(c.getMaxHp());
                logger.accept(c.getName() + " ha descansado. HP restaurado al máximo.");
                onUpdate.run();
            } else {
                showAlert("No hay personaje activo.");
            }
        });

        card.getChildren().addAll(lblTitle, cmbSavedGames, btnLoad, btnSave, new Separator(), btnRest);
        return card;
    }

    private void refreshSavedGamesList() {
        cmbSavedGames.getItems().clear();
        List<Character> savedGames = gameController.getAllSavedCharacters();
        for (Character c : savedGames) {
            String type = (c instanceof Warrior) ? "Guerrero" : "Mago";
            String display = type + " - " + c.getName() + " (Lvl " + c.getLevel() + ")";
            cmbSavedGames.getItems().add(new CharacterItem(c.getId(), display));
        }
    }

    private void handleCreateCharacter() {
        String name = txtName.getText();
        if (name.isEmpty()) {
            showAlert("El nombre no puede estar vacío.");
            return;
        }
        String id = java.util.UUID.randomUUID().toString();
        Character newChar = "Warrior".equals(cmbClass.getValue()) 
            ? new Warrior(id, name, 1, 100.0, 15.0) 
            : new Mage(id, name, 1, 80.0, 20.0, 50.0);
        
        logger.accept(gameController.createNewCharacter(newChar));
        btnSave.setDisable(false);
        onUpdate.run();
    }

    private void handleLoadCharacter() {
        CharacterItem selected = cmbSavedGames.getValue();
        if (selected == null) {
            showAlert("Selecciona una partida.");
            return;
        }
        String result = gameController.loadCharacter(selected.getId());
        logger.accept(result);
        
        if (!result.startsWith("Error")) {
            btnSave.setDisable(false);
            onUpdate.run();
        } else {
            showAlert("Personaje no encontrado.");
        }
    }

    public void updateState() {
        btnSave.setDisable(gameController.getCurrentCharacter() == null);
    }

    private void showAlert(String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
