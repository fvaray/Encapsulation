package org.skypro.skyshop.product;

public class SearchEngine {
    private Searchable[] searchable;

    public SearchEngine(int size) {
        this.searchable = new Searchable[size];
    }

    public Searchable[] search(String term) {
        Searchable[] result = new Searchable[5];
        int i = 0;
        for (Searchable arr : searchable) {
            if(arr.searchTerm().contains(term)){
                result[i++] = arr;
            }
        }
        return result;
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
