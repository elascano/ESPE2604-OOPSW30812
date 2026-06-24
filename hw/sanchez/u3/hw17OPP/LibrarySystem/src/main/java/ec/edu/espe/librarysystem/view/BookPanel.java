package ec.edu.espe.librarysystem.view;

import ec.edu.espe.librarysystem.controller.BookController;
import ec.edu.espe.librarysystem.dao.MongoBookDAO;
import ec.edu.espe.librarysystem.model.Book;
import ec.edu.espe.librarysystem.utils.Validator;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class BookPanel extends JPanel {

    private JTextField txtId;
    private JTextField txtTitle;
    private JTextField txtAuthor;

    private JButton btnSave;
    private JButton btnSearch;
    private JButton btnShowAll;
    private JButton btnUpdate;
    private JButton btnDelete;

    private BookController controller;

public BookPanel() {

    controller = new BookController(
            new MongoBookDAO());

    setLayout(new BorderLayout());

    txtId = new JTextField(20);
    txtTitle = new JTextField(20);
    txtAuthor = new JTextField(20);

    btnSave = new JButton("Save");
    btnSearch = new JButton("Search");
    btnShowAll = new JButton("Show All");
    btnUpdate = new JButton("Update");
    btnDelete = new JButton("Delete");

    JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));

    formPanel.add(new JLabel("Id:"));
    formPanel.add(txtId);

    formPanel.add(new JLabel("Title:"));
    formPanel.add(txtTitle);

    formPanel.add(new JLabel("Author:"));
    formPanel.add(txtAuthor);

    JPanel buttonPanel = new JPanel();

    buttonPanel.add(btnSave);
    buttonPanel.add(btnSearch);
    buttonPanel.add(btnUpdate);
    buttonPanel.add(btnDelete);

    JPanel bottomPanel = new JPanel();
    bottomPanel.add(btnShowAll);

    add(formPanel, BorderLayout.NORTH);
    add(buttonPanel, BorderLayout.CENTER);
    add(bottomPanel, BorderLayout.SOUTH);

    btnSave.addActionListener(e -> saveBook());
    btnSearch.addActionListener(e -> searchBook());
    btnShowAll.addActionListener(e -> showBooks());
    btnUpdate.addActionListener(e -> updateBook());
    btnDelete.addActionListener(e -> deleteBook());
}

    private void saveBook() {

        if (Validator.isEmpty(txtId.getText())
                || Validator.isEmpty(txtTitle.getText())
                || Validator.isEmpty(txtAuthor.getText())) {

            JOptionPane.showMessageDialog(
                    this,
                    "Complete all fields.");

            return;
        }

        Book book = new Book(
                txtId.getText(),
                txtTitle.getText(),
                txtAuthor.getText());

        controller.saveBook(book);

        JOptionPane.showMessageDialog(
                this,
                "Book saved.");
    }

    private void searchBook() {

        Book book =
                controller.getBookById(
                        txtId.getText());

        if (book == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Book not found.");
            return;
        }

        txtTitle.setText(book.getTitle());
        txtAuthor.setText(book.getAuthor());
    }

    private void showBooks() {

        List<Book> books =
                controller.getAllBooks();

        if (books.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "No books found.");
            return;
        }

        String message = "";

        for (Book book : books) {
            message +=
                    book.getBookId()
                    + " - "
                    + book.getTitle()
                    + " - "
                    + book.getAuthor()
                    + "\n";
        }

        JOptionPane.showMessageDialog(
                this,
                message);
    }

    private void updateBook() {

        Book book = new Book(
                txtId.getText(),
                txtTitle.getText(),
                txtAuthor.getText());

        controller.updateBook(book);

        JOptionPane.showMessageDialog(
                this,
                "Book updated.");
    }

    private void deleteBook() {

        controller.deleteBook(
                txtId.getText());

        txtId.setText("");
        txtTitle.setText("");
        txtAuthor.setText("");

        JOptionPane.showMessageDialog(
                this,
                "Book deleted.");
    }
}