package org.skypro.skyshop;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Введение в ООП. Инкапсуляция.");

        SimpleProduct prOne = new SimpleProduct("Milk", 100);
        SimpleProduct prTwo = new SimpleProduct("Broad", 50);
        SimpleProduct prThree = new SimpleProduct("Chocolate", 150);
        SimpleProduct prFour = new SimpleProduct("Cucumbers", 200);
        SimpleProduct prFive = new SimpleProduct("Tomatoes", 250);
        SimpleProduct prSix = new SimpleProduct("Onion", 50);

        ProductBasket basket = new ProductBasket();
        basket.AddProductToBasket(prOne);
        basket.AddProductToBasket(prTwo);
        basket.AddProductToBasket(prThree);
        basket.AddProductToBasket(prFour);
        basket.AddProductToBasket(prFive);
        basket.AddProductToBasket(prSix);
        basket.printBasket();

        if (basket.productEqual("Tomatoes")) {
            System.out.println("Такой продукт в корзине есть");
        } else {
            System.out.println("Такой продукт отсутствует в корзине");
        }
        if (basket.productEqual("Potatoes")) {
            System.out.println("Такой продукт в корзине есть");
        } else {
            System.out.println("Такой продукт отсутствует в корзине");
        }

        basket.basketClear();
        basket.printBasket();
        System.out.println("Стоимость пустой корзины: " + basket.getBasketCost());

        if (basket.productEqual("Potatoes")) {
            System.out.println("Такой продукт в корзине есть");
        } else {
            System.out.println("Такой продукт отсутствует в корзине");
        }

        System.out.println("\nООП. Наследование. Абстрактные классы");
        System.out.println("5. Изменение вывода корзины в классе ProductBacket");
        DiscountedProduct prOneDisc = new DiscountedProduct("Peas", 100, 30);
        DiscountedProduct prTwoDisc = new DiscountedProduct("Сorn", 90, 30);
        FixPriceProduct prOneFix = new FixPriceProduct("Orange");
        FixPriceProduct prTwoFix = new FixPriceProduct("Cherry");
        basket.AddProductToBasket(prOne);
        basket.AddProductToBasket(prOneDisc);
        basket.AddProductToBasket(prTwoDisc);
        basket.AddProductToBasket(prOneFix);
        basket.AddProductToBasket(prTwoFix);
        basket.printBasket();

        System.out.println("ООП. Полиморфизм. Интерфейсы.");
        Article articleOne = new Article("Кошки", "Любимые питомцы");
        Article articleTwo = new Article("Собака", "Друг человека");
        Article articleThree = new Article("Макака", "Наши родственники");

        SearchEngine searchEngine = new SearchEngine(5);
        searchEngine.add(prOneDisc);
        searchEngine.add(prOneFix);
        searchEngine.add(articleOne);
        searchEngine.add(articleTwo);
        searchEngine.add(articleThree);

        System.out.println(Arrays.toString(searchEngine.search("ака")));
    }
}
