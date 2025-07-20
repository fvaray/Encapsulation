package org.skypro.skyshop.service;

public interface Searchable {

    String getSearchTerm();

    String getTypeContent();

    default String getStringRepresentation(){
        return this.toString();
    }
}
