import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class GestionEstudiantes extends JFrame {

    JTextField txtId, txtNombre;
    JSlider sliderEdad;
    JComboBox<String> comboCurso;
    JTable tabla;
    DefaultTableModel modelo;

    public GestionEstudiantes() {

        setTitle("Gestión de Estudiantes");
        setSize(600,400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel lblId = new JLabel("ID");
        lblId.setBounds(20,20,100,25);
        add(lblId);

        txtId = new JTextField();
        txtId.setBounds(100,20,150,25);
        add(txtId);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(20,60,100,25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(100,60,150,25);
        add(txtNombre);

        JLabel lblEdad = new JLabel("Edad");
        lblEdad.setBounds(20,100,100,25);
        add(lblEdad);

        sliderEdad = new JSlider(0,100,18);
        sliderEdad.setBounds(100,100,150,40);
        add(sliderEdad);

        comboCurso = new JComboBox<>();
        comboCurso.addItem("Matemáticas");
        comboCurso.addItem("Física");
        comboCurso.addItem("Inglés");
        comboCurso.setBounds(100,150,150,25);
        add(comboCurso);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(300,20,120,30);
        add(btnGuardar);

        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Edad");
        modelo.addColumn("Curso");

        tabla = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(20,200,540,130);
        add(scroll);

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                modelo.addRow(new Object[]{
                    txtId.getText(),
                    txtNombre.getText(),
                    sliderEdad.getValue(),
                    comboCurso.getSelectedItem()
                });
            }
        });
    }

    public static void main(String[] args) {
        new GestionEstudiantes().setVisible(true);
    }
}