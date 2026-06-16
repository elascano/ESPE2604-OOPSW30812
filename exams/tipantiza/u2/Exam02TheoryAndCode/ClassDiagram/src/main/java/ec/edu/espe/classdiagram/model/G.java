
package ec.edu.espe.classdiagram.model;

/**
 *
 * @author Alexander Tipantiza < The_Softwarrios of Espeyour>
 */
public class G implements H {
    
    @Override
    public void operationH() {
        System.out.println("Class G: Formally implementing Interface H (Realization).");
    }

    public void dependOnJ(J jObj) {
        System.out.println("Class G: Temporarily depending on a J object to work (Dependency)...");
        if (jObj != null) {
            jObj.useJ();
        }
    }
}
