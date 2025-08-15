package org.skypro.skyshop.search;

import java.util.Comparator;

public class ReverseStringComparator implements Comparator<String> {
    @Override
    public int compare(String s2, String s1) {
        int compareResult;
        compareResult = Integer.compare(s1.length(), s2.length());
        if (compareResult == 0) {
            compareResult = s2.compareTo(s1);
            return compareResult;
        }
        else{
            return compareResult;
        }
    }
}