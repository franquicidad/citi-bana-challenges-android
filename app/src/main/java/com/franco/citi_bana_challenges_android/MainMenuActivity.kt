package com.franco.citi_bana_challenges_android

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import androidx.recyclerview.widget.RecyclerView
import com.franco.chat.ui.ChatActivity
import com.franco.citi_bana_challenges_android.model.MainMenu
import com.franco.citi_bana_challenges_android.utils.RecyclerItemClickListener
import com.franco.gridexercise.GridActivity


class MainMenuActivity : AppCompatActivity(), CreateMainMenuItems {

    private lateinit var list: MutableList<MainMenu>
    private lateinit var recyclerViewApp: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_main)

        recyclerViewApp = findViewById(R.id.recyclerView_app)


        val list = createMainModuleNames()
        recyclerViewApp.adapter = MainMenuAdapter(list)

//            recyclerViewApp.setOnClickListener{
//                    startActivity<ChatActivity>()
//            }

        recyclerViewApp.addOnItemTouchListener(
            RecyclerItemClickListener
                (this, recyclerViewApp, object : RecyclerItemClickListener.OnItemClickListener {
                override fun onItemClick(view: View, position: Int) {
                    when (position) {
                        0 -> startActivity<ChatActivity>()
                        1 -> startActivity<GridActivity>()
                    }
                }

                override fun onItemLongClick(view: View?, position: Int) {
                    TODO("Not yet implemented")
                }

            })
        )


    }

    override  fun createMainModuleNames(): List<MainMenu> {
         list = mutableListOf()
        list.add(MainMenu("Chat"))
        list.add(MainMenu("GridView"))

        return list
    }


}