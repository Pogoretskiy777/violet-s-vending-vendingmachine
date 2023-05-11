import java.util.ArrayList;

/**
 * This program simulates a slot of a vending machine that can be created and filled with various products, can give a
 * summary of what products are in the slot, and can be bought from and return the next product available.
 * 
 * Honor Code: All work is my own.
 * 
 * @author Joseph Pogoretskiy
 * @version 03/02/2023
 */

public class Slot {

    public static final int SLOT_SIZE = 10;
    private ArrayList<Product> products = new ArrayList<Product>();

    /**
     * Construct an empty slot with no products.
     */
    public Slot() {
        ArrayList<Product> products = new ArrayList<Product>();
        this.products = products;
    }

    /**
     * Construct a slot filled (up to maximum slot size) with the given product.
     * 
     * @param product The given Product to be inserted into the slot.
     */
    public Slot(Product product) {
        ArrayList<Product> products = new ArrayList<Product>();
        for (int i = 0; i < SLOT_SIZE; i++) {
            products.add(product);
        }
        this.products = products;
    }

    /**
     * Load the slot with a given product until it fills the slot and return the number of products it took to fill.
     * 
     * @param product The given product to fill the slot with
     * @return The number of products it took to fill the slot
     */
    public int load(Product product) {
        int numToFill = 0;
        while (this.products.size() != SLOT_SIZE) {
            this.products.add(product);
            numToFill++;
        }
        return numToFill;
    }

    /**
     * Load the slot with a given product a given amount of times that would not exceed the slot size and return the
     * number of products it took to fill the slot.
     * 
     * @param product The given product to be inserted into the slot
     * @param count The amount of the given product to be inserted into the slot
     * @return The number of products it took to fill the slot
     */
    public int load(Product product, int count) {
        int numToFill = 0;
        int slotSize = this.products.size();
        if (count + slotSize <= SLOT_SIZE) {
            while (this.products.size() != slotSize + count) {
                this.products.add(product);
                numToFill++;
            }
        } else {
            while (this.products.size() != SLOT_SIZE) {
                this.products.add(product);
                numToFill++;
            }
        }
        return numToFill;
    }

    /**
     * Get the next product available in the slot.
     * 
     * @return The next avaiable product
     */
    public Product nextProduct() {
        if (this.products.size() == 0 || this.products.get(0) == null) {
            return null;
        } else {
            return this.products.get(0);
        }
    }

    /**
     * Buy the next available product in the slot. This method removes and returns the product bought.
     * 
     * @return The product that was bought
     */
    public Product buyOne() {
        if (this.products.size() == 0 || products.get(0) == null) {
            return null;
        } else {
            Product boughtProduct = this.products.get(0);
            for (int i = 0; i < this.products.size() - 1; i++) {
                this.products.set(i, products.get(i + 1));
            }
            this.products.remove(this.products.size() - 1);
            return boughtProduct;
        }
    }

    /**
     * Get a formatted summary of the amount of products filling the slot and the products themselves.
     * 
     * @return A formatted summary of the slot
     */
    public String toString() {
        String formatted = "SlotCount: " + this.products.size() + " of\n";
        if (this.products.size() > 0) {
            for (int i = 0; i < this.products.size() - 1; i++) {
                formatted += products.get(i).toString() + "\n";
            }
            formatted += products.get(this.products.size() - 1).toString();
        }
        return formatted;
    }

}