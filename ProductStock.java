import java.util.ArrayList;

class ProductStock {
    public static void main(String[] args) {
        StockDemo stockDemo = new StockDemo();
        stockDemo.run();
    }
}

class Product {
    public int id;
    public String name;
    public int quantity;

    public Product(int id, String name, int quantity) {
        this.id = setId(id);
        this.name = setName(name);
        this.quantity = setQuantity(quantity);
    }

    public int setId(int id) {
        this.id = id;
        return this.id;
    }

    public String setName(String name) {
        this.name = name;
        return this.name;
    }

    public int setQuantity(int quantity) {
        this.quantity = quantity;
        return this.quantity;
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

    public static void RemoveProduct(ArrayList<Product> products, int ProductId) {
        boolean found = false;
        for (Product productX : products) {
            if (productX.getId() == ProductId) {
                found = true;
                products.remove(productX);
                System.out.println("Product with id: " + ProductId + " has been removed from stock list.");
                break;
            }
        }

        // check if product was found - if it wasn't, output error message
        if (found == false) {
            System.out.println("We have don't have any of the product with id: " + ProductId + " in stock, so can't be removed.");
        }   
    }

    public static void FindProduct(ArrayList<Product> products, int ProductId) {
        boolean found = false;
        for (Product productX : products) {
            if (productX.getId() == ProductId) {
                // set found to true
                found = true;
                // output info
                String name = productX.getName();
                int quantity = productX.getQuantity();
                System.out.println("We have " + quantity + " of product name: " + name + " and Id: " + ProductId);
            }
        }

        // check if product was found - if it wasn't, output error message
        if (found == false) {
            System.out.println("We have none of the product with id: " + ProductId + " in stock.");
        }       
    }
}

class StockDemo {
    public void stockDemo() {
    }

    public static void createProduct(int id, String name, int quantity, ArrayList<Product> productList) {
        // create product and add it to stockList
        Product product = new Product(id, name, quantity);
        StockList.AddProduct(productList, product);

        //int product_id = product.getId();
        //String product_name = product.getName();
        //int product_quantity = product.getQuantity();
    }

    public static void printStock(ArrayList<Product> productList) {
        // return all products and quantities in stock
        System.out.println("Products in stock:");
        for(Product productX : productList) {
            String productName = productX.getName();
            int productQuantity = productX.getQuantity();
            System.out.println(productQuantity + " lots of " + productName + ".");
        }
    }

    public static void searchStock(int id, ArrayList<Product> productList) {
        StockList.FindProduct(productList, id);
    }

    public static void deleteProduct(int id, ArrayList<Product> productList) {
        StockList.RemoveProduct(productList, id);
    }

    public void run() {
        // run the program
        // create the productList
        ArrayList<Product> productList = new ArrayList<Product>();

        // create products
        StockDemo.createProduct(4081, "Mclaren Cap", 300, productList);
        StockDemo.createProduct(1397, "AlphaTauri Hoodie", 40, productList);
        StockDemo.createProduct(2855, "Ferrari Polo", 550, productList);

        // print stock
        StockDemo.printStock(productList);

        // search stock
        StockDemo.searchStock(1397, productList);

        // remove item from stock
        StockDemo.deleteProduct(2855, productList);
    }
}