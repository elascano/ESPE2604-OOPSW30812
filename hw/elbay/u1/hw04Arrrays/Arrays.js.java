/* author: Didier Elbay */
class Chicken {
    private int id;
    private String name;
    private String color;
    private int age;
    private boolean isMolting;

    public Chicken(int id, String name, String color, int age, boolean isMolting) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.age = age;
        this.isMolting = isMolting;
    }

    @Override
    public String toString() {
        return "Chicken{" + "id=" + id + ", name=" + name + ", color=" + color + 
               ", age=" + age + ", isMolting=" + isMolting + '}';
    }
}

public class ChickenFarmer {
    public static void main(String[] args) {
        System.out.println("--- Chicken Farm Simulator (Java) ---");
        Chicken lucy = new Chicken(1, "Lucy", "Black", 3, true);
        System.out.println(lucy.toString());
    }
}