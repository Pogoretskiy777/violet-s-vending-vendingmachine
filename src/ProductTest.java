import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Tests the Product class.
 * 
 * @author CS159 Instructors
 * @version 03/01/2021
 */
public class ProductTest {

    @Test
    public void testToString() {
        Product p = new Product("M&Ms", 102, 125);
        String expected = "Product: M&Ms Cost: 1.02 Price: 1.25.";
        String actual = p.toString();
        assertEquals(expected, actual);
        
        // Or you could do it like:
        assertEquals("Product: M&Ms Cost: 1.02 Price: 1.25.", p.toString());
    }
    
    @Test
    public void testPrice() {
        Product p;
        
        p = new Product("Candy", 100, 125);
        assertEquals(125, p.getPrice());
        
        p = new Product("Candy", 20, 49);
        assertEquals(50, p.getPrice());
        
        p = new Product("Candy", 51, 51);
        assertEquals(75, p.getPrice());
    }

	@Test
    public void checkForException() {
        try {
            new Product(null, 0, 0); // Check null name
            
            // If it truly throws an exception, it won't run this code
            fail();
        } catch (IllegalArgumentException ex) {
            // Do nothing, this means the test was successful
        }

        try {
            new Product("M&Ms", -1, 0); // Check negative cost
			fail();
		} catch (IllegalArgumentException ex) {
            // Do nothing, this means the test was successful
        }
		
		try {
            new Product("M&Ms", 0, -1); // Check negative price
			fail();
		} catch (IllegalArgumentException ex) {
            // Do nothing, this means the test was successful
        }
	}
	
	@Test
    public void exceptionWithLambda() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Product(null, 0, 0); // Check null name
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Product("M&Ms", -1, 0); // Check negative cost
        });
        
        assertThrows(IllegalArgumentException.class, () -> {
            new Product("M&Ms", 0, -1); // Check negative price
        });
    }

}
