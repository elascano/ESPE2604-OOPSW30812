/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.controller;
import ec.edu.espe.model.CellPhone;
import java.util.ArrayList; 
/**
 *
 * @author Cristian
 */
public class PhoneController {
    private ArrayList<CellPhone> phones = new ArrayList<>();

    public void registerPhone(CellPhone phone) {

        phones.add(phone);

        System.out.println(
                "\nPhone registered.");
    }

    public ArrayList<CellPhone> getPhones() {
        return phones;
    }
}
