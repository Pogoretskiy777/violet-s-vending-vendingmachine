/**
 * This program simulates a product with a given name/brand, cost of producing it, and the price for the product to sell
 * at. The price will always be more than the cost and will always be divisible by the round price.
 * 
 * Honor Code: I have referenced the textbook's topic on throwing IllegalArgumentExceptions. All other work is my own.
 * 
 * @author Joseph Pogoretskiy
 * @version 03/02/2023
 */

public class Product {

    public static final int ROUND_PRICE = 25;
    private String name;
    private int cost;
    private int price;

    /**
     * Construct a Product with the name "Generic" with the cost identical to the round price and price identical to
     * double the cost.
     */
    public Product() {
        this.name = "Generic";
        this.cost = ROUND_PRICE;
        this.price = ROUND_PRICE * 2;
    }

    /**
     * Construct a Product with a given name, cost, and price. The cost must be positive and less than the price, and
     * the price also be positive and must be divisible by the round price.
     * 
     * @param name The name/brand of the product
     * @param cost The cost of producing the product
     * @param price The price to sell the product
     */
    public Product(String name, int cost, int price) {
        if (name == null || cost < 0 || price < 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.cost = cost;
        this.price = price;
        if (this.price <= this.cost) {
            this.price = cost + 1;
        }
        while (!(this.price % 25 == 0)) {
            this.price++;
        }
    }

    /**
     * Get the name of the products.
     * 
     * @return Returns the name of the product.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get the cost of the product.
     * 
     * @return Returns the cost of the product.
     */
    public int getCost() {
        return this.cost;
    }

    /**
     * Get the price of the product.
     * 
     * @return Returns the price of the product.
     */
    public int getPrice() {
        return this.price;
    }

    /**
     * Get a formatted summary of the product's name, cost, and price.
     * 
     * @return Returns a formatted summary of the product
     */
    public String toString() {
        double formattedCost = (double) this.cost / 100;
        double formattedPrice = (double) this.price / 100;
        String formattedString = String.format("Product: %s Cost: %.2f Price: %.2f.", this.name, formattedCost,
                formattedPrice);
        return formattedString;
    }
}