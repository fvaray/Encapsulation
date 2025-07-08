package org.skypro.skyshop.product;

import java.util.Objects;

public abstract class Product
{
    private String ProductName;

    public Product(String ProductName){
        this.ProductName = ProductName;
    }

    public String getProductName() {
        return ProductName;
    }

    public abstract int getPrice();
    public abstract boolean isSpecial();

    @Override
    public String toString() {
        return ProductName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        //return Objects.equals(ProductName, product.ProductName) && Objects.equals(ProductCost, product.ProductCost);
        return Objects.equals(ProductName, product.ProductName);
    }

    @Override
    public int hashCode() {
        //return Objects.hash(ProductName, ProductCost);
        return Objects.hash(ProductName);
    }


}

