package ec.edu.espe.rpg.view.components;

import ec.edu.espe.rpg.controller.GameController;
import ec.edu.espe.rpg.model.entities.Character;
import ec.edu.espe.rpg.model.entities.Mage;
import ec.edu.espe.rpg.model.entities.Warrior;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class PlayerStatsComponent extends VBox {

    private final GameController gameController;

    private Label lblNameStat;
    private Label lblClassStat;
    private ProgressBar hpBar;
    private Label lblHpText;
    private Label lblPrimaryStat;
    private Label lblSecondaryStat;
    private ImageView playerAvatar;

    private Label lblBonusDamage;
    private Label lblBonusDefense;
    private javafx.scene.layout.FlowPane equipPane;

    private final Runnable onUpdate;
    private final java.util.function.Consumer<String> logger;

    public PlayerStatsComponent(GameController gameController, Runnable onUpdate, java.util.function.Consumer<String> logger) {
        this.gameController = gameController;
        this.onUpdate = onUpdate;
        this.logger = logger;
        buildUI();
    }

    private void buildUI() {
        setPadding(new Insets(20));
        getStyleClass().add("card");

        Label lblTitle = new Label("Tu Personaje");
        lblTitle.getStyleClass().add("card-title");

        HBox topBox = new HBox(15);
        topBox.setAlignment(Pos.CENTER_LEFT);

        playerAvatar = new ImageView();
        playerAvatar.setFitWidth(100);
        playerAvatar.setFitHeight(100);

        VBox infoBox = new VBox(5);
        lblNameStat = new Label("Desconocido");
        lblNameStat.getStyleClass().add("stats-name");

        lblClassStat = new Label("Ninguna");
        lblClassStat.getStyleClass().add("stats-class-badge");
        infoBox.getChildren().addAll(lblNameStat, lblClassStat);

        topBox.getChildren().addAll(playerAvatar, infoBox);

        VBox hpBox = new VBox(8);
        hpBox.setPadding(new Insets(10, 0, 0, 0));
        Label hpTitle = new Label("Salud Vital (HP)");
        hpTitle.getStyleClass().add("hp-title");

        HBox hpBarContainer = new HBox(15);
        hpBarContainer.setAlignment(Pos.CENTER_LEFT);
        hpBar = new ProgressBar(0);
        hpBar.getStyleClass().add("hp-bar-container");
        HBox.setHgrow(hpBar, Priority.ALWAYS);
        hpBar.setMaxWidth(Double.MAX_VALUE);

        lblHpText = new Label("0 / 0");
        lblHpText.getStyleClass().add("hp-text");
        hpBarContainer.getChildren().addAll(hpBar, lblHpText);
        hpBox.getChildren().addAll(hpTitle, hpBarContainer);

        HBox detailsBox = new HBox(50);
        detailsBox.setPadding(new Insets(15, 0, 0, 0));

        VBox priBox = new VBox(5);
        Label priTitle = new Label("Atributo Primario");
        priTitle.getStyleClass().add("stat-title");
        lblPrimaryStat = new Label("-");
        lblPrimaryStat.getStyleClass().add("primary-stat-val");
        priBox.getChildren().addAll(priTitle, lblPrimaryStat);

        VBox secBox = new VBox(5);
        Label secTitle = new Label("Recurso Especial");
        secTitle.getStyleClass().add("stat-title");
        lblSecondaryStat = new Label("-");
        lblSecondaryStat.getStyleClass().add("secondary-stat-val");
        secBox.getChildren().addAll(secTitle, lblSecondaryStat);

        detailsBox.getChildren().addAll(priBox, secBox);

        HBox combatStatsBox = new HBox(50);
        combatStatsBox.setPadding(new Insets(15, 0, 0, 0));

        VBox dmgBox = new VBox(5);
        Label dmgTitle = new Label("Bonus Daño");
        dmgTitle.getStyleClass().add("stat-title");
        lblBonusDamage = new Label("0.0");
        lblBonusDamage.getStyleClass().add("secondary-stat-val");
        dmgBox.getChildren().addAll(dmgTitle, lblBonusDamage);

        VBox defBox = new VBox(5);
        Label defTitle = new Label("Defensa");
        defTitle.getStyleClass().add("stat-title");
        lblBonusDefense = new Label("0.0");
        lblBonusDefense.getStyleClass().add("secondary-stat-val");
        defBox.getChildren().addAll(defTitle, lblBonusDefense);

        combatStatsBox.getChildren().addAll(dmgBox, defBox);

        VBox equipBox = new VBox(10);
        equipBox.setPadding(new Insets(20, 0, 0, 0));
        Label equipTitle = new Label("Equipamiento Activo");
        equipTitle.getStyleClass().add("card-title");
        equipTitle.setStyle("-fx-font-size: 14px;");

        equipPane = new javafx.scene.layout.FlowPane();
        equipPane.setHgap(10);
        equipPane.setVgap(10);

        setupDropTarget(playerAvatar);

        equipBox.getChildren().addAll(equipTitle, equipPane);
        
        getChildren().addAll(lblTitle, topBox, new Separator(), hpBox, detailsBox, combatStatsBox, new Separator(), equipBox);
    }

    private void setupDropTarget(javafx.scene.Node target) {
        target.setOnDragOver(e -> {
            if (e.getDragboard().hasString()) {
                e.acceptTransferModes(javafx.scene.input.TransferMode.MOVE);
            }
            e.consume();
        });
        target.setOnDragDropped(e -> {
            javafx.scene.input.Dragboard db = e.getDragboard();
            boolean success = false;
            if (db.hasString()) {
                String itemId = db.getString();
                String result = gameController.interactWithItemById(itemId);
                logger.accept(result);
                onUpdate.run();
                success = true;
            }
            e.setDropCompleted(success);
            e.consume();
        });
    }

    public void update() {
        Character c = gameController.getCurrentCharacter();
        if (c == null) {
            lblNameStat.setText("Sin Personaje");
            lblClassStat.setText("N/A");
            hpBar.setProgress(0);
            lblHpText.setText("0 / 0");
            lblPrimaryStat.setText("-");
            lblSecondaryStat.setText("-");
            playerAvatar.setImage(null);
            lblBonusDamage.setText("0.0");
            lblBonusDefense.setText("0.0");
            equipPane.getChildren().clear();
            return;
        }

        lblNameStat.setText(c.getName() + " (Nivel " + c.getLevel() + ")");
        double hpProgress = c.getHp() / c.getMaxHp();
        hpBar.setProgress(hpProgress);
        lblHpText.setText(String.format("%.0f / %.0f", c.getHp(), c.getMaxHp()));
        
        if (hpProgress > 0.5) hpBar.setStyle("-fx-accent: #a6e3a1;");
        else if (hpProgress > 0.2) hpBar.setStyle("-fx-accent: #f9e2af;");
        else hpBar.setStyle("-fx-accent: #f38ba8;");

        lblBonusDamage.setText(String.format("+%.1f", c.getBonusDamage()));
        lblBonusDefense.setText(String.format("+%.1f", c.getBonusDefense()));

        equipPane.getChildren().clear();
        
        equipPane.getChildren().add(buildSlotUI(c.getEquippedWeapon(), "Arma", "/images/weapon.png", () -> gameController.unequipWeapon()));
        equipPane.getChildren().add(buildSlotUI(c.getEquippedArmor(ec.edu.espe.rpg.model.enums.ArmorSlot.HELMET), "Casco", "/images/helmet.png", () -> gameController.unequipArmor(ec.edu.espe.rpg.model.enums.ArmorSlot.HELMET)));
        equipPane.getChildren().add(buildSlotUI(c.getEquippedArmor(ec.edu.espe.rpg.model.enums.ArmorSlot.CHEST), "Pechera", "/images/chest.png", () -> gameController.unequipArmor(ec.edu.espe.rpg.model.enums.ArmorSlot.CHEST)));
        equipPane.getChildren().add(buildSlotUI(c.getEquippedArmor(ec.edu.espe.rpg.model.enums.ArmorSlot.LEGS), "Pantalones", "/images/legs.png", () -> gameController.unequipArmor(ec.edu.espe.rpg.model.enums.ArmorSlot.LEGS)));
        equipPane.getChildren().add(buildSlotUI(c.getEquippedArmor(ec.edu.espe.rpg.model.enums.ArmorSlot.BOOTS), "Botas", "/images/boots.png", () -> gameController.unequipArmor(ec.edu.espe.rpg.model.enums.ArmorSlot.BOOTS)));
        equipPane.getChildren().add(buildSlotUI(c.getEquippedArtifact(ec.edu.espe.rpg.model.enums.ArtifactSlot.RING), "Anillo", "/images/ring.png", () -> gameController.unequipArtifact(ec.edu.espe.rpg.model.enums.ArtifactSlot.RING)));
        equipPane.getChildren().add(buildSlotUI(c.getEquippedArtifact(ec.edu.espe.rpg.model.enums.ArtifactSlot.AMULET), "Amuleto", "/images/amulet.png", () -> gameController.unequipArtifact(ec.edu.espe.rpg.model.enums.ArtifactSlot.AMULET)));

        try {
            if (c instanceof Warrior) {
                Warrior w = (Warrior) c;
                lblClassStat.setText("Guerrero | EXP: " + c.getExp() + "/100");
                lblPrimaryStat.setText("Fuerza: " + w.getStrength());
                lblSecondaryStat.setText(w.getRage() + " Pts");
                playerAvatar.setImage(new Image(getClass().getResourceAsStream("/images/warrior.png")));
            } else if (c instanceof Mage) {
                Mage m = (Mage) c;
                lblClassStat.setText("Mago | EXP: " + c.getExp() + "/100");
                lblPrimaryStat.setText("Inteligencia: " + m.getIntelligence());
                lblSecondaryStat.setText(m.getMana() + " Pts");
                playerAvatar.setImage(new Image(getClass().getResourceAsStream("/images/mage.png")));
            }
        } catch(Exception ex) {}
    }

    private VBox buildSlotUI(ec.edu.espe.rpg.model.entities.Item item, String emptyName, String defaultIcon, java.util.function.Supplier<String> unequipAction) {
        VBox box = new VBox(5);
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(5));
        
        ImageView icon = new ImageView();
        icon.setFitWidth(40);
        icon.setFitHeight(40);
        
        String title = emptyName;
        if (item != null) {
            title = item.getName();
            box.getStyleClass().add("equipped-slot");
        } else {
            box.getStyleClass().add("equipped-slot-empty");
            icon.setOpacity(0.3);
        }

        try {
            icon.setImage(new javafx.scene.image.Image(getClass().getResourceAsStream(defaultIcon)));
        } catch(Exception e) {}
        
        Label lblName = new Label(title);
        lblName.setStyle("-fx-text-fill: #bac2de; -fx-font-size: 10px;");
        lblName.setWrapText(true);
        lblName.setAlignment(Pos.CENTER);
        lblName.setMaxWidth(60);
        
        box.getChildren().addAll(icon, lblName);
        
        setupDropTarget(box);
        
        box.setOnMouseClicked(e -> {
            if (item != null) {
                String result = unequipAction.get();
                logger.accept(result);
                onUpdate.run();
            }
        });
        
        return box;
    }
}
