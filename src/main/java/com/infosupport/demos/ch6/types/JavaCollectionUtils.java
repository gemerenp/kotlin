package com.infosupport.demos.ch6.types;

import java.util.List;

public class JavaCollectionUtils {

    public static List<String> uppercaseAll(List<String> items) {
        // java.util.List is mutable
        for (int i = 0; i < items.size(); i++) {
            items.set(i, items.get(i).toUpperCase());
        }
        return items;
    }
}
