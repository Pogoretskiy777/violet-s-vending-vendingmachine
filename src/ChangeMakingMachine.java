/**
 * This program simulates a change making machine with all the ability of a regular vending machine as well as the
 * ability to input cash and receive change back.
 * 
 * Honor Code: All work is my own.
 * 
 * @author Joseph Pogoretskiy
 * @version 03/24/2023
 */

public class ChangeMakingMachine extends VendingMachine {

    /**
     * Construct an empty change making machine with the default amount of slots.
     */
    public ChangeMakingMachine() {
        super();
    }

    /**
     * Construct a change making machine with the inputed amount of slots.
     * 
     * @param size The amount of slots in the machine
     */
    public ChangeMakingMachine(int size) {
        super(size);
    }

    /**
     * Construct a change making machine with the inputed amount of slots with all slots filled with the inputed
     * product.
     * 
     * @param size The amount of slots in the machine
     * @param product The product to fill the machine with
     */
    public ChangeMakingMachine(int size, Product product) {
        super(size, product);
    }

    /**
     * Buy a product from the machine with cash and, if applicable, return the change of the cash.
     * 
     * @param slotNum The specified slot number
     * @param quarters Inputed quarters
     * @param dollars Inputed dollars
     * @return The change of the transaction, or -1 if there is not enough cash to buy the product.
     */
    public int buy(int slotNum, int quarters, int dollars) {
        int payment = ((dollars * 100) + (quarters * 25));
        if (quarters < 0 || dollars < 0) {
            throw new IllegalArgumentException("Invalid money input.");
        } else if (slotNum < 0 || slotNum > this.getSlotCount() - 1) {
            throw new IllegalArgumentException("Slot number out of bounds.");
        } else if (this.nextProduct(slotNum).getPrice() <= payment) {
            super.buy(slotNum);
            int change = payment - this.nextProduct(slotNum).getPrice();
            return change;
        } else {
            return -1;
        }
    }
}