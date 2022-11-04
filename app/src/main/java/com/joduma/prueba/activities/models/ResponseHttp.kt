package com.joduma.prueba.activities.models

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

class ResponseHttp (
    @SerializedName("message") val message: String,
    @SerializedName("success") val issuccess: Boolean,
    @SerializedName("data") val data: JsonObject,
    @SerializedName("error") val error: String,
    ) {
        override fun toString(): String {
            return "ResponseHttp(message='$message', issuccess=$issuccess, data=$data, error='$error')"
        }
}