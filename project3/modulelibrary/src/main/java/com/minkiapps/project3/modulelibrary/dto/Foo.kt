package com.minkiapps.project3.modulelibrary.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Foo(val boo1 : String, val boo2 : Int)