/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.templatemethod;

/**
 *
 * @author Angie Ñacato, Error 404, @ESPE
 */
public class BeverageTest {

    public static void main(String[] args) {
        
        Tea tea = new Tea();
        Coffee coffee = new Coffee();
        
        System.out.println("\n---Making tea...---");
        tea.prepareRecipe();
        
        System.out.println("\n---Making coffee...---");
        coffee.prepareRecipe();
    }
}
