package com.example.test.ui.matches

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test.data.model.PlayersAction

class MatchesAdapter(val context: Context,val playerList: ArrayList<PlayersAction>):
    RecyclerView.Adapter<MatchesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

}