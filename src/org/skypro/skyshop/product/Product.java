package org.skypro.skyshop.product;

import java.util.Objects;

public class Product
{
    private String ProductName;
    private Integer ProductCost;

    public Product(String ProductName, Integer ProductCost ){
        this.ProductName = ProductName;
        this.ProductCost = ProductCost;
    }

    public String getProductName() {
        return ProductName;
    }

    public Integer getProductCost() {
        return ProductCost;
    }

    @Override
    public String toString() {
        return "<" + ProductName + ">: <" + ProductCost + ">";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(ProductName, product.ProductName) && Objects.equals(ProductCost, product.ProductCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ProductName, ProductCost);
    }
}
