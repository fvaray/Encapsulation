package org.skypro.skyshop;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.ReverseStringComparator;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.exceptions.OutOfRangeException;

import java.util.Set;
import java.util.TreeSet;


public class App {
    public static void main(String[] args) {

        System.out.println("Java Collections Framework: List");
        System.out.println("Task 1:");
        ProductBasket basket = new ProductBasket();
        FixPriceProduct prTwoFix = null;
        try {
            SimpleProduct prOne = new SimpleProduct("Milk", 100);
            SimpleProduct prTwo = new SimpleProduct("Broad", 50);
            SimpleProduct prThree = new SimpleProduct("Milk", 150);
            SimpleProduct prFour = new SimpleProduct("Milk", 200);
            SimpleProduct prFive = new SimpleProduct("Tomatoes", 250);
            SimpleProduct prSix = new SimpleProduct("Onion", 50);
            DiscountedProduct prOneDisc = new DiscountedProduct("Milk", 100, 30);
            DiscountedProduct prTwoDisc = new DiscountedProduct("Сorn", 90, 30);
            FixPriceProduct prOneFix = new FixPriceProduct("Orange");
            prTwoFix = new FixPriceProduct("Milk");
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
        } catch (OutOfRangeException e) {
            System.out.println(e.toString());
        }

        System.out.println("Удаленные товары: " + basket.removeProduct("Milk"));
        System.out.println("Удаление несуществующего товара: " + basket.removeProduct("Болт"));
        System.out.println("Продукты, оставшиеся в корзине:");
        basket.printBasket();
        System.out.println("Очистка корзины:");
        basket.basketClear();
        basket.printBasket();

        Article articleOne = new Article("ара ара", "Ред");
        Article articleTwo = new Article("аракул арас", "Друг");
        Article articleThree = new Article("Мара арка арамей", "Наши родственники");
        Article articleFour = new Article("арама араул аратович арабон", "Любимые питомцы");
        Article articleFive = new Article("аракул арап", "Царь джунглей");
        Article articleSix = new Article("арал", "Зоркий глаз");

        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(articleOne);
        searchEngine.add(articleTwo);
        searchEngine.add(articleThree);
        searchEngine.add(articleFour);
        searchEngine.add(articleFive);
        searchEngine.add(articleSix);
        searchEngine.add(prTwoFix);
        searchEngine.printSearchable();

        System.out.println("Task 2:");
        String subString = "ара";
        String subStringTwo = "лала";
        try {
            System.out.println("Список с вхождением  " + '"' + subString + '"' +
                    " имеют строки - " + searchEngine.searchRepeat(subString));
            System.out.println("Список с вхождением  " + '"' + subString + '"' +
                    " имеет объект - " + searchEngine.searchRepeat(subStringTwo));
        } catch (BestResultNotFound e) {
            System.out.println(e.toString());
        }
        //searchEngine.PrintSearchable();
        Set<String> tree = new TreeSet<>(new ReverseStringComparator());
        // Добавляем в него строки в случайном порядке
        tree.add("ab");
        tree.add("ac");
        tree.add("ad");
        tree.add("aea");
        System.out.println(tree);

    }


}
