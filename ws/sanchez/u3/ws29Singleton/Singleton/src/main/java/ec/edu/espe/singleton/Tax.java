package ec.edu.espe.singleton;

/**
 *
 * @author Joel Sanchez
 */
public class Tax {

    private static Tax instance;
    private float percentage;

    private Tax() {
        percentage = 0.0f;
    }

    public static Tax getInstance() {
        if (instance == null) {
            instance = new Tax();
        }
        return instance;
    }

    public void updateTaxPercentage(float percentage) {
        this.percentage = percentage;
    }

    public float getPercentage() {
        return percentage;
    }

    public float salesTotal(float sale) {
        return sale + (sale * percentage / 100);
    }
}
