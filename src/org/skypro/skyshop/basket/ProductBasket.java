package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private static List<Product> arrProduct = new LinkedList<>();

    public void AddProductToBasket(Product product) {
        if (product == null) {
            System.out.println("Продукт пустой!");
            return;
        }

        arrProduct.add(product);

    }

    public int getBasketCost(){
        int sum = 0;
        for (Product element : arrProduct)
        {
            sum+= element.getPrice();
        }
        return sum;
    }

    public void printBasket() {
        int isBasketNotEmpty = 0, numSpecialProducts = 0;

        for (Product element: arrProduct)
        {
            System.out.println(element);
            if (element.isSpecial()){
                numSpecialProducts++;
            }
            isBasketNotEmpty++;
        }

        if (isBasketNotEmpty == 0) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого: " + this.getBasketCost());
            System.out.println("Специальных товаров: " + numSpecialProducts);
        }
    }

    public boolean productEqual(String productName) {
        for (Product product : arrProduct) {
            if(product != null){
                if (productName.equals(product.getProductName())){
                    return true;
                }
            }
        }
        return false;
    }

    public void basketClear(){
        arrProduct.removeAll(arrProduct);
    }

    public List<Product> removeProduct(String name){
        List<Product> listRemovedProducts = new LinkedList<>();
        Iterator<Product> iterator = arrProduct.iterator();

        while (iterator.hasNext()) {
            Product element = iterator.next();
            if(element.getProductName().equals(name)){
                iterator.remove();
                listRemovedProducts.add(element);
            }
        }

        return listRemovedProducts;
    }
}
