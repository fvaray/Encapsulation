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
                arrProduct[i] = new Product(product.getProductName(), product.getProductCost());
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    public int getBasketCost(){
        int sum = 0;
        for (Product product : arrProduct) {
            if (product != null) {
                sum += product.getProductCost();
            }
        }
        return sum;
    }

    public void printBasket() {
        int i = 0, j = 0;
        for (; i < arrProduct.length; i++) {
            if (arrProduct[i] != null) {
                System.out.println(arrProduct[i]);
                j++;
            }
        }

        if (j == 0) {
            System.out.println("В корзине пусто");
        } else {
            System.out.println("Итого: " + "<" + this.getBasketCost() + ">");
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
