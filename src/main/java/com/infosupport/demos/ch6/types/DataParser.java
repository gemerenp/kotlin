package com.infosupport.demos.ch6.types;


import java.util.List;

interface DataParser<T> {
    // Parses the input which contains values separated by a separator,
    // creates objects from inputs and puts those in output
    // and creates errors of each unparsable input, or null if everything went ok.
    void parseData(String input,
                   List<T> output,
                   List<String> errors);
}
