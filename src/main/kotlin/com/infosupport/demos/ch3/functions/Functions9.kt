// - Local functions and extension functions
// - `check` and `require`

package com.infosupport.demos.ch3.functions

// See Functions9KtTest
class User(val id: Int, val name: String, val address: String) {
    init {
        // example usage of `check(..)`, which acts on illegal state of our object
        check(id > 0) { "Id must be positive." }
    }
}

fun saveUserNotDRY(user: User): User {
    if (user.name.isEmpty()) {                          // | not DRY
        throw IllegalArgumentException(
            "Can't save user ${user.id}: empty Name"
        )
    }

    if (user.address.isEmpty()) {                       // | not DRY
        throw IllegalArgumentException(
            "Can't save user ${user.id}: empty Address"
        )
    }

    // Save user to the database . . .

    return user
}

fun saveUser(user: User): User {

    fun validate(value: String, fieldName: String) { // local function
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                // Accessing user from outer function
                "Can't save user ${user.id}: empty $fieldName"
            )
        }
    }

    validate(user.name, "Name")                     // call local function
    validate(user.address, "Address")

    // Save user to the database . . .

    return user
}

fun saveUserShorter(user: User): User {

    fun validate(value: String, fieldName: String) { // local function
        // example usage of `require(...)`, which acts on an illegal argument
        require(value.isNotEmpty()) { "Can't save user ${user.id}: empty $fieldName" }
    }

    validate(user.name, "Name")                     // call local function
    validate(user.address, "Address")

    // Save user to the database . . .

    return user
}

fun saveUserExtFn(user: User): User {
    user.validate()

    // Save user to the database . . .

    return user
}

fun User.validate() {
    fun validate(propertyName: String, value: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                "Can't save user $id: empty $propertyName"
            )
        }
    }
    validate(propertyName = "name", value = name)
    validate(propertyName = this::address.name, value = address) // here we get property using reflection
}

// Lab 2f
