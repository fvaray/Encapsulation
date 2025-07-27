package org.skypro.skyshop.exceptions;

import java.io.IOException;

public class IllegalArgumentException extends IOException {
    private String str;
    public IllegalArgumentException(){
        super();
    }

    public IllegalArgumentException(String s){
        super(s);
        str = s;
    }

    @Override
    public String toString() {
        return str;
    }
}
