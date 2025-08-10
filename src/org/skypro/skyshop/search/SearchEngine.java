package org.skypro.skyshop.search;
import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;
import java.util.List;

public class SearchEngine {
    //private final Map<String, Searchable> searchable = new HashMap<>();
    private final List<Searchable> searchable = new LinkedList<>();

    public Map<String, Integer> searchRepeat(String term) throws BestResultNotFound {
        int quantity = 0;
        Map<String,Integer> searchableList = new TreeMap<>();

        for (Searchable arr : searchable) {
            int index = 0;
            int indexOfSubstring = arr.getSearchTerm().indexOf(term, index);
            while (indexOfSubstring != -1) {
                quantity++;
                index = indexOfSubstring + term.length();
                indexOfSubstring = arr.getSearchTerm().indexOf(term, index);
            }
            if (quantity > 0) {
                searchableList.put(arr.getSearchTerm(), quantity);
            }
            quantity = 0;
        }

        if (searchableList.isEmpty()) {
            throw new BestResultNotFound("Для поискового запроса строки " + '"' +
                    term + '"' + " не нашлось ни в одном объекте!");
        }
        return searchableList;
    }

    public void add(Searchable elem) {
        searchable.add(elem);
    }
}
