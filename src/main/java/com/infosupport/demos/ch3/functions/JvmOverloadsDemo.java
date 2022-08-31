package com.infosupport.demos.ch3.functions;

import java.util.Arrays;

import static com.infosupport.demos.ch3.functions.Functions2Kt.joinToStringDefaultParamValues;
import static com.infosupport.demos.ch3.functions.Functions2Kt.joinToStringDefaultParamValuesNoOverloads;

public class JvmOverloadsDemo {

    public static void main(String[] args) {
        var list = Arrays.asList(1, 2, 3);

        System.out.println(joinToStringDefaultParamValues(list));
        System.out.println(joinToStringDefaultParamValues(list, " | "));
        System.out.println(joinToStringDefaultParamValues(list, " | ", "<!-- "));
        System.out.println(joinToStringDefaultParamValues(list, " | ", "<!-- ", " -->"));

        System.out.println(joinToStringDefaultParamValuesNoOverloads(list, null, null, null));
        System.out.println(joinToStringDefaultParamValuesNoOverloads(list, " | ", null, null));
        System.out.println(joinToStringDefaultParamValuesNoOverloads(list, " | ", "<!-- ", null));
        System.out.println(joinToStringDefaultParamValuesNoOverloads(list, " | ", "<!-- ", " -->"));
    }

}
