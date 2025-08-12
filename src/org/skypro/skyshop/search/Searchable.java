package org.skypro.skyshop.search;

public interface Searchable {

    String getSearchTerm();

    default String getStringRepresentation(){
        return this.toString();

    }
}
