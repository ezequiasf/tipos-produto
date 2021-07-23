package classes;

import java.util.Objects;

public class ProductWithSize extends Product{

    private int size;

    public ProductWithSize (String name, float price, String id, int size)
    {
        super (name, price, id);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //Product with same id have the same sizes to be equals!
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProductWithSize that = (ProductWithSize) o;
        return size == that.size;
    }

    //Generate a hashcode with a reference of id and size;
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size);
    }
}
