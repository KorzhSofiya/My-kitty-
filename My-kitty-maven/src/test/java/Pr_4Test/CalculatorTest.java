package Pr_4Test;

import Pr_4.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    void shouldDivideSuper(){
        Calculator c = new Calculator();
        assertEquals(2,c.divide(4,2));
    }
    @Test
    void shouldReciveError(){
        Calculator c = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> c.divide(3,0));
    }
}
