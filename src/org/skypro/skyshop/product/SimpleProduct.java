package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int productCost;
    public SimpleProduct(String ProductName, int productCost ){
        super(ProductName);
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
