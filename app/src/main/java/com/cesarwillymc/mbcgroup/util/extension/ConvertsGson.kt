package com.cesarwillymc.mbcgroup.util.extension

import com.cesarwillymc.mbcgroup.util.constants.EMPTY_STRING
import com.cesarwillymc.mbcgroup.util.constants.UTF_8
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.net.URLDecoder
import java.net.URLEncoder

inline fun <reified T> toJson(model: T): String {
    val json = Gson().toJson(model)
    return URLEncoder.encode(json, UTF_8)
}

inline fun <reified T> fromJson(model: String): T {
    val type: Type = object : TypeToken<T>() {}.type
    return Gson().fromJson(URLDecoder.decode(model, UTF_8), type) as T
}

inline fun <reified T> fromJsonList(model: String): List<T> {
    return Gson().fromJson(
        model.replace("{", EMPTY_STRING).replace("}", EMPTY_STRING),
        Array<T>::class.java
    ).asList()
}
