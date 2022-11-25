package com.joduma.prueba.activities.models

import com.google.gson.annotations.SerializedName

class Rol(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
) {
    override fun toString(): String {
        return "Rol(id='$id', name='$name')"
    }
}