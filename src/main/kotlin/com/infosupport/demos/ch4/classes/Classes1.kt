package com.infosupport.demos.ch4.classes

import javax.naming.Context
import javax.naming.InitialContext
import javax.print.attribute.AttributeSet
import javax.print.attribute.HashAttributeSet
import javax.print.attribute.HashDocAttributeSet

// Nontrivial constructors or properties

fun main() {
    // calling ctors:
    val userVerbose = UserVerbose("BramBramBram") // Java style
    val userVerboseNickname = userVerbose.getNickname()    // call getter function
    userVerbose.setNickname("BramBram")                    // call setter function

    val userLessVerbose = UserLessVerbose("BramBram")
    val userLessVerboseNickname = userLessVerbose.nickname // call property
    userLessVerbose.nickname = "Bram"

    val userEvenLessVerbose = UserEvenLessVerbose("BramBr")
    val userEvenLessVerboseNickname = userEvenLessVerbose.nickname
    userEvenLessVerbose.nickname = "BramB"

    val user = User("Bram")
    val nickname = user.nickname
    user.nickname = "Mark"

    val jeff = TwitterUser("Jeff")
    val besos = jeff.nickname

    // calling subclass ctor
    val radio = RadioButton()

    // calling private ctor not allowed:
    // val s = Secretive()

    // calling ctor overloads:
    val myView1 = MyView(InitialContext())
    val myView2 = MyView(InitialContext(), HashAttributeSet())
    val myButt1 = MyButton(InitialContext())
    val myButt2 = MyButton(InitialContext(), HashDocAttributeSet())
}

// Java style
open class UserVerbose constructor(nickname: String) { // primary ctor declaration

    private var _nickname: String // the internal (backing) field

    init { // primary ctor implementation
        this._nickname = nickname
    }

    fun getNickname() = _nickname // the getter makes the internal field available, making it a property

    fun setNickname(value: String) {
        this._nickname = value
    }
}

open class UserLessVerbose(nickname: String) {
    var nickname = nickname // no private makes it a property
        get() = field
        set(value) {
            field = value
        }
}

open class UserEvenLessVerbose(nickname: String) {
    var nickname = nickname
}

// least verbose, most concise:
open class User(var nickname: String) // primary constructor

// subclass
class TwitterUser(nickname: String) : User(nickname) // primary constructor and call to super (required)

open class OpenButton
class RadioButton : OpenButton() // call to super (required)

class Secretive private constructor() {} // private ctor

open class MyView { // no primary constructor, two secondary constructors
    constructor(ctx: Context) {}
    constructor(ctx: Context, attr: AttributeSet) {}
}

class MyButton : MyView { // no primary constructor, two secondary constructors
    constructor(ctx: Context) : this(ctx, HashAttributeSet()) {} // delegate to this
    constructor(ctx: Context, attr: AttributeSet) : super(ctx, attr) {} // delegate to super
}
