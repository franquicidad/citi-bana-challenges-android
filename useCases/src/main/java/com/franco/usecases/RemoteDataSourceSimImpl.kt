package com.franco.usecases

import com.franco.data.RemoteDataSourceSim
import com.franco.data.util.DANIELA
import com.franco.data.util.RODRIGO
import com.franco.domain.User

class RemoteDataSourceSimImpl : RemoteDataSourceSim {
    override fun createAllUsers(): List<User> {
        val list = mutableListOf<User>()
        list.add(User(1, RODRIGO, "Hola como esta?", "9:01 am"))
        list.add(User(2, DANIELA, "Aqui trabajando", "9:14 am"))
        list.add(User(1, RODRIGO, "Y eso has conseguido un empleo?", "9:15 am"))
        list.add(User(2, DANIELA, "Si he conseguido como desarrolladora android en la mejor empresa del mundo sus valores y trabajo en equipo son geniales", "9:30 am"))
        list.add(User(1, RODRIGO, "Y tu crees que me puedas a ayudar a entrar?", "9:31 am"))
        list.add(User(2, DANIELA, "Claro que si!!! incluso me daran un bono si entras !!! pasame tu Cv", "10:00 am"))
        list.add(User(1, RODRIGO, "Gracias!!!!", "10:00 am"))

        return list
    }

}