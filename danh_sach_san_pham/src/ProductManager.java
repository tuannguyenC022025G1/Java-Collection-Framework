import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ProductManager {
    private LinkedList<Product> products;

    public ProductManager() {
        products = new LinkedList<>();
    }

    // Add a product
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added: " + product);
    }

    // Edit a product by ID
    public void editProduct(int id, String newName, double newPrice) {
        for (Product product : products) {
            if (product.getId() == id) {
                product.setName(newName);
                product.setPrice(newPrice);
                System.out.println("Product updated: " + product);
                return;
            }
        }
        System.out.println("Product with ID " + id + " not found.");
    }

    // Delete a product by ID
    public void deleteProduct(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                Product removed = products.remove(i);
                System.out.println("Product deleted: " + removed);
                return;
            }
        }
        System.out.println("Product with ID " + id + " not found.");
    }

    // Display all products
    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        System.out.println("Product List:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    // Search for a product by name
    public void searchProductByName(String name) {
        boolean found = false;
        System.out.println("Search results for name '" + name + "':");
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(product);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No products found with name containing '" + name + "'.");
        }
    }

    // Sort products by price in ascending order
    public void sortByPriceAscending() {
        Collections.sort(products, Comparator.comparingDouble(Product::getPrice));
        System.out.println("Products sorted by price (ascending):");
        displayProducts();
    }

    // Sort products by price in descending order
    public void sortByPriceDescending() {
        Collections.sort(products, (p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()));
        System.out.println("Products sorted by price (descending):");
        displayProducts();
    }
}
