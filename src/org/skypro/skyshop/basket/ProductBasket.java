package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final static Product[] arrProduct = new Product[5];

    public void AddProductToBasket(Product product){
        if(product == null) System.out.println("Продукт пустой!");

        for (int i = 0; i < arrProduct.length; i++) {
            if(arrProduct[i] == null) {
                arrProduct[i] = new Product(product.getProductName(), product.getProductCost());
                break;
            }
            if (i == arrProduct.length -1) System.out.println("Корзина полна!");
        }
    }

    public Integer getBasketCost(){
        int sum = 0;
        for (int i = 0; i < arrProduct.length; i++) {
            if(arrProduct[i] == null) {
                break;
            }
            sum+= arrProduct[i].getProductCost();
        }
        return sum;
    }

public void printBasket(){
    int i = 0;
        while (arrProduct[i] != null || i >= arrProduct.length - 1) {
            System.out.println(arrProduct[i]);
            i++;
    }

    if (i == 0) System.out.println("в корзине пусто");
    else
        System.out.println("Итого: " + "<" + this.getBasketCost() + ">");
}

}
