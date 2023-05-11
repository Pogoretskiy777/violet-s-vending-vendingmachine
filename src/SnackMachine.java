import java.util.ArrayList;

/**
 * This program simulates a snack machine that builds a change making machine and fills the vending machine up based off
 * of the inputed product list and its size.
 * 
 * Honor Code: All work is my own.
 * 
 * @author Joseph Pogoretskiy
 * @version 03/24/2023
 */
public class SnackMachine extends ChangeMakingMachine {

    private ArrayList<Product> productList;

    /**
     * Construct a snack machine with each slot filled with the product correlating to the product list.
     * 
     * @param pList The list of products
     */
    public SnackMachine(ArrayList<Product> pList) {
        super(pList.size());
        ArrayList<Product> copiedPList = new ArrayList<Product>(pList);
        for (int i = 0; i < this.getSlotCount(); i++) {
            this.load(i, 10, copiedPList.get(i));
        }
        this.productList = copiedPList;
    }

    /**
     * Load each slot of the snack machine full of the appropriate product.
     */
    public void load() {
        for (int i = 0; i < this.productList.size(); i++) {
            this.load(i, 100, this.productList.get(i));
        }
    }
}