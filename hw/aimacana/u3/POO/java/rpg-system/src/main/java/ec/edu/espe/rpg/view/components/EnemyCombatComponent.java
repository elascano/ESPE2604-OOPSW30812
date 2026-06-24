package ec.edu.espe.rpg.view.components;

import ec.edu.espe.rpg.controller.GameController;
import ec.edu.espe.rpg.model.entities.Character;
import ec.edu.espe.rpg.model.entities.Warrior;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.util.function.Consumer;

public class EnemyCombatComponent extends VBox {

    private final GameController gameController;
    private final Runnable onUpdate;
    private final Consumer<String> logger;
    
    private Character currentEnemy;
    private ProgressBar enemyHpBar;
    private Label lblEnemyHpText;
    private Button btnAttack;

    public EnemyCombatComponent(GameController gameController, Runnable onUpdate, Consumer<String> logger) {
        this.gameController = gameController;
        this.onUpdate = onUpdate;
        this.logger = logger;
        this.currentEnemy = ec.edu.espe.rpg.model.factories.EnemyFactory.spawnEnemyForLevel(1);
        buildUI();
    }

    private void buildUI() {
        setPadding(new Insets(20));
        getStyleClass().add("card");
        setStyle("-fx-border-color: #f38ba8; -fx-border-radius: 12px; -fx-background-color: #181825; -fx-background-radius: 12px; -fx-border-width: 2px;");

        Label lblTitle = new Label("Zona de Combate");
        lblTitle.getStyleClass().add("card-title");

        HBox topBox = new HBox(15);
        topBox.setAlignment(Pos.CENTER_LEFT);
        
        ImageView enemyAvatar = new ImageView();
        try {
            enemyAvatar.setImage(new Image(getClass().getResourceAsStream("/images/enemy.png")));
        } catch (Exception e) {}
        enemyAvatar.setFitWidth(80);
        enemyAvatar.setFitHeight(80);
        
        VBox infoBox = new VBox(5);
        Label lblEnemyName = new Label(currentEnemy.getName());
        lblEnemyName.getStyleClass().add("stats-name");
        Label lblEnemyType = new Label("Monstruo Salvaje");
        lblEnemyType.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-background-color: #45475a; -fx-padding: 4px 8px; -fx-background-radius: 20px; -fx-text-fill: #f38ba8;");
        infoBox.getChildren().addAll(lblEnemyName, lblEnemyType);
        
        topBox.getChildren().addAll(enemyAvatar, infoBox);

        VBox hpBox = new VBox(8);
        hpBox.setPadding(new Insets(10, 0, 0, 0));
        HBox hpBarContainer = new HBox(15);
        hpBarContainer.setAlignment(Pos.CENTER_LEFT);
        
        enemyHpBar = new ProgressBar(1.0);
        enemyHpBar.setStyle("-fx-accent: #f38ba8; -fx-control-inner-background: #313244; -fx-background-color: transparent;");
        HBox.setHgrow(enemyHpBar, Priority.ALWAYS);
        enemyHpBar.setMaxWidth(Double.MAX_VALUE);
        
        lblEnemyHpText = new Label("200 / 200");
        lblEnemyHpText.getStyleClass().add("hp-text");
        hpBarContainer.getChildren().addAll(enemyHpBar, lblEnemyHpText);
        hpBox.getChildren().addAll(hpBarContainer);

        btnAttack = new Button("⚔️ Atacar Enemigo");
        btnAttack.setMaxWidth(Double.MAX_VALUE);
        btnAttack.getStyleClass().addAll("btn", "btn-danger");
        btnAttack.setOnAction(e -> handleAttack());
        
        getChildren().addAll(lblTitle, topBox, hpBox, btnAttack);
        update();
    }

    private void handleAttack() {
        if (currentEnemy.getHp() <= 0) {
            logger.accept("El enemigo ya está muerto.");
            return;
        }
        logger.accept(gameController.attackTarget(currentEnemy));
        update();
        onUpdate.run();
    }

    public void update() {
        boolean playerActive = gameController.getCurrentCharacter() != null;
        btnAttack.setDisable(!playerActive);

        double hpProgress = currentEnemy.getHp() / currentEnemy.getMaxHp();
        enemyHpBar.setProgress(hpProgress);
        lblEnemyHpText.setText(String.format("%.0f / %.0f", currentEnemy.getHp(), currentEnemy.getMaxHp()));
        
        if(currentEnemy.getHp() <= 0 && playerActive) {
            logger.accept("¡Has derrotado al monstruo! Buscando botín...");
            currentEnemy = ec.edu.espe.rpg.model.factories.EnemyFactory.spawnEnemyForLevel(gameController.getCurrentCharacter().getLevel());
            update();
        }
    }

    public boolean checkLoot() {
        return currentEnemy.getHp() <= 0;
    }
}
