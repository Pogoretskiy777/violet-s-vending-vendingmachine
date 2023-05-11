/**
 * This program simulates a vending machine with custom slots and products. The user can load the slots up as they want
 * and also simulate buying products and the profits from each machine.
 * 
 * Honor Code: All work is my own.
 * 
 * @author Joseph Pogoretskiy
 * @version 03/24/2023
 */

public class VendingMachine {
    public static final int DEFAULT_SIZE = 15;
    protected static int totalProfit = 0;
    protected int machineProfit = 0;
    private Slot[] slots;

    /**
     * Construct an empty vending machine with the default size of slots.
     */
    public VendingMachine() {
        Slot[] slots = new Slot[DEFAULT_SIZE];
        for (int i = 0; i < slots.length; i++) {
            slots[i] = new Slot();
        }
        this.slots = slots;
    }

    /**
     * Construct an empty vending machine with the inputed amount of slots.
     * 
     * @param size The amount of slots of the vending machine
     */
    public VendingMachine(int size) {
        Slot[] slots = new Slot[size];
        for (int i = 0; i < slots.length; i++) {
            slots[i] = new Slot();
        }
        this.slots = slots;
    }

    /**
     * Construct a vending machine with the inputed amount of slots with all slots filled with the inputed product.
     * 
     * @param size The amount of slots of the vending machine
     * @param product The product for the slots to be filled with
     */
    public VendingMachine(int size, Product product) {
        Slot[] slots = new Slot[size];
        if (size > 0) {
            for (int i = 0; i < slots.length; i++) {
                slots[i] = new Slot(product);
            }
            totalProfit -= product.getCost() * size * Slot.SLOT_SIZE;
            machineProfit -= product.getCost() * size * Slot.SLOT_SIZE;
        }
        this.slots = slots;
    }

    /**
     * Load each slot with the default product in each vending machine.
     */
    public void load() {
        Product generic = new Product();
        for (int i = 0; i < this.slots.length; i++) {
            int numFilled = slots[i].load(generic);
            totalProfit -= generic.getCost() * numFilled;
            machineProfit -= generic.getCost() * numFilled;
        }

    }

    /**
     * Load the specified slot with an inputed count of a product.
     * 
     * @param slotNum Index of slot
     * @param count How many products to use
     * @param product The product to put in
     */
    public void load(int slotNum, int count, Product product) {
        if (slotNum < 0 || slotNum > this.getSlotCount() - 1) {
            throw new IllegalArgumentException("Slot number is out of bounds.");
        } else if (count <= 0) {
            throw new IllegalArgumentException("Count can not be equal or less than 0.");
        } else if (product == null) {
            throw new IllegalArgumentException("Product is null.");
        } else {
            int numFilled = this.slots[slotNum].load(product, count);
            totalProfit -= product.getCost() * numFilled;
            machineProfit -= product.getCost() * numFilled;
        }

    }

    /**
     * Get the next product available in the slot.
     * 
     * @param slotNum Index of slot to check for next product
     * @return Return the next product
     */
    public Product nextProduct(int slotNum) {
        if (slotNum < 0 || slotNum > this.getSlotCount() - 1) {
            throw new IllegalArgumentException("Slot number out of bounds.");
        } else {
            return this.slots[slotNum].nextProduct();
        }
    }

    /**
     * Buy a product from the specified slot number and make adjustments to the profits.
     * 
     * @param slotNum Index of slot to buy from
     * @return Whether the transaction went through or not
     */
    public boolean buy(int slotNum) {
        if (slotNum < 0 || slotNum > this.getSlotCount() - 1) {
            throw new IllegalArgumentException("Slot number out of bounds.");
        } else if (this.slots[slotNum].nextProduct() == null) {
            return false;
        } else {
            Product boughtProduct = this.slots[slotNum].buyOne();
            totalProfit += boughtProduct.getPrice();
            machineProfit += boughtProduct.getPrice();
            return true;
        }
    }

    /**
     * Get the amount of slots in the vending machine.
     * 
     * @return Return the number of slots
     */
    public int getSlotCount() {
        return this.slots.length;
    }

    /**
     * Get the total profit, or profit of all vending machines.
     * 
     * @return Return the total profit
     */
    public static int getTotalProfit() {
        return totalProfit;
    }

    /**
     * Reset the total profit to zero.
     */
    public static void resetTotalProfit() {
        totalProfit = 0;
    }

    /**
     * Get the machine profit.
     * 
     * @return Return the machine profit
     */
    public int getMachineProfit() {
        return this.machineProfit;
    }

    /**
     * Return a formatted summary of the vending machine which includes the product, price, cost, and profits.
     * 
     * @return Return a formatted string
     */
    public String toString() {
        double totalProfit = (double) VendingMachine.getTotalProfit() / 100;
        double machineProfit = (double) this.getMachineProfit() / 100;
        String formattedTotalProfit = String.format("%.2f", totalProfit);
        String formattedMachineProfit = String.format("%.2f", machineProfit);
        String formatted = "Vending Machine";
        if (this.getSlotCount() > 0) {
            for (int i = 0; i < this.slots.length; i++) {
                formatted += "\n" + this.slots[i].toString();
            }
        }
        formatted += "\nTotal Profit: " + formattedTotalProfit + " Machine Profit: " + formattedMachineProfit + ".";
        return formatted;
    }
}