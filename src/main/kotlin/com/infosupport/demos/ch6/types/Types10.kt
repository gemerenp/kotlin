package com.infosupport.demos.ch6.types

import java.io.File

// If ⏲ permits
// Collections and arrays: Collections as platform types

/*
    When you’re overriding or implementing a Java method that has a collection type in its signature,
    you need to decide which Kotlin type you’re going to use to represent a Java type coming
    from the method you’re overriding or implementing.

    You need to make multiple choices in this situation, all of which will be reflected in
    the resulting parameter type in Kotlin:
        - Is the collection nullable?
        - Are the elements in the collection nullable?
        - Will your method modify the collection?
*/

class FileIndexer : FileContentProcessor { // note: FileContentProcessor.java can be found in src/main/java/...
    override fun processContents(
        path: File,
        binaryContents: ByteArray?,
        textContents: List<String>?
    ) {
        /*
        The Kotlin implementation of this interface makes the following choices:
            - `textContents` will be immutable, because it represents the contents of a file, and those contents aren’t going to be modified.
            - `textContents` will be nullable, because some files are binary and their contents can’t be represented as text.
            - The elements in the list will be non-null, because lines in a file are never null.
        */

        //...
    }
}

class PersonParser : DataParser<Person> { // note: DataParser.java can be found in src/main/java/...
    override fun parseData(
        input: String,
        output: MutableList<Person>,
        errors: MutableList<String?>
    ) {
        /*
        The choices in this case are different:
            - `output` must be mutable, because the implementing code needs to add elements to it.
            - `errors` must be non-null, because the callers always need to receive error messages.
            - the elements in `errors` will be nullable, because not every item in the output list will have an associated error message.
         */
        for (name in input.split(",")) {
            if (name.length > 20) {
                output.add(Person(name.substring(20)))
                errors.add("WARN - $name is too long. Name is truncated!")
            } else {
                output.add(Person(name))
                errors.add(null)
            }
        }
    }
}
