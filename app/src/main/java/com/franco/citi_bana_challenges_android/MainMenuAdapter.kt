package com.franco.citi_bana_challenges_android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.franco.citi_bana_challenges_android.databinding.ItemMainMenuRecyclerBinding
import com.franco.citi_bana_challenges_android.model.MainMenu

class MainMenuAdapter(private val items: List<MainMenu>): RecyclerView.Adapter<MainMenuAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding= ItemMainMenuRecyclerBinding.bind(itemView)
        fun bind(mainMenu:MainMenu){
            with(binding){
                buttonRvMenu.text= mainMenu.actionModule
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =parent.inflate(R.layout.item_main_menu_recycler)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item =items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}