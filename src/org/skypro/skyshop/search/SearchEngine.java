package org.skypro.skyshop.search;

import org.skypro.skyshop.exceptions.BestResultNotFound;

public class SearchEngine {
    private Searchable[] searchable;

    public SearchEngine(int size) {
        this.searchable = new Searchable[size];
    }



    public Searchable searchRepeat(String term) throws BestResultNotFound{

        int i = 0;
        int quantity = 0;
        int max = 0;
        int j = 0;

        for (Searchable arr : searchable) {
            if( arr == null) {
                break;
            }

            int index = 0;
            int indexOfSubstring = arr.getSearchTerm().indexOf(term, index);
            while(indexOfSubstring != -1){
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

        if (max == 0){
            throw new BestResultNotFound("Для поискового запроса строки " + '"' +
                    term + '"' + " не нашлось ни в одном объекте!");
        }
        return searchable[j];
    }

    public void add(Searchable elem){
        for (int i = 0; i < searchable.length; i++) {
            if(searchable[i] == null){
                searchable[i] = elem;
                return;
            }
        }
        System.out.println("Массив переполнен!");
    }

}
