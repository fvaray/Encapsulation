package org.skypro.skyshop.product;
import org.skypro.skyshop.exceptions.OutOfRangeException;

public class FixPriceProduct extends Product {
    private static final int FIX_PRICE = 80;

    public FixPriceProduct(String productName) throws OutOfRangeException {
        super(productName);
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    //<имя продукта c фиксированной ценой>: Фиксированная цена <значение константы фиксированной цены>
    @Override
    public String toString() {
        return this.getProductName() + ": Фиксированная цена " + this.getPrice() ;
    }
}
