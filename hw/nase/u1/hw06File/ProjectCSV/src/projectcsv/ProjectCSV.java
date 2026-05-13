/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */ 
//@author Jennyfer Nase
package projectcsv
        

public class ProjectCSV {
    private String type;
    private String firstName;
    private String lastName;
    private String weight; 
    private String height; 
    private String birthDate; 
    private String age; 
    private String nationalId;
    private String disabilityStatus;


    public ProjectCSV(String firstName, String lastName, String age, String nationalId, String disabilityStatus) {
        this.type = "Mother";
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.nationalId = nationalId;
        this.disabilityStatus = disabilityStatus;
        this.birthDate = birthDate;
    }

    
    public ProjectCSV(String firstName, String lastName, String weight, String height, String birthDate, String nationalId, String disabilityStatus) {
        this.type = "Baby";
        this.firstName = firstName;
        this.lastName = lastName;
        this.weight = weight;
        this.height = height;
        this.birthDate = birthDate;
        this.nationalId = nationalId;
        this.disabilityStatus = disabilityStatus;
    }

    @Override
    public String toString() {
        if (this.type.equals("Baby")) {
            return "BABY -> Name: " + firstName + " " + lastName + " | ID: " + nationalId + 
                   " | Weight: " + weight + "kg | Height: " + height + "cm | Birth Date: " + birthDate + 
                   " | Disability: " + disabilityStatus;
        } else {
            return "MOTHER -> Name: " + firstName + " " + lastName + " | ID: " + nationalId + 
                   " | Age: " + age + " years old | Disability: " + disabilityStatus;
        }
    }

   
    public static void main(String[] args) {
      
        ProjectCSV mother = new ProjectCSV("Fernanda", "Lopez", "28", "1712345678", "No");
        ProjectCSV baby = new ProjectCSV("Nicolas", "Mendez", "3.5", "50", "2024-01-15", "1798765432", "No");
        
        System.out.println("=== PROFILE REGISTRATION SYSTEM ===");
        System.out.println(mother.toString());
        System.out.println(baby.toString());
        System.out.println("===================================");
    }
}