package com.infosupport.demos.h3.functions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class Functions9KtTest {

    private val user = User(1, "Bram", "Straat")
    private val userNoStreet = User(1, "Bram", "")
    private val userNoName = User(1, "", "Straat")
    private val userNoStreetNoName = User(1, "", "")

    @Test
    fun saveUser() {
        assertThrows(::saveUser, userNoStreet)
        assertThrows(::saveUser, userNoName)
        assertThrows(::saveUser, userNoStreetNoName)

        assertEquals(saveUser(user).id, 1)
    }

    @Test
    fun saveUserNotDRY() {
        assertThrows(::saveUserNotDRY, userNoStreet)
        assertThrows(::saveUserNotDRY, userNoName)
        assertThrows(::saveUserNotDRY, userNoStreetNoName)

        assertEquals(saveUserNotDRY(user).id, 1)
    }

    @Test
    fun saveUserExtFn() {
        assertThrows(::saveUserExtFn, userNoStreet)
        assertThrows(::saveUserExtFn, userNoName)
        assertThrows(::saveUserExtFn, userNoStreetNoName)

        assertEquals(saveUserExtFn(user).id, 1)
    }

    private fun assertThrows(saveFunction: (User) -> User, user: User) {
        assertThrows<IllegalArgumentException> { saveFunction(user) }
    }
}
