package com.example.abudhabibank

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.info_item_row.view.*

class InfoAdapter(private val newList:List<Info>):
    RecyclerView.Adapter<InfoAdapter.ViewHolder>() {

    private lateinit var mListener:onItemClickListener

    interface  onItemClickListener{
        fun onItemClick(position: Int)

    }

    fun setOnItemClickListener(listener:onItemClickListener){
        mListener=listener
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.info_item_row
            ,parent,false)
        return ViewHolder(itemView,mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem: Info = newList[position]
        holder.bind(currentItem,position)
    }

    override fun getItemCount(): Int {
        return newList.size
    }

    class ViewHolder(itemView: View,listener:onItemClickListener):
        RecyclerView.ViewHolder(itemView){
        fun bind(info: Info, position:Int){

            itemView.btnName.text=info.name
            itemView.txtLink.text=info.link
        }

        init {
            itemView.btnName.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }

        }

    }


}