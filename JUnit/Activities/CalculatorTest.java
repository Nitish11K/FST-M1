package demos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CalculatorTest {
	private Calculator calculator;
	 
    @BeforeEach
    public void setUp() throws Exception {
        calculator = new Calculator();
    }
    @Test
    @DisplayName("Simple multiplication should work")
    public void testMultiply() {
        assertEquals(20, calculator.multiply(4, 5));
        // assertNotEquals(20, calculator.multiply(4, 5));
    }

}
