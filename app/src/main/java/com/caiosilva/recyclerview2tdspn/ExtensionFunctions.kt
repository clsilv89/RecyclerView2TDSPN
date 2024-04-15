package com.caiosilva.recyclerview2tdspn

import android.widget.ImageView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso

fun ImageView.setImageFromUrl(url: String) {
    Picasso.get().load(url).into(this)
}

fun Any.toJsonString(): String {
    val gson = GsonBuilder().create()
    return gson.toJson(this)
}

fun <T> String.fromJsonString(clazz: Class<T>): T {
    val gson = Gson()
    return gson.fromJson(this, clazz)
}