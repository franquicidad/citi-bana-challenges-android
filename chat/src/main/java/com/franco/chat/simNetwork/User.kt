package com.franco.chat.simNetwork

import com.google.gson.annotations.SerializedName

    data class User (
        @SerializedName("id")
        val id : Int,
        @SerializedName("userName")
        val userName:String?,
        @SerializedName("message")
        val message:String?,
        @SerializedName("timeStamp")
        val timeStamp :String?
    )
