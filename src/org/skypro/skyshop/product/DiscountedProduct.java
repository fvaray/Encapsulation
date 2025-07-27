package org.skypro.skyshop.product;

import org.skypro.skyshop.exceptions.IllegalArgumentException;

public class DiscountedProduct extends Product{
    private int baseCost;
    private int discount;

    public DiscountedProduct(String ProductName, int baseCost, int discount)throws IllegalArgumentException {
        super(ProductName);
        if(discount < 0 || discount > 100){
            throw new IllegalArgumentException("Процент должен быть числом в диапазоне от 0 до 100 включительно!");
        }

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
