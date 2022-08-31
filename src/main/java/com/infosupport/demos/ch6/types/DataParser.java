package com.infosupport.demos.ch6.types;


import java.util.List;

interface DataParser<T> {
    void parseData(String input,
                   List<T> output,
                   List<String> errors);
}
