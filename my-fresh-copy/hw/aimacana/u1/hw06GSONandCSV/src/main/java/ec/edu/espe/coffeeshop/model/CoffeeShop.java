package ec.edu.espe.coffeeshop.model;

import java.util.ArrayList;
import java.util.List;

public class CoffeeShop {
    private String name;
    private String address;
    private List<Order> orders;

    public CoffeeShop(String name, String address) {
        this.name = name;
        this.address = address;
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
