package ec.edu.espe.mothersApp.view;

import ec.edu.espe.mothersApp.model.*;
import java.util.Scanner;
import ec.edu.espe.mothersApp.model.ProfileManager;

/**
 * @author Jennyfer Nase, Error 404, @ESPE
 */
public class MothersApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProfileManager manager = new ProfileManager();
        MedicalDataBase db = new MedicalDataBase();

        int option;

        do {

            System.out.println("\n____  MATERNITY HEALTH CARE SYSTEM ____ ");
            System.out.println("1. Register Mother and Baby Profiles");
            System.out.println("2. Calculate Gestation Week");
            System.out.println("3. Validate Pediatric Growth");
            System.out.println("4. Manage Medical Appointment");
            System.out.println("5. Classify Health Risk Level");
            System.out.println("6. Interactive Community Chat for Mothers");
            System.out.println("7. Persist Medical History");
            System.out.println("8. Provide Educational Resource");
            System.out.println("9. Monitor Warning Signs");
            System.out.println("10. Medical History");
            System.out.println("11. Exit");

            System.out.print("Select an option: ");
            option = sc.nextInt();

            switch (option) {

                case 1:
                     manager.createMotherProfile();
                     
                     if (ProfileManager.savedMother != null && ProfileManager.savedBaby != null) {
                        ProfileManager.savedMother.babies.clear(); 
                        ProfileManager.savedMother.babies.add(ProfileManager.savedBaby);
                        
                        db.saveHistory(ProfileManager.savedMother);
                     }
                    break;
                    
                case 2:

                    new GestationCalculator().calculateFromWeek();

                    break;

                case 3:

                    PediatricGrowthValidator.validateGrowth();

                    break;

               case 4:
                sc.nextLine();

                 System.out.print("Enter appointment date: ");
                    String date = sc.nextLine();

                 System.out.print("Enter reminder: ");
                String reminder = sc.nextLine();

                ScheduleAppointment.scheduleAppointment(date, reminder);
                ScheduleAppointment.showAppointments();
                break;


                case 5:

                    new AlarmValidator().classifyRiskLevel();

                    break;

                case 6:

                    new InteractiveChat().startChat();

                    break;

                case 7:

                     sc.nextLine(); 

                    System.out.print("Enter doctor's recommendation: ");
                    String recommendation = sc.nextLine();

                    ScheduleAppointment.saveMedicalHistory(recommendation);
                    break;

                case 8:

                    new CommunityActivity().showEducationalResources();

                    break;

                case 9:

                    new MedicalRecord().monitorWarningSigns();

                    break;

                case 10:

                    db.showHistory();

                    break;

                case 11:
                    System.out.println("Exiting system...");
                    break;

                default:

                    System.out.println("Invalid option.");
            }

        } while (option != 11);
    }

    
    public static void showHistory() {

        if (ProfileManager.savedMother == null ||
            ProfileManager.savedBaby == null) {

            System.out.println("No profile registered.");
            return;
        }

        Mother m = ProfileManager.savedMother;
        Baby b = ProfileManager.savedBaby;

        System.out.println("\n___________________________________");
        System.out.println("         MEDICAL HISTORY");
        System.out.println("___________________________________");

        System.out.println("\nMother:");
        System.out.println(m.firstName + " " + m.lastName);
        System.out.println("ID: " + m.id);
        System.out.println("Birth Date: " + m.birthDate);

        System.out.println("\nBaby:");
        System.out.println(b.firstName + " " + b.lastName);
        System.out.println("Expected Birth Date: " + b.birthDate);
        System.out.println("Appointment: General Control");
        System.out.println("Recommendation: Healthy monitoring");

        System.out.println("Mother Weight: " + m.weight + " kg");
        System.out.println("Mother Height: " + m.height + " cm");

        System.out.println("Baby Weight: " + b.weight + " g");
        System.out.println("Baby Height: " + b.height + " cm");

        System.out.println("___________________________________");
    }
}