package org.skypro.skyshop.search;

public interface Searchable {

    String getSearchTerm();

    String getTypeContent();

    default String getStringRepresentation(){
        return this.toString();

    }
}
