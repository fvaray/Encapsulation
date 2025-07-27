package org.skypro.skyshop.product;
import org.skypro.skyshop.exceptions.IllegalArgumentException;

public class SimpleProduct extends Product {
    private int productCost;
    public SimpleProduct(String ProductName, int productCost ) throws IllegalArgumentException {
        super(ProductName);

        if(productCost <= 0){
            throw new IllegalArgumentException("Цена продукта не может быть ниже или равна 0!");
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
