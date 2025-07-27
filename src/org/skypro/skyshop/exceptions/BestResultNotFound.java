package org.skypro.skyshop.exceptions;

import java.io.IOException;

public class BestResultNotFound extends IOException {
    private String str;
    public BestResultNotFound(){
        super();
    }

    public BestResultNotFound(String s){
        super(s);
        str = s;
    }

    @Override
    public String toString() {
        return str;
    }
}
