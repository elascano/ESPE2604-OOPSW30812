
package ec.edu.espe.strategypattern.view;
import ec.edu.espe.strategypattern.controller.SortService;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Alexander Tipantiza, CodeBreakers, @ESPE
 */


public class SortApp extends JFrame {
    private JTextField inputDataField;
    private JTextArea displayArea;
    private JButton processButton;
    private SortService sortService;

    public SortApp() {
        initComponents();
    }

    private void initComponents() {
        sortService = new SortService();

        setTitle("Strategy Pattern Manager - Alexander Tipantiza");
        setSize(520, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(12, 12));

        JPanel headerPanel = new JPanel(new BorderLayout(8, 8));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(12, 12, 0, 12));
        
        JLabel inputLabel = new JLabel("Enter numbers separated by commas:");
        inputDataField = new JTextField();
        processButton = new JButton("Sort & Save to Cloud");

        headerPanel.add(inputLabel, BorderLayout.NORTH);
        headerPanel.add(inputDataField, BorderLayout.CENTER);
        headerPanel.add(processButton, BorderLayout.EAST);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font("Monospaced", Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(displayArea);
        scrollPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(0, 12, 12, 12),
                BorderFactory.createTitledBorder("Processing Results")
        ));

        add(headerPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        processButton.addActionListener(e -> handleSortAction());
    }

    private void handleSortAction() {
        try {
            String summary = sortService.executeSortOperation(inputDataField.getText());
            displayArea.setText(summary + "\n\n[Status]: Data synchronized with MongoDB Atlas successfully!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Format error: Please enter valid integers.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Operation Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public JTextField getInputDataField() {
        return inputDataField;
    }

    public void setInputDataField(JTextField inputDataField) {
        this.inputDataField = inputDataField;
    }

    public JTextArea getDisplayArea() {
        return displayArea;
    }

    public void setDisplayArea(JTextArea displayArea) {
        this.displayArea = displayArea;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SortApp().setVisible(true));
    }
}

































/** q tenga todos los conceptos osea si es necesario aplica getters y setters o constructores y eso, ademas usa nombres mas atractivos en dodne no esten los algoritmos de orden, y en el utils llama a la calse MongoDBConnection para q se vea mas atractivo**/

/**genera el codigo con las especificaciones que dice y la imagen, el programa es en JAVA MAVEN, mi nombre es Alexander apellido Tipantiza, coloca los nombres de las clase para el ejemplo de busquedacomo tu creas conveniente pero usando CLEAN CODE - SIN COMENTARIOS, estructura MVC, y usa UTILS para la coneccion a MONGODB: mongodb+srv://tipantizaalexander:Alexander20@cluster0.z86uqo3.mongodb.net/?appName=Cluster0(mi link de coneccion), y usa un GUI para la visualizacion de la salida y toma de datos, usa ya sea caja de textos o tabla o lo q q sea mas factible acorde al enunciado pero q guarde los cambios o practicas q haga a la base de datos, x ejemplo q salga el arreglo o listado de numeros original, luego el arreglado, el tipo de algoritmo utilizafo y eso, tambn utiliza los algoritmos de busqueda q esta seleccionado en la imagen para arregalr diferentes tipois de listados dependiendo de su tamaño, me das el codigo lo mas resumido sin alargar lineas de codigo en especial en la coneccion a MONGODB pero mantendiendo el CLEAN CODE, todo el codigo en ingles, el nombre de mi proyecto es StrategyPattern, y los packages empiezan por ec.edu.espe. asi, y me das el pom para q este todas las pedendencias y cosas q necesite el codigo y sea funcinal */