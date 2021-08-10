package com.infosupport.demos.h4.classes

import java.lang.Thread.sleep

// Implementing properties declared in interfaces
// Accessing a backing field from a getter or setter

private val Delay = 1_000L

// TODO show
fun main(args: Array<String>) {
    // Implementing properties declared in interfaces: ---------------------------------
    println("Initializing objects...")
    val privateUser = PrivateUser("private")
    val subscribingUser = SubscribingUser("sub@kotlinlang.org")
    val facebookUser = FacebookUser("face@kotlinlang.org", 2325675) // takes some time...
    println("Proceeding...")

    println(privateUser.nickname)
    println(privateUser.email)

    println(subscribingUser.nickname) // takes long every call
    println(subscribingUser.nickname) // takes long every call
    println(subscribingUser.email)

    println(facebookUser.nickname) // fast call from cache
    println(facebookUser.nickname) // fast call from cache
    println(facebookUser.email)

    // Accessing a backing field from a getter or setter: --------------
    val user = Person("Alice")
    user.address = "Elsenheimerstrasse 47, 80687 Muenchen"

    println(user.age) // getter
    // user.age = 42  // setter is private

    repeat(42) { user.haveBirthday() }
    println(user.age) // 42
    repeat(88) { user.haveBirthday() }
    println(user.age) // 130
    try {
        user.haveBirthday() // 131 --> Person died
    } catch (e: Exception) {
        println(e.message)
    }
}

interface IUser {
    val email: String
    val nickname: String
        get() = email.substringBefore('@')
}

class PrivateUser(override val nickname: String) : IUser {
    override val email: String = "anonymous@mail.com"
}

class SubscribingUser(override val email: String) : IUser { // email has default getter
    override val nickname: String // nickname gets custom getter; called on every access.
        get() {
            println("Getting SubscribingUser's nickname... ")
            sleep(Delay) // expensive call
            return email.substringBefore('@')
        }
}

class FacebookUser(override val email: String, accountId: Int) : IUser {
    // property initializer, no custom getter: nickname is set only once since it's an expensive call;
    override val nickname = getFacebookNameFromWeb(accountId) // executed when ctor is called.
}

fun getFacebookNameFromWeb(accountId: Int): String {
    println("getFacebookNameFromWeb... ")
    sleep(Delay) // expensive call
    return "fb:$accountId"
}

// Accessing a backing field from a getter or setter: --------------
open class Person(val name: String) {

    // we want to log every change to address:
    var address: String = "unspecified"
        set(newAddress) { // custom setter
            // first: log
            println("""Address was changed for $name: "$field" -> "$newAddress".""".trimIndent())

            // then: set the backing field (like normal)
            field = newAddress
        }

    var age: Int = 0
        get() = if (field <= 130) field else throw RuntimeException("Person died") // custom getter accessing the backing field:
        private set // hide setter; age can only be modified by fun haveBirthday() below:

    fun haveBirthday() = age++
}


