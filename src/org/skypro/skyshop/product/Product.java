package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.exceptions.OutOfRangeException;

import java.util.Objects;

public abstract class Product implements Searchable
{
    private final String productName;

    public Product(String productName) throws OutOfRangeException {
            if(productName.isBlank()) {
                throw new OutOfRangeException("Название продукта отсутвует!");
            }
            this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public abstract int getPrice();
    public abstract boolean isSpecial();

    @Override
    public String toString() {
        return productName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName);
    }

    @Override
    public String getSearchTerm() {
        return productName;
    }

    @Override
    public String getStringRepresentation() {
        return Searchable.super.getStringRepresentation();
    }
}

