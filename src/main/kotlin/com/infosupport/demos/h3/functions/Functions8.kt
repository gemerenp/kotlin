// Working with strings and regular expressions

package com.infosupport.demos.h3.functions

// TODO show
fun main() {
    // --------------------------------
    // 1. Splitting strings
    // The split method in Java doesn’t work with a dot, because the string arg is considered a regex.
    // In Java: "12.345-6.A".split(".") != [12, 345-6, A]; see SplitDemo.java

    // Kotlin does a better job: split works with a literal string
    println("12.345-6.A".split(".", "-"))

    // --------------------------------
    // 2. Regular expressions and triple-quoted strings
    parsePath("/Users/yole/kotlin-book/chapter.adoc")
    parsePathRegEx("/Users/yole/kotlin-book/chapter.adoc")

    // --------------------------------
    // 3. Multiline triple-quoted strings with string template
    println(aardVark.trimMargin("|"))
}

fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullFileName = path.substringAfterLast("/")

    val fileName = fullFileName.substringBeforeLast(".")
    val extension = fullFileName.substringAfterLast(".")

    println("Dir: $directory, name: $fileName, ext: $extension")
}

fun parsePathRegEx(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex() // TODO tell: triple quoted string
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured
        println("Dir: $directory, name: $filename, ext: $extension")
    }
}

val author = "Jens Reissenweber"
val aardVark = """
            |								  _                 _        
            |			   __ _  __ _ _ __ __| |_   ____ _ _ __| | __ 
            |			  / _` |/ _` | '__/ _` \ \ / / _` | '__| |/ / 
            |			 | (_| | (_| | | | (_| |\ V / (_| | |  |   <
            |			  \__,_|\__,_|_|  \__,_| \_/ \__,_|_|  |_|\_\
            |				 ,
            |		   (`.  : \               __..----..__
            |			`.`.| |:          _,-':::''' '  `:`-._
            |			  `.:\||       _,':::::'         `::::`-.
            |				\\`|    _,':::::::'     `:.     `':::`.
            |				 ;` `-''  `::::::.                  `::\
            |			  ,-'      .::'  `:::::.         `::..    `:\
            |			,' /_) -.            `::.           `:.     |
            |		  ,'.:     `    `:.        `:.     .::.          \
            |	 __,-'   ___,..-''-.  `:.        `.   /::::.         |
            |	|):'_,--'           `.    `::..       |::::::.      ::\
            |	 `-'                 |`--.:_::::|_____\::::::::.__  ::|
            |						 |   _/|::::|      \::::::|::/\  :|
            |						 /:./  |:::/        \__:::):/  \  :\
            |					   ,'::'  /:::|        ,'::::/_/    `. ``-.__
            |					  ''''   (//|/\      ,';':,-'         `-.__  `'--..__
            |															   `''---::::'
            |
            | (C) $author
            |"""

