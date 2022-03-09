package com.example.demo.util.validator;

import com.example.demo.model.util.Label;

public final  class Validator {
    public static  boolean checkLength(final String value, final int length){
        return value.length()==length;
    }

    public static  boolean checkLabel(final String label){
        return false;
    }




}
