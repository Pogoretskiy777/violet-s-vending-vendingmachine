/**
 * This drink machine simulates a vending machine, but with drinks which add a cooling charge to the operator.
 * 
 * @author Joseph Pogoretskiy
 * @version 03/24/2023
 */

public class DrinkMachine extends VendingMachine {

    public static final int COOLING_CHARGE = 10;

    /**
     * Construct an empty drink machine with the default amount of slots.
     */
    public DrinkMachine() {
        super();
    }

    /**
     * Construct a drink machine with the inputed amount of slots with all slots filled with the inputed product.
     * 
     * @param size The amount of slots in the machine
     * @param product The product to fill the machine with
     */
    public DrinkMachine(int size, Product product) {
        super(size, product);
    }

    /**
     * Buy a drink/product from the specified slot number.
     * 
     * @param slotNum The specified slot number
     * @return Whether the transaction went through or not
     */
    public boolean buy(int slotNum) {
        boolean bought = super.buy(slotNum);
        if (bought) {
            totalProfit -= COOLING_CHARGE;
            machineProfit -= COOLING_CHARGE;
            return true;
        } else {
            return false;
        }
    }
}