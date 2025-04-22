public class ProductManagerLinkedList {
    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        // Test functionalities
        manager.addProduct(new Product(1, "Laptop", 999.99));
        manager.addProduct(new Product(2, "Phone", 499.99));
        manager.addProduct(new Product(3, "Tablet", 299.99));

        manager.displayProducts();

        manager.editProduct(2, "Smartphone", 599.99);
        manager.displayProducts();

        manager.deleteProduct(3);
        manager.displayProducts();

        manager.searchProductByName("top");

        manager.sortByPriceAscending();
        manager.sortByPriceDescending();
    }
}