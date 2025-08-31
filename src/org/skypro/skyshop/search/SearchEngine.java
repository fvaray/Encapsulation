package org.skypro.skyshop.search;
import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> searchable = new HashSet<>();

    public Set<Searchable> searchRepeat(String term) throws BestResultNotFound {
        int quantity = 0;
        //Set <Searchable> searchableList = new TreeSet<Searchable>(new ReverseStringComparator());
        Set<Searchable> searchableList = searchable.stream()
                .filter(s -> s.getSearchTerm().contains(term))
                .collect(Collectors.toCollection(()->new TreeSet<Searchable>(new ReverseStringComparator())));

/*
        for (Searchable arr : searchable) {
            int index = 0;
            int indexOfSubstring = arr.getSearchTerm().indexOf(term, index);
            while (indexOfSubstring != -1) {
                quantity++;
                index = indexOfSubstring + term.length();
                indexOfSubstring = arr.getSearchTerm().indexOf(term, index);
            }
            if (quantity > 0) {
                searchableList.add(arr);
            }
            quantity = 0;
        }
*/
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
}
