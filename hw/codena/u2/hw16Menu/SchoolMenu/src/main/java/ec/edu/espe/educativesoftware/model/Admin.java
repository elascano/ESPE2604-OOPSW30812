package ec.edu.espe.educativesoftware.model;

/**
 *
 * @author Daniel Codena, CodeBreakers, @ESPE
 */
public class Admin extends User {

    public Admin() {
    }

    public Admin(String id, String name, String email, String password){
        super(id, name, email, password, Role.ADMIN);
    }
    
}
