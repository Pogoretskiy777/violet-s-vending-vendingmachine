import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Slot class.
 * 
 * Honor Code: All work is my own.
 * 
 * @author Joseph Pogoretskiy
 * @version 03/02/2023
 */

public class SlotTest {

    private Product defaultProduct = new Product();
    private Product customProduct = new Product("Snickers", 20, 40);

    /**
     * Unit tests that test the toString() method for both types of constructors. This also technically test the
     * constructors themselves.
     */
    @Test
    public void testToString() {
        Slot slot1 = new Slot(defaultProduct);
        assertEquals(
                "SlotCount: 10 of\n" + "Product: Generic Cost: 0.25 Price: 0.50.\n"
                        + "Product: Generic Cost: 0.25 Price: 0.50.\n" + "Product: Generic Cost: 0.25 Price: 0.50.\n"
                        + "Product: Generic Cost: 0.25 Price: 0.50.\n" + "Product: Generic Cost: 0.25 Price: 0.50.\n"
                        + "Product: Generic Cost: 0.25 Price: 0.50.\n" + "Product: Generic Cost: 0.25 Price: 0.50.\n"
                        + "Product: Generic Cost: 0.25 Price: 0.50.\n" + "Product: Generic Cost: 0.25 Price: 0.50.\n"
                        + "Product: Generic Cost: 0.25 Price: 0.50.",
                slot1.toString(), "Generic slot formatted string.");

        Slot slot2 = new Slot(customProduct);
        assertEquals(
                "SlotCount: 10 of\n" + "Product: Snickers Cost: 0.20 Price: 0.50.\n"
                        + "Product: Snickers Cost: 0.20 Price: 0.50.\n" + "Product: Snickers Cost: 0.20 Price: 0.50.\n"
                        + "Product: Snickers Cost: 0.20 Price: 0.50.\n" + "Product: Snickers Cost: 0.20 Price: 0.50.\n"
                        + "Product: Snickers Cost: 0.20 Price: 0.50.\n" + "Product: Snickers Cost: 0.20 Price: 0.50.\n"
                        + "Product: Snickers Cost: 0.20 Price: 0.50.\n" + "Product: Snickers Cost: 0.20 Price: 0.50.\n"
                        + "Product: Snickers Cost: 0.20 Price: 0.50.",
                slot2.toString(), "Custom slot formatted string.");
        Slot slot3 = new Slot();
        assertEquals("SlotCount: 0 of\n", slot3.toString(), "Empty slot formatted string.");
    }

    /**
     * Unit tests for both load() methods. This will also test the default Slot() constructor.
     */
    @Test
    public void testLoad() {
        Slot slot1 = new Slot();
        assertEquals(10, slot1.load(defaultProduct));

        Slot slot2 = new Slot();
        assertEquals(5, slot2.load(defaultProduct, 5));

        Slot slot3 = new Slot();
        assertEquals(10, slot3.load(customProduct, 13));

        Slot slot4 = new Slot(defaultProduct);
        slot4.buyOne();
        slot4.buyOne();
        assertEquals(2, slot4.load(defaultProduct, 4));
    }

    /**
     * Unit tests for the nextProduct() method.
     */
    @Test
    public void testNextProduct() {

        // Test null and empty products
        Slot slot1 = new Slot();
        assertEquals(null, slot1.nextProduct(), "No product to be next to");
        slot1.load(null, 1);
        assertEquals(null, slot1.nextProduct(), "Null product could not be next.");

        Slot slot2 = new Slot();
        Slot slot3 = new Slot();
        slot2.load(defaultProduct, 1);
        slot3.load(customProduct, 1);
        assertEquals(defaultProduct, slot2.nextProduct(), "Next product of a slot");
        assertEquals(customProduct, slot3.nextProduct(), "Next product of a slot");

    }

    /**
     * Unit tests for the buyOne() method.
     */
    @Test
    public void testBuyOne() {

        // Test buying a default product
        Slot slot1 = new Slot(defaultProduct);
        assertEquals(defaultProduct, slot1.buyOne(), "Bought one product");

        // Test buying products one after another
        Slot slot2 = new Slot();
        slot2.load(customProduct, 1);
        slot2.load(defaultProduct, 1);
        assertEquals(customProduct, slot2.buyOne(), "Bought a product");
        assertEquals(defaultProduct, slot2.buyOne(), "Bought another different product");

        // Test buying nothing or null products
        assertEquals(null, slot2.buyOne(), "Could not buy from an empty slot.");
        slot2.load(null, 1);
        assertEquals(null, slot2.buyOne(), "Could not buy null.");
    }
}