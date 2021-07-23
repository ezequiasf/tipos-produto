package classes;

import java.util.Objects;

public class Product {

    private final String name;
    private float price;
    private final String id;

    public Product (String name, float price, String id)
    {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public String getName() {
        return String.format("Product's name: %s",name);
    }

    public float getPrice() {
        return price;
    }

    public Product setPrice(float price) {
        if (price<0.0f){
            throw new IllegalArgumentException("Price cannot be less than zero!");
        }
        this.price = price;
        return this;
    }

    public String getId() {
        return id;
    }

    //Overriting equals and hashcode methods;
    //Two products must have the same id to be equals;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
