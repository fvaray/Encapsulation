package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final static Product[] arrProduct = new Product[5];

    public void AddProductToBasket(Product product) {
        if (product == null) {
            System.out.println("Продукт пустой!");
        }

        for (int i = 0; i < arrProduct.length; i++) {
            if (arrProduct[i] == null) {
                arrProduct[i] = product;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    public int getBasketCost(){
        int sum = 0;
        for (Product product : arrProduct) {
            if (product != null) {
                sum += product.getPrice();
            }
        }
        return sum;
    }

    public void printBasket() {
        int i = 0, j = 0, s = 0;
        for (; i < arrProduct.length; i++) {
            if (arrProduct[i] != null) {
                System.out.println(arrProduct[i]);
                j++;
                if(arrProduct[i].isSpecial()){
                    s++;
                }
            }
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
        for (int i = 0; i < arrProduct.length; i++) {
            arrProduct[i] = null;
        }
    }
}
