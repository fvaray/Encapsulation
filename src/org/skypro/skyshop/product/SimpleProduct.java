package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int ProductCost;
    public SimpleProduct(String ProductName, int ProductCost ){
        super(ProductName);
        this.ProductCost = ProductCost;
    }

    @Override
    public int getPrice(){
        return ProductCost;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return this.getProductName() + ": " + this.ProductCost;
    }
}
