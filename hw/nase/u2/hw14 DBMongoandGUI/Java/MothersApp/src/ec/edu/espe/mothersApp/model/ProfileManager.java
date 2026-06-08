/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mothersApp.model;

import java.util.Scanner;

/**
 *
 * @author Jennyfer Nase, Error 404, @ESPE
 */
 public class ProfileManager {

    private Scanner sc = new Scanner(System.in);

    public static Mother savedMother;
    public static Baby savedBaby;

    public void createMotherProfile() {

        System.out.println("\n ______    MOTHER REGISTRATION ______   ");

        String mFn = readOnlyLetters("First Name: ");
        String mLn = readOnlyLetters("Last Name: ");
        String mBd = readValidDate("Birth Date (YYYY-MM-DD): ");
        String mId = readValidId("ID (max 20 digits): ");

        System.out.print("Mother Weight (kg): ");
        double mWeight = sc.nextDouble();

        System.out.print("Mother Height (cm): ");
        double mHeight = sc.nextDouble();
        sc.nextLine();

        savedMother = new Mother( mFn,mLn,mId,mBd,mWeight,mHeight);
        
        MedicalDataBase db = new MedicalDataBase();
        db.saveHistory(savedMother);

        System.out.println("\n  ______  BABY REGISTRATION ______   ");
        System.out.println("1. Baby Registration");
        System.out.println("2. Newborn Registration");

        System.out.print("Select an option: ");
        int option = sc.nextInt();
        sc.nextLine();

        if (option == 1) {

            System.out.print("Gestation Period (weeks): ");
            int gestation = sc.nextInt();
            sc.nextLine();

            savedBaby = new Baby("Not registered","Not registered","Not registered",0,0,"Pending",false );

            savedBaby.gestationPeriod = gestation;

        } else if (option == 2) {

            String bFn = readOnlyLetters("First Name: ");
            String bLn = readOnlyLetters("Last Name: ");

            System.out.print("Months: ");
            int months = sc.nextInt();
            sc.nextLine();

            System.out.print("Baby ID (optional): ");
            String bId = sc.nextLine();

            if (bId.isEmpty()) {
                bId = "Not registered";
            }

            String bBd = readValidDate("Birth Date (YYYY-MM-DD): ");

            System.out.print("Baby Weight (g): ");
            int bWeight = sc.nextInt();

            System.out.print("Baby Height (cm): ");
            int bHeight = sc.nextInt();
            sc.nextLine();

            savedBaby = new Baby( bFn, bLn, bId, bWeight, bHeight, bBd, false);

            savedBaby.months = months;
        }

        System.out.println("\nProfile registered successfully!");
    }

    private String readOnlyLetters(String msg) {

        String text;

        while (true) {

            System.out.print(msg);
            text = sc.nextLine();

            if (text.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                return text;
            }

            System.out.println("ERROR: Only letters are allowed.");
        }
    }

    private String readValidId(String msg) {

        String id;

        while (true) {

            System.out.print(msg);
            id = sc.nextLine();

            if (id.matches("\\d{1,20}")) {
                return id;
            }

            System.out.println("ERROR: ID must contain a maximum of 20 digits.");
        }
    }

    private String readValidDate(String msg) {

        String date;

        while (true) {

            System.out.print(msg);
            date = sc.nextLine();

            if (date.matches("\\d{4}-\\d{2}-\\d{2}")) {
                return date;
            }

            System.out.println("ERROR: Date format must be YYYY-MM-DD.");
        }
    }
}