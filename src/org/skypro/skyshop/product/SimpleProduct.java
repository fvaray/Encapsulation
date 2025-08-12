package org.skypro.skyshop.product;
import org.skypro.skyshop.exceptions.OutOfRangeException;

public class SimpleProduct extends Product {
    private final int productCost;
    public SimpleProduct(String ProductName, int productCost ) throws OutOfRangeException {
        super(ProductName);

        if(productCost <= 0){
            throw new OutOfRangeException("Цена продукта не может быть ниже или равна 0!");
        }
        this.productCost = productCost;
    }

    @Override
    public int getPrice(){
        return productCost;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return this.getProductName() + ": " + this.productCost;
    }
}
