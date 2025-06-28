package org.skypro.skyshop;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Введение в ООП. Инкапсуляция.");

        Product prOne = new Product("Milk", 100);
        Product prTwo = new Product("Broad", 50);
        Product prThree = new Product("Chocolate", 150);
        Product prFour = new Product("Cucumbers", 200);
        Product prFive = new Product("Tomatoes", 250);
        Product prSix = new Product("Onion", 50);

        ProductBasket basket = new ProductBasket();
        basket.AddProductToBasket(prOne);
        basket.AddProductToBasket(prTwo);
        basket.AddProductToBasket(prThree);
        basket.AddProductToBasket(prFour);
        basket.AddProductToBasket(prFive);
        basket.AddProductToBasket(prSix);
        basket.printBasket();

        if(basket.productEqual("Tomatoes"))
            System.out.println("Такой продукт в корзине есть");
        else
            System.out.println("Такой продукт отсутствует в корзине");

        if(basket.productEqual("Potatoes"))
            System.out.println("Такой продукт в корзине есть");
        else
            System.out.println("Такой продукт отсутствует в корзине");

        basket.basketClear();
        basket.printBasket();
        System.out.println("Стоимость пустой корзины: " + basket.getBasketCost());

        if(basket.productEqual("Potatoes"))
            System.out.println("Такой продукт в корзине есть");
        else
            System.out.println("Такой продукт отсутствует в корзине");
    }

}
