package tests;

import classes.ProductWithSize;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestProductWithSize {

    static ProductWithSize prodSize;

    @BeforeAll
    static void initialSetup ()
    {
        prodSize = new ProductWithSize("Mouse", 1.23f, "tyrUe231", 32);
    }

    @Test
    void testEquality ()
    {
        ProductWithSize prodExa = new ProductWithSize("Laptop", 3474.5f, "tyrUe231", 32);
        assertEquals(prodSize, prodExa);
    }

    @Test
    void testDifferent ()
    {
        ProductWithSize prodExa = new ProductWithSize("Laptop", 3474.5f, "treyebde231", 32);
        assertNotEquals(prodSize, prodExa);
    }
}
