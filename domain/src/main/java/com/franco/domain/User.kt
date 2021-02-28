package com.franco.domain

import com.google.gson.annotations.SerializedName

data class User (
    val id : Int= 0,
    val userName:String="",
    val message:String="",
    val timeStamp :String=""
        )