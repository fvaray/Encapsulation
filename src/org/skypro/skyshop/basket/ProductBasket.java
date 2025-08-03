package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    public static List<Product> arrProduct = new LinkedList<>();

    public void AddProductToBasket(Product product) {
        if (product == null) {
            System.out.println("Продукт пустой!");
            return;
        }

        arrProduct.add(product);

    }

    public int getBasketCost(){
        int sum = 0;
        Iterator<Product> iterator = arrProduct.iterator();
        while (iterator.hasNext()) {
            Product element = iterator.next();
            sum += element.getPrice();
        }

        return sum;
    }

    public void printBasket() {
        int j = 0, s = 0;
        Iterator<Product> iterator = arrProduct.iterator();
        while (iterator.hasNext()) {
            Product element = iterator.next();
            System.out.println(element);
            if(element.isSpecial()){
                s++;
            }
            j++;
        }

        if (j == 0) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого: " + this.getBasketCost());
            System.out.println("Специальных товаров: " + s);
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
