/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.compositepattern;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class Setup {
    public static void main(String args[]) {
        Teller daniel = new Teller("Daniel");
        Clerk javier = new Clerk("Javier");
        Manager luis = new Manager("Luis");
        luis.add(daniel);
        luis.add(javier);

        Teller ian = new Teller("Ian");
        Teller victor = new Teller("Victor");
        Manager andres = new Manager("Andres");
        andres.add(ian);
        andres.add(victor);

        President carlos = President.getPresident("Carlos");
        carlos.add(luis);
        carlos.add(andres);

        Client.employee = carlos;
        Client.doClientTasks();
    }
}