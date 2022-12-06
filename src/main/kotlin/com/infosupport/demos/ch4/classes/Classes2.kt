package com.infosupport.demos.ch4.classes

import java.lang.Thread.sleep

// Implementing properties declared in interfaces
// Accessing a backing field from a getter or setter

fun main() {
    // Implementing properties declared in interfaces: ---------------------------------
    println("Initializing objects...")
    val regularUser = RegularUser("elon@tesla.com", "muskie")
    val privateUser = PrivateUser("mrAnonymous")
    val subscribingUser = SubscribingUser("sub@kotlinlang.org")
    val facebookUser = FacebookUser("face@kotlinlang.org", 2325675) // takes some time...
    println("Proceeding...")

    println(regularUser.nickname)   // nothing special
    println(regularUser.email)

    println(privateUser.nickname)   // nothing special
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

class RegularUser(
    override val email: String,
    override val nickname: String,
) : IUser

class PrivateUser(
    override val nickname: String
) : IUser {
    override val email: String = "anonymous@mail.com"
}

class SubscribingUser(
    override val email: String
) : IUser {
    // nickname has custom getter: executed on every access
    override val nickname: String = ""
        get() {
            println("Getting SubscribingUser's nickname from db... ")
            sleep(DELAY) // call to backend
            return field
        }
}

class FacebookUser(
    override val email: String,
    accountId: Int
) : IUser {
    // nickname has a property initializer: executed only once, at construction time
    override val nickname = getFacebookNameFromWeb(accountId)
}

fun getFacebookNameFromWeb(accountId: Int): String {
    println("getFacebookNameFromWeb... ")
    sleep(DELAY * 2) // expensive call
    return "fb:$accountId"
}

// Accessing a backing field from a getter or setter: --------------
open class Person(val name: String) {

    // Suppose we want to log every change to address:
    var address: String = "unspecified"
        set(newAddress) { // custom setter
            // first: log
            println("""Address was changed for $name: "$field" -> "$newAddress".""".trimIndent())

            // then: set the backing field (like normal)
            field = newAddress
        }

    var age: Int = 0
        get() = if (field <= 130) field else throw RuntimeException("Person deceased") // custom getter accessing the backing field:
        private set // hide setter; age can only be modified by fun haveBirthday() below:

    fun haveBirthday() = age++ // getter is called here too
}

private const val DELAY = 1_000L

// Lab 1
