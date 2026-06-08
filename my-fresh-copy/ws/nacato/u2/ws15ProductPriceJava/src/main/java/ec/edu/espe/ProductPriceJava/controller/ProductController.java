package ec.edu.espe.ProductPriceJava.controller;
import ec.edu.espe.ProductPriceJava.model.Customer;
import ec.edu.espe.ProductPriceJava.model.Product;
import ec.edu.espe.ProductPriceJava.model.ProductModel;
import ec.edu.espe.ProductPriceJava.view.ProductPrice;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Angie Nacato, Error 404, @ESPE
 */
public class ProductController {
    private final ProductModel model;
    private final ProductPrice view;
    private final List<Product> shoppingCart;
    private List<Product> catalog;

    public ProductController(ProductModel model, ProductPrice view) {
        this.model = model;
        this.view = view;
        this.shoppingCart = new ArrayList<>();
        
        initController();
    }

    private void initController() {
        this.catalog = model.readCatalog();
        
        String[] options = new String[catalog.size()];
        for (int i = 0; i < catalog.size(); i++) {
            Product p = catalog.get(i);
            options[i] = String.format("%s ($%.2f)", p.getProduct(), p.getPrice());
        }
        view.setCatalogOptions(options);

        view.addAddProductListener(e -> addSelectedProductToCart());
        view.addClearCartListener(e -> clearShoppingCart());
        view.addCheckoutListener(e -> processPurchase());
        view.addExitListener(e -> System.exit(0));
    }

    private void addSelectedProductToCart() {
        int selectedIndex = view.getSelectedProductIndex();
        if (selectedIndex == -1) return;

        Product matchedProduct = catalog.get(selectedIndex);
        double[] values = model.calculateItemValues(matchedProduct.getPrice());
        
        Product cartItem = new Product();
        cartItem.setProduct(matchedProduct.getProduct());
        cartItem.setPrice(matchedProduct.getPrice());
        cartItem.setVat(values[0]);
        cartItem.setTotal(values[1]);

        shoppingCart.add(cartItem);

        view.addRowToTable(new Object[]{
            cartItem.getProduct(),
            String.format("$%.2f", cartItem.getPrice()),
            String.format("$%.2f", cartItem.getVat()),
            String.format("$%.2f", cartItem.getTotal())
        });

        updateTotalsDisplay();
    }

    private void processPurchase() {
        String name = view.getCustomerName();
        String idCard = view.getCustomerId();
        String phone = view.getCustomerPhone();

        if (name.isEmpty() || name.equals("Customer Name") || 
            idCard.isEmpty() || idCard.equals("Customer ID / ID Card") || 
            phone.isEmpty() || phone.equals("Phone Number")) {
            
            JOptionPane.showMessageDialog(view, "Please enter all customer information details before checkout.", "Incomplete Fields", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (shoppingCart.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Your shopping cart is empty. Please add items before checking out.", "Empty Cart", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Customer customer = new Customer(name, idCard, phone);
        double[] totals = model.calculateListTotals(shoppingCart);

        String receiptMessage = String.format(
            "--- INVOICE RECEIPT ---\n\n" +
            "Customer Name: %s\n" +
            "ID / Passport: %s\n" +
            "Phone Number: %s\n" +
            "-----------------------------\n" +
            "Total Items Purchased: %d\n" +
            "Subtotal: $%.2f\n" +
            "VAT (15%%): $%.2f\n" +
            "Grand Total Paid: $%.2f\n\n" +
            "Thank you for your purchase!",
            customer.getName(), customer.getIdCard(), customer.getPhone(),
            shoppingCart.size(), totals[0], totals[1], totals[2]
        );

        JOptionPane.showMessageDialog(view, receiptMessage, "Purchase Successful", JOptionPane.INFORMATION_MESSAGE);
        
        clearShoppingCart();
        view.clearCustomerFields();
    }

    private void clearShoppingCart() {
        shoppingCart.clear();
        view.clearTable();
        updateTotalsDisplay();
    }

    private void updateTotalsDisplay() {
        double[] totals = model.calculateListTotals(shoppingCart);
        
        double subtotalGeneral = totals[0];
        double ivaGeneral = totals[1];
        double totalNetoAPagar = totals[2];
        
        view.updateTotals(subtotalGeneral, ivaGeneral, totalNetoAPagar);
    }
}
