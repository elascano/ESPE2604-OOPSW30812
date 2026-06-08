package ec.edu.espe.view;

import ec.edu.espe.controller.StudentController;
import ec.edu.espe.model.Student;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GradesStudentApp extends Application {

    private StudentController controller;

    // Componentes del Formulario de Registro
    private TextField txtId, txtFirstName, txtLastName, txtPhone;
    private Button btnRegister;

    // Componentes del Formulario de Notas
    private ComboBox<String> cmbStudents;
    private TextField txtGrade1, txtGrade2, txtGrade3;
    private Button btnSaveGrades;

    // Componentes del Reporte (Tabla)
    private TableView<StudentRowData> tblReport;
    private ObservableList<StudentRowData> reportData;

    @Override
    public void start(Stage primaryStage) {
        controller = new StudentController();

        // Contenedor principal de pestañas
        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // Crear las pestañas
        Tab tabRegister = new Tab("👤 Register Student", createRegisterPanel());
        Tab tabGrades = new Tab("📝 Input Grades", createGradesPanel());
        Tab tabReport = new Tab("📊 Grades Report", createReportPanel());

        tabPane.getTabs().addAll(tabRegister, tabGrades, tabReport);

        // Listener para actualizar datos al cambiar de pestaña
        tabPane.getSelectionModel().selectedIndexProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal.intValue() == 1) {
                updateStudentComboBox();
            } else if (newVal.intValue() == 2) {
                refreshReportTable();
            }
        });

        Scene scene = new Scene(tabPane, 850, 550);
        
        // Estilo css opcional integrado para fuentes limpias
        scene.getRoot().setStyle("-fx-font-family: 'Segoe UI'; -fx-font-size: 13px;");

        primaryStage.setTitle("ESPE - Student Grades Management System (JavaFX)");
        primaryStage.setScene(scene);
        
        // CORRECCIÓN: Se elimina el método setLocationRelativeTo(null) de Swing. 
        // JavaFX centra la ventana automáticamente en la pantalla al llamar a show().
        primaryStage.show();
    }

    private VBox createRegisterPanel() {
        VBox root = new VBox(20);
        root.setPadding(new Insets(30));
        root.setAlignment(Pos.CENTER);

        GridPane grid = new GridPane();
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setAlignment(Pos.CENTER);

        txtId = new TextField();
        txtFirstName = new TextField();
        txtLastName = new TextField();
        txtPhone = new TextField();
        
        btnRegister = new Button("Register Student");
        btnRegister.setStyle("-fx-background-color: #3498db; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 10 20 10 20; -fx-cursor: hand;");

        grid.add(new Label("Student ID:"), 0, 0);
        grid.add(txtId, 1, 0);
        grid.add(new Label("First Name:"), 0, 1);
        grid.add(txtFirstName, 1, 1);
        grid.add(new Label("Last Name:"), 0, 2);
        grid.add(txtLastName, 1, 2);
        grid.add(new Label("Phone Number:"), 0, 3);
        grid.add(txtPhone, 1, 3);

        btnRegister.setOnAction(e -> {
            if (txtId.getText().isEmpty() || txtFirstName.getText().isEmpty()
                    || txtLastName.getText().isEmpty() || txtPhone.getText().isEmpty()) {
                showAlert(Alert.AlertType.ERROR, "Error", "All fields are required!");
                return;
            }

            controller.registerStudent(txtId.getText(), txtFirstName.getText(), txtLastName.getText(), txtPhone.getText());
            showAlert(Alert.AlertType.INFORMATION, "Success", "Student registered successfully!");

            txtId.clear();
            txtFirstName.clear();
            txtLastName.clear();
            txtPhone.clear();
        });

        root.getChildren().addAll(grid, btnRegister);
        return root;
    }

    private VBox createGradesPanel() {
        VBox root = new VBox(20);
        root.setPadding(new Insets(30));
        root.setAlignment(Pos.CENTER);

        GridPane grid = new GridPane();
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setAlignment(Pos.CENTER);

        cmbStudents = new ComboBox<>();
        cmbStudents.setPrefWidth(250);
        
        txtGrade1 = new TextField();
        txtGrade2 = new TextField();
        txtGrade3 = new TextField();
        
        btnSaveGrades = new Button("Save 3 Grades");
        btnSaveGrades.setStyle("-fx-background-color: #2ecc71; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 10 20 10 20; -fx-cursor: hand;");

        grid.add(new Label("Select Student:"), 0, 0);
        grid.add(cmbStudents, 1, 0);
        grid.add(new Label("Grade 1 (0-20):"), 0, 1);
        grid.add(txtGrade1, 1, 1);
        grid.add(new Label("Grade 2 (0-20):"), 0, 2);
        grid.add(txtGrade2, 1, 2);
        grid.add(new Label("Grade 3 (0-20):"), 0, 3);
        grid.add(txtGrade3, 1, 3);

        btnSaveGrades.setOnAction(e -> {
            String selectedItem = cmbStudents.getValue();
            if (selectedItem == null || selectedItem.startsWith("No students")) {
                showAlert(Alert.AlertType.ERROR, "Error", "Please select a valid student.");
                return;
            }

            String targetId = selectedItem.split(" - ")[0].replace("ID: ", "").trim();
            ArrayList<Double> gradesList = new ArrayList<>();

            try {
                gradesList.add(Double.parseDouble(txtGrade1.getText()));
                gradesList.add(Double.parseDouble(txtGrade2.getText()));
                gradesList.add(Double.parseDouble(txtGrade3.getText()));

                if (controller.addGradesToStudent(targetId, gradesList)) {
                    showAlert(Alert.AlertType.INFORMATION, "Success", "All 3 grades added successfully!");
                    txtGrade1.clear();
                    txtGrade2.clear();
                    txtGrade3.clear();
                } else {
                    showAlert(Alert.AlertType.WARNING, "Validation Error", "Grades must be between 0 and 20.");
                }
            } catch (NumberFormatException ex) {
                showAlert(Alert.AlertType.ERROR, "Input Error", "Please enter valid numbers for all grades.");
            }
        });

        root.getChildren().addAll(grid, btnSaveGrades);
        return root;
    }

    @SuppressWarnings("unchecked")
    private VBox createReportPanel() {
        VBox root = new VBox(15);
        root.setPadding(new Insets(15));

        tblReport = new TableView<>();
        reportData = FXCollections.observableArrayList();
        tblReport.setItems(reportData);

        // Definición de columnas mapeando las propiedades de los datos
        TableColumn<StudentRowData, String> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(data -> data.getValue().idProperty());

        TableColumn<StudentRowData, String> colFirstName = new TableColumn<>("First Name");
        colFirstName.setCellValueFactory(data -> data.getValue().firstNameProperty());

        TableColumn<StudentRowData, String> colLastName = new TableColumn<>("Last Name");
        colLastName.setCellValueFactory(data -> data.getValue().lastNameProperty());

        TableColumn<StudentRowData, String> colGrades = new TableColumn<>("Grades");
        colGrades.setCellValueFactory(data -> data.getValue().gradesProperty());

        TableColumn<StudentRowData, String> colAverage = new TableColumn<>("Average");
        colAverage.setCellValueFactory(data -> data.getValue().averageProperty());

        TableColumn<StudentRowData, String> colStatus = new TableColumn<>("Status");
        colStatus.setCellValueFactory(data -> data.getValue().statusProperty());

        tblReport.getColumns().addAll(colId, colFirstName, colLastName, colGrades, colAverage, colStatus);
        
        // CORRECCIÓN: Ajuste de sintaxis estándar para redimensionamiento automático en JavaFX moderno
        tblReport.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        root.getChildren().add(tblReport);
        VBox.setVgrow(tblReport, Priority.ALWAYS);

        return root;
    }

    private void updateStudentComboBox() {
        cmbStudents.getItems().clear();
        ArrayList<Student> list = controller.getAllStudents();
        if (list.isEmpty()) {
            cmbStudents.getItems().add("No students registered yet.");
        } else {
            for (Student s : list) {
                cmbStudents.getItems().add("ID: " + s.getId() + " - " + s.getFirstName() + " " + s.getLastName());
            }
        }
    }

    private void refreshReportTable() {
        reportData.clear();
        ArrayList<Student> list = controller.getAllStudents();

        for (Student s : list) {
            ArrayList<Double> studentGrades = controller.getGradesByStudent(s.getId());
            double avg = controller.calculateAverage(s.getId());
            String status = (avg >= 14.0) ? "PASS" : "FAIL";

            reportData.add(new StudentRowData(
                    s.getId(),
                    s.getFirstName(),
                    s.getLastName(),
                    studentGrades.toString(),
                    String.format("%.2f", avg),
                    status
            ));
        }
    }

    private void showAlert(Alert.AlertType type, String title, String content) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }

    // --- CLASE CONTENEDORA ANIDADA (REQUERIDA PARA EL TABLEVIEW DE JAVAFX) ---
    public static class StudentRowData {
        private final SimpleStringProperty id;
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty grades;
        private final SimpleStringProperty average;
        private final SimpleStringProperty status;

        public StudentRowData(String id, String firstName, String lastName, String grades, String average, String status) {
            this.id = new SimpleStringProperty(id);
            this.firstName = new SimpleStringProperty(firstName);
            this.lastName = new SimpleStringProperty(lastName);
            this.grades = new SimpleStringProperty(grades);
            this.average = new SimpleStringProperty(average);
            this.status = new SimpleStringProperty(status);
        }

        public SimpleStringProperty idProperty() { return id; }
        public SimpleStringProperty firstNameProperty() { return firstName; }
        public SimpleStringProperty lastNameProperty() { return lastName; }
        public SimpleStringProperty gradesProperty() { return grades; }
        public SimpleStringProperty averageProperty() { return average; }
        public SimpleStringProperty statusProperty() { return status; }
    }
}