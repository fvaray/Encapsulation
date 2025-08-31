package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private static final Map<String, List<Product>> arrProduct = new HashMap<>();

    public void AddProductToBasket(Product product) {
        if (product == null) {
            System.out.println("Продукт пустой!");
            return;
        }

        if(arrProduct.containsKey(product.getProductName())){
            for (Map.Entry<String, List<Product>> entry : arrProduct.entrySet()) {
                if (entry.getKey().equals(product.getProductName())) {
                    entry.getValue().add(product);
                }
            }
        }
        else
        {
            List<Product> listProducts = new LinkedList<>();
            listProducts.add(product);
            arrProduct.put(product.getProductName(),listProducts);
        }
    }

    public int getBasketCost(){
        int sum = 0;
  /*       for (Map.Entry<String, List<Product>> entry : arrProduct.entrySet()) {
             for(Product element : entry.getValue())
             {
                 sum+=element.getPrice();
             }
         }
*/
        sum = arrProduct.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .mapToInt(Product::getPrice)
                .sum();

        return sum;

    }

    public void printBasket() {
        int isBasketNotEmpty = 0, numSpecialProducts = 0;

        for (Map.Entry<String, List<Product>> entry : arrProduct.entrySet()) {
            for(Product element : entry.getValue())
            {
                System.out.println(element);
                if (element.isSpecial()){
                    numSpecialProducts++;
                }
                isBasketNotEmpty++;
            }
        }

        if (isBasketNotEmpty == 0) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого: " + this.getBasketCost());
            System.out.println("Специальных товаров: " + numSpecialProducts);
        }
    }

    public boolean productEqual(String productName) {
    /*    for (Product product : arrProduct.values()) {
            if(product != null){
                if (productName.equals(product.getProductName())){
                    return true;
                }
            }
        }*/
        return false;
    }

    public void basketClear(){
        arrProduct.clear();
    }

    public List<Product> removeProduct(String name){
        List<Product> listRemovedProducts = new LinkedList<>();

        Iterator <Map.Entry<String,List<Product>>> iterator = arrProduct.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<Product>> entry = iterator.next();
            if(entry.getKey().equals(name)){
                listRemovedProducts.addAll(entry.getValue());
                iterator.remove();
            }
        }

        return listRemovedProducts;
    }
}
