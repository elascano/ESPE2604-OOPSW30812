
package ec.edu.espe.classdiagram.view;
import ec.edu.espe.classdiagram.model.*;
/**
 *
 * @author Alexander Tipantiza < The_Softwarrios of Espeyour>
 */
public class MainConsole {
    public static void main(String[] args) {
        System.out.println("=======================================================");
        System.out.println("     CLASS DIAGRAM EXECUTION OUTPUT (ALEXANDER.)       ");
        System.out.println("=======================================================\n");

        
        System.out.println("--- 1. Testing Interface (H), Realization (G) and Dependency (J) ---");
        G objectG = new G();
        J objectJ = new J();

        objectG.operationH();         
        objectG.dependOnJ(objectJ);   
        System.out.println();

        
        System.out.println("--- 2. Generalization / Specialization (Inheritance) Hierarchy ---");
        
        B childB = new B("Instance_B_");
        C childC = new C("Instance_C_");
        D childD = new D("Instance_D_");

        
        childB.displayBehavior();
        childC.displayBehavior();
        childD.displayBehavior();
        System.out.println();

        
        System.out.println("--- 3. Association Testing ---");
        childB.addAssociationH(objectG); // B stores a reference to Interface H implemented via G
        System.out.println("  -> Structural Association between Class B and Interface H successfully established.");
        System.out.println();

        
        System.out.println("--- 4. Aggregation (Weak) vs Composition (Strong) ---");
        
        
        E e1 = new E("E-Alpha");
        E e2 = new E("E-Beta");
        E e3 = new E("E-Gamma");

       
        childC.addAggregationE(e1);
        childC.addAggregationE(e2);
        System.out.println("Aggregated contents inside Class C:");
        childC.showAggregatedElements();

        
        childD.addAggregationE(e2);
        childD.addAggregationE(e3);
        
       
        childD.createAndComposeF("Core Memory Unit");
        childD.createAndComposeF("Mathematical Processor F");

        System.out.println("\nDetailed internal architecture inside Class D:");
        childD.showDetails();
        System.out.println("\n=======================================================");
        System.out.println("       UML Simulation Finished Successfully            ");
        System.out.println("=======================================================");
    }
}