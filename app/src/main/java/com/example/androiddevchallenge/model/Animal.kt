package com.example.androiddevchallenge.model

import androidx.annotation.DrawableRes

/**
 * Animal infos
 */
open class Animal(
    var cuteId: String,
    var name: String,
    @DrawableRes var image: Int,
    @DrawableRes val typeIcon: Int,
    var title: String? = null,
    var detail: String? = null
)