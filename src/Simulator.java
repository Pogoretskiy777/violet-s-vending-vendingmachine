import java.util.ArrayList;

/**
 * This program simulates a company that has a collection of vending machine and simulates constructing and buying a
 * specified amount of products from each slot in each vending machine and returning the total profit of all vending
 * machines.
 * 
 * @author Joseph Pogoretskiy
 * @version 03/24/2024
 */
public class Simulator {

    private ArrayList<VendingMachine> vmList;

    /**
     * Construct a simulator of the inputed list of vending machines.
     * 
     * @param vmList A list of vending machines
     */
    public Simulator(ArrayList<VendingMachine> vmList) {
        ArrayList<VendingMachine> copiedVMList = new ArrayList<VendingMachine>(vmList);
        this.vmList = copiedVMList;
    }

    /**
     * Add a vending machine to the list of vending machines.
     * 
     * @param vm A vending machine to be added
     */
    public void addVM(VendingMachine vm) {
        this.vmList.add(vm);
    }

    /**
     * Simulate each vending machine being bought a specified amount of product from each of its slot and return the
     * total profit.
     * 
     * @param pCount The amount of products to buy from each slot of each vending machine.
     * @return The total profit of all vending machines after the simulation
     */
    public int simulate(int pCount) {
        for (VendingMachine vm : vmList) {
            for (int i = 0; i < pCount; i++) {
                for (int j = 0; j < vm.getSlotCount(); j++) {
                    vm.buy(j);
                }
            }
        }
        return VendingMachine.getTotalProfit();
    }
}