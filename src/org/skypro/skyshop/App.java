package org.skypro.skyshop;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.exceptions.OutOfRangeException;

import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) throws OutOfRangeException {

        System.out.println("Исключения в Java");
        try {
            SimpleProduct simpleProductBlank = new SimpleProduct("", 10);
        } catch (OutOfRangeException e) {
            System.out.println(e.toString());
        }
        try {
            SimpleProduct simpleProductMinus = new SimpleProduct("Milk", 0);
        } catch (OutOfRangeException e) {
            System.out.println(e.toString());
        }

        try {
            DiscountedProduct discountedProductZero = new DiscountedProduct("Milk", 100, 120);
        } catch (OutOfRangeException e) {
            System.out.println(e.toString());
        }

        Article articleOne = new Article("Кошки", "Любимые питомцы");
        Article articleTwo = new Article("ака ака ака Собака", "Друг человека");
        Article articleThree = new Article("Макак ака аки", "Наши родственники");
        Article articleFour = new Article("Кошки2", "Любимые питомцы");
        Article articleFive = new Article("Кошки3", "Любимые питомцы");
        Article articleSix = new Article("Кошки4", "Любимые питомцы");

        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(articleOne);
        searchEngine.add(articleTwo);
        searchEngine.add(articleThree);
        searchEngine.add(articleFour);
        searchEngine.add(articleFive);
        searchEngine.add(articleSix);

        String subString = "ака";
        String subStringTwo = "лала";
        try {
            System.out.println("Больше всего вхождений " + '"' + subString + '"' +
                    " имеет объект - " + searchEngine.searchRepeat(subString).toString());
            System.out.println("Больше всего вхождений " + '"' + subString + '"' +
                    " имеет объект - " + searchEngine.searchRepeat(subStringTwo).toString());
        }
        catch (BestResultNotFound e){
            System.out.println(e.toString());
        }

        System.out.println("Java Collections Framework: List");
        System.out.println("Task 1:");

        ProductBasket basket = new ProductBasket();
        SimpleProduct prOne = new SimpleProduct("Milk", 100);
        SimpleProduct prTwo = new SimpleProduct("Broad", 50);
        SimpleProduct prThree = new SimpleProduct("Chocolate", 150);
        SimpleProduct prFour = new SimpleProduct("Milk", 200);
        SimpleProduct prFive = new SimpleProduct("Tomatoes", 250);
        SimpleProduct prSix = new SimpleProduct("Onion", 50);
        DiscountedProduct prOneDisc = new DiscountedProduct("Milk", 100, 30);
        DiscountedProduct prTwoDisc = new DiscountedProduct("Сorn", 90, 30);
        FixPriceProduct prOneFix = new FixPriceProduct("Orange");
        FixPriceProduct prTwoFix = new FixPriceProduct("Milk");

        basket.AddProductToBasket(prOne);
        basket.AddProductToBasket(prTwo);
        basket.AddProductToBasket(prThree);
        basket.AddProductToBasket(prFour);
        basket.AddProductToBasket(prFive);
        basket.AddProductToBasket(prSix);
        basket.AddProductToBasket(prOneDisc);
        basket.AddProductToBasket(prTwoDisc);
        basket.AddProductToBasket(prOneFix);
        basket.AddProductToBasket(prTwoFix);
        basket.printBasket();
        System.out.println("Task 2:");
        System.out.println("Удаленные товары: " + basket.removeProduct("Milk"));
        System.out.println("Удаление несуществующего товара: " + basket.removeProduct("Болт"));
        System.out.println("Продукты, оставшиеся в корзине:");
        basket.printBasket();
        System.out.println("Очистка корзины:");
        basket.basketClear();
        basket.printBasket();

        searchEngine.PrintSearchable();
    }

}
