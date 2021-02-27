package com.franco.citi_bana_challenges_android

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.recyclerview.widget.LinearLayoutManager
import com.franco.citi_bana_challenges_android.databinding.ActivityMenuMainBinding
import com.franco.citi_bana_challenges_android.model.MainMenu
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope

class MainMenuActivity : AppCompatActivity(), CreateMainMenuItems {


    private lateinit var binding: ActivityMenuMainBinding
    private lateinit var  list: MutableList<MainMenu>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = setContentView(this, R.layout.activity_menu_main)

        with(binding){
            val list=createMainModuleNames()
             recyclerViewApp.adapter= MainMenuAdapter(list)
            recyclerViewApp.setOnClickListener{
                    startActivity<MainMenuActivity>()
            }
        }

    }

    override  fun createMainModuleNames(): List<MainMenu> {
         list = mutableListOf()
        list.add(MainMenu("Chat"))

        return list
    }


}