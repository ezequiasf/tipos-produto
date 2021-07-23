package tests;

import classes.Product;
import classes.ProductWithSize;
import classes.ShoppingCart;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestShoppingCart {

    static ShoppingCart shopCart;
    static Product prod;
    static ProductWithSize prodSize;

    @BeforeAll
    static void initialSetup ()
    {
        shopCart = new ShoppingCart();
        prodSize = new ProductWithSize("Mouse", 1.23f, "tyrUe231", 32);
        prod = new Product("Mouse", 1.23f, "thY214");
    }

    @BeforeEach
    void startShopCart ()
    {
        shopCart.addProduct(prod, 3);
    }

    //In this test, when we add a equal instance of product
    // the shopping cart must sum the old quantity to the new
    @Test
    void addingProd ()
    {
        shopCart.addProduct(prod, 4);
        int qtdTotal = shopCart.getProductList().get(prod);
        assertEquals(7,qtdTotal);
    }

    @Test
    void removingProd ()
    {
        shopCart.removeProduct(prod, 1);
        int qtdTotal = shopCart.getProductList().get(prod);
        assertEquals(2, qtdTotal);
        shopCart.removeProduct(prod, 3);
        assertEquals(0, shopCart.getProductList().size());
    }

    @AfterEach
    void clearShopCart ()
    {
        shopCart.getProductList().clear();
    }
}
