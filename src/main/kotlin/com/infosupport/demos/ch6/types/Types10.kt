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
        The Kotlin implementation of this interface needs to make the following choices for param textContents:
            - It will be nullable, because some files are binary and their contents can’t be represented as text.
            - The elements in the list will be non-null, because lines in a file are never null.
            - The list will be read-only, because it represents the contents of a file, and those contents aren’t going to be modified.
        */
    }
}

class PersonParser : DataParser<Person> { // note: DataParser.java can be found in src/main/java/...
    override fun parseData(
        input: String,
        output: MutableList<Person>,
        errors: MutableList<String?>
    ) {
        /*
        The choices in this case are different :
            - List<String> output will be mutable, because the implementing code needs to add elements to it.
            - List<T> errors will be non-null, because the callers always need to receive error messages.
            - The elements in the list will be nullable, because not every item in the output list will have an associated error message.

         */
    }
}
