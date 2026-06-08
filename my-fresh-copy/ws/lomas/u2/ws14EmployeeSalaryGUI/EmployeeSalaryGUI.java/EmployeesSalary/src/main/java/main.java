import ec.edu.espe.EmployeeSalary.view.EmployeeView;
import javax.swing.SwingUtilities;

public class main {
    public static void main(String[] args) {
        // Ejecuta la interfaz gráfica de forma segura
        SwingUtilities.invokeLater(() -> {
            EmployeeView view = new EmployeeView();
            view.setVisible(true);
        });
    }
}
