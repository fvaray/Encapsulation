package org.skypro.skyshop.service;

import org.skypro.skyshop.search.Searchable;

public class Article implements Searchable {
    private String articleName;
    private String articleText;

    public Article(String articleName, String articleText) {
        this.articleName = articleName;
        this.articleText = articleText;
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public String getTypeContent() {
        return "ARTICLE";
    }

    public int getPrice() {
        return 0;
    }

    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return articleName + '\'' + articleText + '\'';
    }
}
