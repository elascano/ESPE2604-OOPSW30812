/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.edducativeapp.view;

import com.mycompany.edducativeapp.controller.*;
import com.mycompany.edducativeapp.model.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Odalys Chavez, CodeBreakers, @ESPE
 */
public class frmEducativeApp extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(frmEducativeApp.class.getName());
        private final StudentDAO StudentDAO;
        private final TeacherDAO TeacherDAO;
        private final RegisterDAO RegisterDAO;
    /**
     * Creates new form frmEducativeApp
     */
    public frmEducativeApp() {
        initComponents();
        
        StudentDAO = new StudentDAO();
        TeacherDAO = new TeacherDAO();
        RegisterDAO = new RegisterDAO();
        
        // Configurar tablas
        setupTables();
        
        // Cargar datos iniciales
        listStudents();
        listTeachers();
        
    }private void setupTables() {
// Configurar tabla de estudiantes para que sea editable
                tblStudents.putClientProperty("terminateEditOnFocusLost", true);
    }
    // ==================== MÉTODOS PARA ESTUDIANTES ====================
    
    private void addStudent() {
        if (txtName.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el nombre del estudiante");
            return;
        }
        
        Student student = new Student(
            txtName.getText(),
            txtEmail.getText(),
            txtStudentId.getText(),
            txtCourse.getText()
        );
        
        if (StudentDAO.createStudent(student)) {
            JOptionPane.showMessageDialog(this, "✅ Estudiante agregado exitosamente!");
            clearStudentFields();
            listStudents();
        } else {
            JOptionPane.showMessageDialog(this, "❌ Error al agregar estudiante", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void listStudents() {
        DefaultTableModel model = (DefaultTableModel) tblStudents.getModel();
        model.setRowCount(0);
        
        List<Student> students = StudentDAO.getAllStudents();
        for (Student s : students) {
            model.addRow(new Object[]{
                s.getId(),
                s.getName(),
                s.getEmail(),
                s.getStudentId(),
                s.getCourse(),
                s.getGpa()
            });
        }
    }
    
    private void updateStudent() {
        int selectedRow = tblStudents.getSelectedRow();
        if (selectedRow >= 0) {
            Student student = new Student(
                txtName.getText(),
                txtEmail.getText(),
                txtStudentId.getText(),
                txtCourse.getText()
            );
            student.setId(tblStudents.getValueAt(selectedRow, 0).toString());
            
            if (StudentDAO.updateStudent(student)) {
                JOptionPane.showMessageDialog(this, "✅ Estudiante actualizado!");
                listStudents();
                clearStudentFields();
            } else {
                JOptionPane.showMessageDialog(this, "❌ Error al actualizar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un estudiante de la tabla");
        }
    }
    
    private void deleteStudent() {
        int selectedRow = tblStudents.getSelectedRow();
        if (selectedRow >= 0) {
            int confirm = JOptionPane.showConfirmDialog(this, 
                "¿Eliminar este estudiante?", 
                "Confirmar", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
            
            if (confirm == JOptionPane.YES_OPTION) {
                String id = tblStudents.getValueAt(selectedRow, 0).toString();
                if (StudentDAO.deleteStudent(id)) {
                    JOptionPane.showMessageDialog(this, "❌ Error al eliminar");
                    listStudents();
                    clearStudentFields();
                } else {
                    JOptionPane.showMessageDialog(this, "✅ Estudiante eliminado!","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un estudiante de la tabla");
        }
    }
    
    private void clearStudentFields() {
        txtName.setText("");
        txtEmail.setText("");
        txtStudentId.setText("");
        txtCourse.setText("");
        tblStudents.clearSelection();
    }
    
    // ==================== MÉTODOS PARA PROFESORES ====================
    
    private void addTeacher() {
        if (txtName1.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el nombre del profesor");
            return;
        }
        
        Teacher teacher = new Teacher(
            txtName1.getText(),
            txtEmail1.getText(),
            txtTeacherId.getText(),
            txtDepartment.getText(),
            txtSpecialization.getText()
        );
        
        if (TeacherDAO.createTeacher(teacher)) {
            JOptionPane.showMessageDialog(this, "✅ Profesor agregado exitosamente!");
            clearTeacherFields();
            listTeachers();
        } else {
            JOptionPane.showMessageDialog(this, "❌ Error al agregar profesor", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void listTeachers() {
        DefaultTableModel model = (DefaultTableModel) tblTeachers.getModel();
        model.setRowCount(0);
        
        List<Teacher> teachers = TeacherDAO.getAllTeachers();
        for (Teacher t : teachers) {
            model.addRow(new Object[]{
                t.getId(),
                t.getName(),
                t.getEmail(),
                t.getTeacherId(),
                t.getDepartment(),
                t.getSpecialization()
            });
        }
    }
    
    private void updateTeacher() {
        int selectedRow = tblTeachers.getSelectedRow();
        if (selectedRow >= 0) {
            Teacher teacher = new Teacher(
                txtName1.getText(),
                txtEmail1.getText(),
                txtTeacherId.getText(),
                txtDepartment.getText(),
                txtSpecialization.getText()
            );
            teacher.setId(tblTeachers.getValueAt(selectedRow, 0).toString());
            
            if (TeacherDAO.updateTeacher(teacher)) {
                JOptionPane.showMessageDialog(this, "✅ Profesor actualizado!");
                listTeachers();
                clearTeacherFields();
            } else {
                JOptionPane.showMessageDialog(this, "❌ Error al actualizar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un profesor de la tabla");
        }
    }
    
    private void deleteTeacher() {
        int selectedRow = tblTeachers.getSelectedRow();
        if (selectedRow >= 0) {
            int confirm = JOptionPane.showConfirmDialog(this, 
                "¿Eliminar este profesor?", 
                "Confirmar", 
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);
            
            if (confirm == JOptionPane.YES_OPTION) {
                String id = tblTeachers.getValueAt(selectedRow, 0).toString();
                if (TeacherDAO.deleteTeacher(id)) {
                    JOptionPane.showMessageDialog(this, "✅ Profesor eliminado!");
                    listTeachers();
                    clearTeacherFields();
                } else {
                    JOptionPane.showMessageDialog(this, "❌ Error al eliminar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un profesor de la tabla");
        }
    }
    
    private void clearTeacherFields() {
        txtName1.setText("");
        txtEmail1.setText("");
        txtTeacherId.setText("");
        txtDepartment.setText("");
        txtSpecialization.setText("");
        tblTeachers.clearSelection();
    }
    
    // ==================== MÉTODO PARA REGISTRO ====================
    
    private void registerUser() {
        String username = txtUsername.getText().trim();
        String password = new String(pwdPassword.getPassword()).trim();
        String email = txtEmail3.getText().trim();
        String userType = cmbUserType.getSelectedItem().toString();
        
        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos!");
            return;
        }
        
        Register register = new Register(username, password, email, userType);
        
        if (RegisterDAO.createRegister(register)) {
            JOptionPane.showMessageDialog(this, "✅ Usuario registrado exitosamente!");
            clearRegisterFields();
        } else {
            JOptionPane.showMessageDialog(this, "❌ Error al registrar usuario!\nEl usuario puede que ya exista", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void clearRegisterFields() {
        txtUsername.setText("");
        pwdPassword.setText("");
        txtEmail3.setText("");
        cmbUserType.setSelectedIndex(0);
    }
    // ==================== EVENTOS DE TABLA (Selección) ====================
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Register = new javax.swing.JTabbedPane();
        pnlStudent = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtStudentId = new javax.swing.JTextField();
        txtCourse = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnList = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudents = new javax.swing.JTable();
        pnlTeacher = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtName1 = new javax.swing.JTextField();
        txtEmail1 = new javax.swing.JTextField();
        txtTeacherId = new javax.swing.JTextField();
        txtDepartment = new javax.swing.JTextField();
        txtSpecialization = new javax.swing.JTextField();
        btnAdd1 = new javax.swing.JButton();
        btnList1 = new javax.swing.JButton();
        btnUpdate1 = new javax.swing.JButton();
        btnDelete1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTeachers = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtEmail3 = new javax.swing.JTextField();
        cmbUserType = new javax.swing.JComboBox<>();
        btnRegister = new javax.swing.JButton();
        pwdPassword = new javax.swing.JPasswordField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Name:");

        jLabel2.setText("Email:");

        jLabel3.setText("ID Student:");

        jLabel4.setText("Course:");

        txtName.setText("                            ");
        txtName.addActionListener(this::txtNameActionPerformed);

        txtEmail.addActionListener(this::txtEmailActionPerformed);

        txtStudentId.setText("                                                             ");
        txtStudentId.addActionListener(this::txtStudentIdActionPerformed);

        txtCourse.addActionListener(this::txtCourseActionPerformed);

        btnAdd.setText("Add");
        btnAdd.addActionListener(this::btnAddActionPerformed);

        btnList.setText("List");
        btnList.addActionListener(this::btnListActionPerformed);

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(this::btnUpdateActionPerformed);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(this::btnDeleteActionPerformed);

        tblStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Email", "ID Students", "Course", "GPA"
            }
        ));
        jScrollPane1.setViewportView(tblStudents);

        javax.swing.GroupLayout pnlStudentLayout = new javax.swing.GroupLayout(pnlStudent);
        pnlStudent.setLayout(pnlStudentLayout);
        pnlStudentLayout.setHorizontalGroup(
            pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStudentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlStudentLayout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnList)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete))
                    .addGroup(pnlStudentLayout.createSequentialGroup()
                        .addGroup(pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(40, 40, 40)
                        .addGroup(pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtStudentId, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(txtCourse, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))
                    .addGroup(pnlStudentLayout.createSequentialGroup()
                        .addGroup(pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlStudentLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(66, 66, 66))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlStudentLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(63, 63, 63)))
                        .addGroup(pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(txtEmail))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlStudentLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 70, Short.MAX_VALUE))
        );
        pnlStudentLayout.setVerticalGroup(
            pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStudentLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtStudentId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlStudentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnList)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        Register.addTab("Student", pnlStudent);

        jLabel5.setText("Name:");

        jLabel6.setText("Email:");

        jLabel7.setText("ID Teacher:");

        jLabel8.setText("Department:");

        jLabel9.setText("Specialization:");

        txtName1.addActionListener(this::txtName1ActionPerformed);

        txtEmail1.addActionListener(this::txtEmail1ActionPerformed);

        txtTeacherId.addActionListener(this::txtTeacherIdActionPerformed);

        txtDepartment.addActionListener(this::txtDepartmentActionPerformed);

        txtSpecialization.addActionListener(this::txtSpecializationActionPerformed);

        btnAdd1.setText("Add");
        btnAdd1.addActionListener(this::btnAdd1ActionPerformed);

        btnList1.setText("List");
        btnList1.addActionListener(this::btnList1ActionPerformed);

        btnUpdate1.setText("Update");
        btnUpdate1.addActionListener(this::btnUpdate1ActionPerformed);

        btnDelete1.setText("Delete");
        btnDelete1.addActionListener(this::btnDelete1ActionPerformed);

        tblTeachers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Email", "ID Teacher", "Department", "Specialization"
            }
        ));
        jScrollPane3.setViewportView(tblTeachers);

        javax.swing.GroupLayout pnlTeacherLayout = new javax.swing.GroupLayout(pnlTeacher);
        pnlTeacher.setLayout(pnlTeacherLayout);
        pnlTeacherLayout.setHorizontalGroup(
            pnlTeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTeacherLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlTeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTeacherLayout.createSequentialGroup()
                        .addComponent(btnAdd1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnList1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete1))
                    .addGroup(pnlTeacherLayout.createSequentialGroup()
                        .addGroup(pnlTeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(85, 85, 85)
                        .addGroup(pnlTeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName1, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(txtEmail1)
                            .addComponent(txtTeacherId)
                            .addComponent(txtDepartment)
                            .addComponent(txtSpecialization))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlTeacherLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlTeacherLayout.setVerticalGroup(
            pnlTeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTeacherLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(pnlTeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlTeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlTeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTeacherId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlTeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlTeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(txtSpecialization, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(pnlTeacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd1)
                    .addComponent(btnList1)
                    .addComponent(btnUpdate1)
                    .addComponent(btnDelete1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        Register.addTab("Teacher", pnlTeacher);

        jLabel10.setText("Username:");

        jLabel11.setText("Password");

        jLabel12.setText("Email:");

        jLabel13.setText("User Type");

        txtUsername.setText("                 ");
        txtUsername.addActionListener(this::txtUsernameActionPerformed);

        txtEmail3.setText("          ");
        txtEmail3.addActionListener(this::txtEmail3ActionPerformed);

        cmbUserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student", "Teacher", " " }));
        cmbUserType.addActionListener(this::cmbUserTypeActionPerformed);

        btnRegister.setText("Register");
        btnRegister.addActionListener(this::btnRegisterActionPerformed);

        pwdPassword.setText("jPasswordField1");
        pwdPassword.addActionListener(this::pwdPasswordActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(134, 134, 134)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsername)
                            .addComponent(pwdPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(txtEmail3)
                            .addComponent(cmbUserType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(btnRegister)))
                .addContainerGap(312, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(pwdPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtEmail3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cmbUserType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(btnRegister)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        Register.addTab("Register", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Register)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Register)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:STUDENT
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtEmail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmail1ActionPerformed
        // TODO add your handling code here:STUDENT
    }//GEN-LAST:event_txtEmail1ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:ES DE STUDENT
         addStudent();
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:ES DE STUDENT
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtStudentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentIdActionPerformed
        // TODO add your handling code here:ES DE STUDENT
    }//GEN-LAST:event_txtStudentIdActionPerformed

    private void txtCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCourseActionPerformed
        // TODO add your handling code here:ES DE STUDENT
    }//GEN-LAST:event_txtCourseActionPerformed

    private void txtName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtName1ActionPerformed
        // TODO add your handling code here:ES DE TEACHER
    }//GEN-LAST:event_txtName1ActionPerformed

    private void txtTeacherIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTeacherIdActionPerformed
        // TODO add your handling code here:ES DE TEACHER
    }//GEN-LAST:event_txtTeacherIdActionPerformed

    private void txtDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartmentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartmentActionPerformed

    private void txtSpecializationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSpecializationActionPerformed
        // TODO add your handling code here:ES DE TEACHER
    }//GEN-LAST:event_txtSpecializationActionPerformed

    private void btnAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd1ActionPerformed
        // TODO add your handling code here:ES DE TEACHER
        addTeacher();
    }//GEN-LAST:event_btnAdd1ActionPerformed

    private void btnList1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnList1ActionPerformed
        // TODO add your handling code here:ES DE TEACHER
         listTeachers();
    }//GEN-LAST:event_btnList1ActionPerformed

    private void btnUpdate1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdate1ActionPerformed
        // TODO add your handling code here: ES DE TEACHER
        updateTeacher();
    }//GEN-LAST:event_btnUpdate1ActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        // TODO add your handling code here:// ES DE TEACHER
          deleteTeacher();
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here://ES DE STUDENT
        updateStudent();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:ES DE REGISTER
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void pwdPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdPasswordActionPerformed
        // TODO add your handling code here:ES DE REGISTER
    }//GEN-LAST:event_pwdPasswordActionPerformed

    private void txtEmail3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmail3ActionPerformed
        // TODO add your handling code here:ES DE REGISTER
    }//GEN-LAST:event_txtEmail3ActionPerformed

    private void cmbUserTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUserTypeActionPerformed
        // TODO add your handling code here:ES DE REGISTER
        
    }//GEN-LAST:event_cmbUserTypeActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:REGISTER
        registerUser();
        
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:DE STUDENT
        deleteStudent();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListActionPerformed
        // TODO add your handling code here:
         listStudents();
    }//GEN-LAST:event_btnListActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // Probar conexión a MongoDB
        try {
            MongoDBConnection.getConnection();
            System.out.println("✅ Conectado a MongoDB");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, """
                                                \u26a0\ufe0f No se pudo conectar a MongoDB.
                                                
                                                Aseg\u00farate de:
                                                1. MongoDB est\u00e1 instalado
                                                2. Ejecuta 'net start MongoDB' como Administrador
                                                3. Luego ejecuta esta aplicaci\u00f3n nuevamente""",
                "Error de Conexión", JOptionPane.ERROR_MESSAGE);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new frmEducativeApp().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Register;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnList;
    private javax.swing.JButton btnList1;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdate1;
    private javax.swing.JComboBox<String> cmbUserType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel pnlStudent;
    private javax.swing.JPanel pnlTeacher;
    private javax.swing.JPasswordField pwdPassword;
    private javax.swing.JTable tblStudents;
    private javax.swing.JTable tblTeachers;
    private javax.swing.JTextField txtCourse;
    private javax.swing.JTextField txtDepartment;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmail1;
    private javax.swing.JTextField txtEmail3;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtName1;
    private javax.swing.JTextField txtSpecialization;
    private javax.swing.JTextField txtStudentId;
    private javax.swing.JTextField txtTeacherId;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}

