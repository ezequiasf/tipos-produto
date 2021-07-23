package classes;

import java.util.HashMap;

public class ShoppingCart {

    private HashMap<Product, Integer> productList;

    public ShoppingCart ()
    {
        productList = new HashMap<>();
    }

    public HashMap<Product, Integer> getProductList() {
        return productList;
    }

    public ShoppingCart addProduct (Product prod, int qtd)
    {
        if (productList.containsKey(prod)){
            productList.replace(prod, qtd+ productList.get(prod));
        }else{
            productList.put(prod, qtd);
        }
        return this;
    }

    public ShoppingCart removeProduct (Product prod, int qtd)
    {
        if (productList.get(prod)<qtd){
            productList.remove(prod);
        }else{
            productList.replace(prod, productList.get(prod)-qtd);
        }
        return this;
    }

    public double totalPrice ()
    {
        return productList.keySet().stream().mapToDouble(prod ->
                prod.getPrice()*productList.get(prod)
        ).reduce(0, Double::sum);
    }
}
