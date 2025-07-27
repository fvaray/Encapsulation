package org.skypro.skyshop;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.exceptions.OutOfRangeException;

public class App {
    public static void main(String[] args) {

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

        SearchEngine searchEngine = new SearchEngine(5);
        searchEngine.add(articleOne);
        searchEngine.add(articleTwo);
        searchEngine.add(articleThree);
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
    }
}
