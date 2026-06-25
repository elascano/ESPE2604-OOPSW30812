package ec.edu.espe.rpg.view;

import ec.edu.espe.rpg.controller.GameController;
import ec.edu.espe.rpg.view.components.ControlPanelComponent;
import ec.edu.espe.rpg.view.components.EnemyCombatComponent;
import ec.edu.espe.rpg.view.components.InventoryComponent;
import ec.edu.espe.rpg.view.components.PlayerStatsComponent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.util.function.Consumer;

public class CharacterDashboard {

    private final GameController gameController;
    private BorderPane mainView;
    private javafx.scene.control.ListView<Label> logListView;
    
    // Components
    private ControlPanelComponent controlPanel;
    private PlayerStatsComponent playerStats;
    private EnemyCombatComponent enemyCombat;
    private InventoryComponent inventory;

    public CharacterDashboard(GameController controller) {
        this.gameController = controller;
        buildUI();
    }

    private void buildUI() {
        mainView = new BorderPane();
        mainView.setPadding(new Insets(20));
        mainView.getStyleClass().add("root-view");

        mainView.setTop(buildHeader());
        
        logListView = new javafx.scene.control.ListView<>();
        logListView.getStyleClass().add("custom-console-list");

        Runnable onUpdate = this::updateAllComponents;
        Consumer<String> logger = this::log;

        controlPanel = new ControlPanelComponent(gameController, onUpdate, logger);
        playerStats = new PlayerStatsComponent(gameController, onUpdate, logger);
        enemyCombat = new EnemyCombatComponent(gameController, onUpdate, logger);
        inventory = new InventoryComponent(gameController, onUpdate, logger);

        VBox leftColumn = new VBox(15);
        leftColumn.setPrefWidth(280);
        
        VBox consoleCard = new VBox(15);
        consoleCard.setPadding(new Insets(20));
        consoleCard.getStyleClass().add("card");
        VBox.setVgrow(consoleCard, Priority.ALWAYS);
        Label consoleTitle = new Label("Registro de Eventos");
        consoleTitle.getStyleClass().add("card-title");
        VBox.setVgrow(logListView, Priority.ALWAYS);
        consoleCard.getChildren().addAll(consoleTitle, logListView);
        
        leftColumn.getChildren().addAll(controlPanel, consoleCard);
        javafx.scene.control.ScrollPane leftScroll = new javafx.scene.control.ScrollPane(leftColumn);
        leftScroll.setFitToWidth(true);
        leftScroll.setStyle("-fx-background-color: transparent; -fx-background: transparent;");

        VBox centerColumn = new VBox(20);
        centerColumn.setPrefWidth(400);
        centerColumn.getChildren().addAll(playerStats, enemyCombat);
        javafx.scene.control.ScrollPane centerScroll = new javafx.scene.control.ScrollPane(centerColumn);
        centerScroll.setFitToWidth(true);
        centerScroll.setStyle("-fx-background-color: transparent; -fx-background: transparent;");
        HBox.setHgrow(centerScroll, Priority.ALWAYS);

        VBox rightColumn = new VBox(20);
        rightColumn.setPrefWidth(280);
        rightColumn.getChildren().add(inventory);
        javafx.scene.control.ScrollPane rightScroll = new javafx.scene.control.ScrollPane(rightColumn);
        rightScroll.setFitToWidth(true);
        rightScroll.setStyle("-fx-background-color: transparent; -fx-background: transparent;");

        HBox mainContent = new HBox(20);
        mainContent.getChildren().addAll(leftScroll, centerScroll, rightScroll);
        mainView.setCenter(mainContent);
        
        updateAllComponents();
    }

    private HBox buildHeader() {
        HBox header = new HBox();
        header.setAlignment(Pos.CENTER_LEFT);
        header.setPadding(new Insets(0, 0, 15, 0));
        Label title = new Label("ESPE RPG System");
        title.getStyleClass().add("main-title");
        header.getChildren().add(title);
        return header;
    }

    private void updateAllComponents() {
        controlPanel.updateState();
        playerStats.update();
        enemyCombat.update();
        inventory.update();
    }

    private void log(String message) {
        Label label = new Label("> " + message);
        label.setWrapText(true);
        label.setMaxWidth(230); // prevent horizontal scrollbar
        
        if (message.contains("❌") || message.contains("Game Over") || message.contains("error") || message.contains("Error")) {
            label.setStyle("-fx-text-fill: #f38ba8; -fx-font-weight: bold;");
        } else if (message.contains("⭐") || message.contains("SUBISTE DE NIVEL") || message.contains("restaurado") || message.contains("guardada") || message.contains("exitosamente")) {
            label.setStyle("-fx-text-fill: #a6e3a1; -fx-font-weight: bold;");
        } else if (message.contains("⚔️") || message.contains("atacó") || message.contains("contraatacó") || message.contains("daño")) {
            label.setStyle("-fx-text-fill: #f9e2af;");
        } else if (message.contains("botín") || message.contains("encontrado") || message.contains("equipado") || message.contains("mochila") || message.contains("quitado")) {
            label.setStyle("-fx-text-fill: #cba6f7;");
        } else {
            label.setStyle("-fx-text-fill: #bac2de;");
        }
        
        logListView.getItems().add(label);
        logListView.scrollTo(logListView.getItems().size() - 1);
    }

    public BorderPane getView() {
        return mainView;
    }
}
