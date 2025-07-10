package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{
    private int baseCost;
    private int discount;

    public DiscountedProduct(String ProductName, int baseCost, int discount){
        super(ProductName);
        this.baseCost = baseCost;
        this.discount = discount;
    }

    @Override
    public int getPrice(){
        return (int)(baseCost * (1.0 - (double) discount/100.0));
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return this.getProductName() + ": " + this.getPrice() +
                "(" + this.discount + "%)";
    }
}
