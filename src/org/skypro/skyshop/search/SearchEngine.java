package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.Product;

import java.awt.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> searchable = new LinkedList<>();

    public Searchable searchRepeat(String term) throws BestResultNotFound {

        int i = 0;
        int quantity = 0;
        int max = 0;
        int j = 0;

        for (Searchable arr : searchable) {
            int index = 0;
            int indexOfSubstring = arr.getSearchTerm().indexOf(term, index);
            while (indexOfSubstring != -1) {
                quantity++;
                index = indexOfSubstring + term.length();
                indexOfSubstring = arr.getSearchTerm().indexOf(term, index);
            }
            if (quantity > max) {
                max = quantity;
                j = i;
            }
            quantity = 0;
            i++;
        }

        if (max == 0) {
            throw new BestResultNotFound("Для поискового запроса строки " + '"' +
                    term + '"' + " не нашлось ни в одном объекте!");
        }
        return searchable.get(j);
    }

    public void add(Searchable elem) {
        searchable.add(elem);
    }

    public void PrintSearchable()
    {
        System.out.println("Список searchable для поиска:");
        Iterator<Searchable> iterator = searchable.iterator();
        while(iterator.hasNext()) {
            Searchable element = iterator.next();
            System.out.println(element);
        }
    }
}
