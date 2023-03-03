import java.util.ArrayList;

class ProductStock {
    public static void main(String[] args) {
        // product constructor
        int id = 4081;
        String name = "McLaren Cap";
        int quantity = 300;
        Product product = new Product(id, name, quantity);
        int product_id = product.getId();
        String product_name = product.getName();
        int product_quantity = product.getQuantity();
        printProduct(product_id, product_name, product_quantity);
    }

    public static void printProduct(int id, String name, int quantity) {
        // output product details
        System.out.println("Product name is: " + name + ", with id: " + id);
        System.out.println("We have " + quantity + " of them.");
    }
}

class Product {
    public int id;
    public String name;
    public int quantity;

    public Product(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}

class StockList {
    public ArrayList<Product> products;

    public static void AddProduct(ArrayList<Product> products, Product product) {
        products.add(product);
    }

    public static void RemoveProduct(ArrayList<Product> products, Product product) {
        products.remove(product);
    }

    public static void FindProduct(ArrayList<Product> products, int ProductId) {
        for (Product productX : products) {
            if (productX.getId() == ProductId) {
                String name = productX.getName();
                int quantity = productX.getQuantity();
                System.out.println("We have " + quantity + " of product name: " + name + " and Id: " + ProductId);
            }
        }
        System.out.println("We have none of the product with id: " + ProductId + " in stock.");       
    }
}

class StockDemo {

}