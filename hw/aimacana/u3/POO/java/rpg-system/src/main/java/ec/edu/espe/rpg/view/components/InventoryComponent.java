package ec.edu.espe.rpg.view.components;

import ec.edu.espe.rpg.controller.GameController;
import ec.edu.espe.rpg.model.entities.Item;
import ec.edu.espe.rpg.model.entities.Potion;
import ec.edu.espe.rpg.model.entities.Weapon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.util.function.Consumer;

public class InventoryComponent extends VBox {

    private final GameController gameController;
    private final Runnable onUpdate;
    private final Consumer<String> logger;

    private FlowPane inventoryPane;
    private Button btnLoot;

    public InventoryComponent(GameController gameController, Runnable onUpdate, Consumer<String> logger) {
        this.gameController = gameController;
        this.onUpdate = onUpdate;
        this.logger = logger;
        buildUI();
    }

    private void buildUI() {
        setPadding(new Insets(20));
        getStyleClass().add("card");
        VBox.setVgrow(this, Priority.ALWAYS);

        Label lblTitle = new Label("Mochila (Inventario)");
        lblTitle.getStyleClass().add("card-title");
        
        inventoryPane = new FlowPane();
        inventoryPane.setHgap(10);
        inventoryPane.setVgap(10);
        
        btnLoot = new Button("🔍 Buscar Botín");
        btnLoot.setMaxWidth(Double.MAX_VALUE);
        btnLoot.getStyleClass().addAll("btn", "btn-warning");
        btnLoot.setOnAction(e -> {
            logger.accept(gameController.lootRandomItem());
            update();
            onUpdate.run();
        });

        getChildren().addAll(lblTitle, inventoryPane, new Separator(), btnLoot);
    }

    public void update() {
        inventoryPane.getChildren().clear();
        boolean hasCharacter = gameController.getCurrentCharacter() != null;
        btnLoot.setDisable(!hasCharacter);

        if (hasCharacter) {
            for (Item item : gameController.getCurrentCharacter().getInventory()) {
                addVisualItem(item);
            }
        }
    }

    private void addVisualItem(Item item) {
        VBox itemBox = new VBox(5);
        itemBox.setAlignment(Pos.CENTER);
        itemBox.setPadding(new Insets(5));
        itemBox.getStyleClass().add("inventory-item");
        
        ImageView icon = new ImageView();
        icon.setFitWidth(50);
        icon.setFitHeight(50);
        
        String imgPath;
        String labelName;
        if (item instanceof Potion) {
            imgPath = "/images/potion.png";
            labelName = "Poción";
        } else if (item instanceof Weapon) {
            imgPath = "/images/weapon.png";
            labelName = "Arma";
        } else if (item instanceof ec.edu.espe.rpg.model.entities.Armor) {
            ec.edu.espe.rpg.model.enums.ArmorSlot slot = ((ec.edu.espe.rpg.model.entities.Armor) item).getSlot();
            switch(slot) {
                case HELMET: imgPath = "/images/helmet.png"; labelName = "Casco"; break;
                case CHEST: imgPath = "/images/chest.png"; labelName = "Pechera"; break;
                case LEGS: imgPath = "/images/legs.png"; labelName = "Pantalones"; break;
                case BOOTS: imgPath = "/images/boots.png"; labelName = "Botas"; break;
                default: imgPath = "/images/armor.png"; labelName = "Armadura"; break;
            }
        } else {
            imgPath = "/images/artifact.png";
            labelName = "Artefacto";
        }

        try {
            icon.setImage(new Image(getClass().getResourceAsStream(imgPath)));
        } catch(Exception ex) {}

        Label lblItem = new Label(labelName);
        lblItem.setStyle("-fx-text-fill: #bac2de; -fx-font-size: 11px;");
        itemBox.getChildren().addAll(icon, lblItem);
        
        itemBox.setOnDragDetected(e -> {
            if (gameController.getCurrentCharacter() == null) return;
            javafx.scene.input.Dragboard db = itemBox.startDragAndDrop(javafx.scene.input.TransferMode.MOVE);
            javafx.scene.input.ClipboardContent content = new javafx.scene.input.ClipboardContent();
            content.putString(item.getId());
            db.setContent(content);
            e.consume();
        });
        
        inventoryPane.getChildren().add(itemBox);
    }
}
