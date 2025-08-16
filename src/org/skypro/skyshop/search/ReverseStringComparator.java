package org.skypro.skyshop.search;

import java.util.Comparator;

public class ReverseStringComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable s2, Searchable s1) {
        int compareResult;
        compareResult = Integer.compare(s1.getSearchTerm().length(), s2.getSearchTerm().length());
        if (compareResult == 0) {
            compareResult = s2.getSearchTerm().compareTo(s1.getSearchTerm());
            return compareResult;
        }
        else{
            return compareResult;
        }
    }
}