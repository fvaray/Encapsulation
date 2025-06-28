package org.skypro.skyshop.product;

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
        return "<" + ProductName + ">: <" + ProductCost + ">" + '\'';
    }
}
