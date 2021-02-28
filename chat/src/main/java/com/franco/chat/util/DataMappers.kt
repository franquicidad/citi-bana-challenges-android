package com.franco.chat.util

import com.franco.chat.simNetwork.User as NetworkModel
import com.franco.domain.User

fun NetworkModel.fromNetworkToDomainMapper():User =
    User(
        id,
     userName?:"",
    message?:"",
        timeStamp?:""
        )


fun User.fromDomainToNetwork():NetworkModel=
    NetworkModel(
        id, userName, message, timeStamp
    )