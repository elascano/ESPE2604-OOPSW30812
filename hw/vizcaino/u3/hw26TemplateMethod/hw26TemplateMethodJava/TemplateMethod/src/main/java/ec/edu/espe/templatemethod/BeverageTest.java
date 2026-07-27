/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.templatemethod;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class BeverageTest {
    public static void main(String[] args) {
        Tea tea = new Tea();
        Coffee coffee = new Coffee();

        System.out.println("\nMaking tea ...");
        tea.prepareRecipe();

        System.out.println("\nMaking coffee ...");
        coffee.prepareRecipe();
    }
}
