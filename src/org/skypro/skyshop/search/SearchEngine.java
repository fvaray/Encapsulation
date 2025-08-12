package org.skypro.skyshop.search;
import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;
import java.util.List;

public class SearchEngine {
    //private final Map<String, Searchable> searchable = new HashMap<>();
    private final Set<Searchable> searchable = new LinkedHashSet<>();

    public Set searchRepeat(String term) throws BestResultNotFound {
        int quantity = 0;
        Set searchableList = new TreeSet<>(new ReverseStringComparator());

        for (Searchable arr : searchable) {
            int index = 0;
            int indexOfSubstring = arr.getSearchTerm().indexOf(term, index);
            while (indexOfSubstring != -1) {
                quantity++;
                index = indexOfSubstring + term.length();
                indexOfSubstring = arr.getSearchTerm().indexOf(term, index);
            }
            if (quantity > 0) {
                searchableList.add(arr.getSearchTerm());
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

    public void printSearchable(){
        for (Searchable arr : searchable) {
            System.out.println(arr);
        }
    }

    public static class ReverseStringComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            return s2.length() - s1.length();
        }
    }
}
