package org.skypro.skyshop.product;

public interface Searchable {

    default String searchTerm(){
        return this.toString();
    }

    default String typeContent(){
        return "";
    }

    default Searchable nameObject(){
        return this;
    }

    default String getStringRepresentation(){
        return this.toString();
    }
}
