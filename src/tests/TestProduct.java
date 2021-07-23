package tests;

import classes.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class TestProduct {

    static Product objProd;

    @BeforeAll
    static void initialSetup ()
    {
        objProd = new Product("Mouse", 1.23f, "thY214");
    }

    @Test
    void testName ()
    {
        assertEquals("Product's name: Mouse", objProd.getName());
    }

    @ParameterizedTest
    @ValueSource(floats = {0,1.5f})
     void testError (float params)
    {
        assertDoesNotThrow(()->{
            objProd.setPrice(params);
        });
    }

    @Test
    void testThrow ()
    {
        assertThrows(IllegalArgumentException.class, ()->{
            objProd.setPrice(-3.2f);
        });
    }

    @Test
    void testEquality ()
    {
        //Products with same id, have to be equals;
        Product prodExa = new Product("Laptop", 3765f,"thY214");
        assertEquals(objProd, prodExa);
    }

    @Test
    void testDifferent ()
    {
        Product prodExa = new Product("Laptop", 3765f,"fDgHf347");
        assertNotEquals(objProd, prodExa);
    }

}
