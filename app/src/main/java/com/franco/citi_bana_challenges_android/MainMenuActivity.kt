package com.franco.citi_bana_challenges_android

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.recyclerview.widget.LinearLayoutManager
import com.franco.chat.ui.ChatActivity
import com.franco.citi_bana_challenges_android.databinding.ActivityMenuMainBinding
import com.franco.citi_bana_challenges_android.model.MainMenu
import com.franco.citi_bana_challenges_android.utils.RecyclerItemClickListener
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

//            recyclerViewApp.setOnClickListener{
//                    startActivity<ChatActivity>()
//            }
        }
        binding.recyclerViewApp.addOnItemTouchListener(RecyclerItemClickListener
            (this,binding.recyclerViewApp, object : RecyclerItemClickListener.OnItemClickListener{
            override fun onItemClick(view: View, position: Int) {
                when (position){
                    0 -> startActivity<ChatActivity>()
                }
            }

            override fun onItemLongClick(view: View?, position: Int) {
                TODO("Not yet implemented")
            }

        }))


    }

    override  fun createMainModuleNames(): List<MainMenu> {
         list = mutableListOf()
        list.add(MainMenu("Chat"))

        return list
    }


}