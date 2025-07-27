package org.skypro.skyshop.exceptions;

import java.io.IOException;

public class OutOfRangeException extends IOException {
    private String str;
    public OutOfRangeException(){
        super();
    }

    public OutOfRangeException(String s){
        super(s);
        str = s;
    }

    @Override
    public String toString() {
        return str;
    }
}
