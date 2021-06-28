// Local functions and extension functions

package com.infosupport.demos.h3.functions

// TODO show: see test

class User(val id: Int, val name: String, val address: String)

// TODO show
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

// TODO tell
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

// TODO show
fun saveUserExtFn(user: User): User {
    user.validate()

    // Save user to the database . . .

    return user
}

// TODO tell
fun User.validate() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException(
                "Can't save user $id: empty $fieldName"
            )
        }
    }
    validate(name, "Name")
    validate(address, "Address")
}
