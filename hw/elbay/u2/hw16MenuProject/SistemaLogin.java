/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemalogin;

/**
 *
 * @author Didier Elbay  <Code_Bros , @ESPE>
 */
import javax.swing.*;
import java.awt.event.*;

public class SistemaLogin extends JFrame implements ActionListener {
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnIngresar;

    public SistemaLogin() {
        // Configuración de la ventana
        setTitle("Acceso al Sistema");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        // Etiquetas y campos
        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(20, 30, 80, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(100, 30, 150, 25);
        add(txtUsuario);

        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setBounds(20, 70, 80, 25);
        add(lblPass);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(100, 70, 150, 25);
        add(txtPassword);

        // Botón
        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(100, 120, 100, 30);
        btnIngresar.addActionListener(this);
        add(btnIngresar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String usuario = txtUsuario.getText();
        String pass = new String(txtPassword.getPassword());

        // Credenciales de ejemplo
        if (usuario.equals("admin") && pass.equals("1234")) {
            JOptionPane.showMessageDialog(this, "Acceso concedido");
        } else {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SistemaLogin ventana = new SistemaLogin();
        ventana.setVisible(true);
    }
}