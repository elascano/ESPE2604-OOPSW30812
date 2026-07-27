
package ec.edu.espe.librarysystem.controller;
import ec.edu.espe.librarysystem.model.Loan;
import ec.edu.espe.librarysystem.model.interfaces.IManageable;
import ec.edu.espe.librarysystem.utils.MongoDBConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */

public class LoanController implements IManageable<Loan> {
    private List<Loan> loans;
    private final MongoDBConnection dbConnection;
    private static final Logger logger = LoggerFactory.getLogger(LoanController.class);

    public LoanController() {
        this.loans = new ArrayList<>();
        this.dbConnection = MongoDBConnection.getInstance();
        loadLoans();
    }

    @Override
    public void add(Loan loan) {
        loans.add(loan);
        dbConnection.insertDocument(MongoDBConnection.LOANS_COLLECTION, loan);
        logger.info("Loan added: {}", loan.getId());
    }

    @Override
    public void remove(String id) {
        loans.removeIf(loan -> loan.getId().equals(id));
        dbConnection.deleteDocument(MongoDBConnection.LOANS_COLLECTION, id);
        logger.info("Loan removed with ID: {}", id);
    }

    @Override
    public Loan find(String id) {
        return loans.stream()
                .filter(loan -> loan.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Loan> findAll() {
        return new ArrayList<>(loans);
    }

    @Override
    public void update(Loan loan) {
        for (int i = 0; i < loans.size(); i++) {
            if (loans.get(i).getId().equals(loan.getId())) {
                loans.set(i, loan);
                dbConnection.updateDocument(MongoDBConnection.LOANS_COLLECTION, loan.getId(), loan);
                break;
            }
        }
    }

    public List<Loan> findActiveLoans() {
        return loans.stream()
                .filter(loan -> "ACTIVE".equals(loan.getStatus()))
                .toList();
    }

    public List<Loan> findLoansByUser(String userId) {
        return loans.stream()
                .filter(loan -> loan.getUserId().equals(userId))
                .toList();
    }

    public List<Loan> findOverdueLoans() {
        return loans.stream()
                .filter(Loan::isOverdue)
                .toList();
    }

    private void loadLoans() {
        List<Loan> loansFromDB = dbConnection.findAllDocuments(
            MongoDBConnection.LOANS_COLLECTION, 
            Loan.class
        );
        if (!loansFromDB.isEmpty()) {
            this.loans = loansFromDB;
            logger.info("Loaded {} loans from database", loans.size());
        }
    }
}
