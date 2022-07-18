package com.example.NewsBytes
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RvAdapter( private val listener: NewsItemClick): RecyclerView.Adapter<CategViewHolder>() {
    private val item: ArrayList<horizon_adap> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_rv_item, parent, false)
        val viewHolder = CategViewHolder(view)
        view.setOnClickListener {
            listener.onItemClicked(item[viewHolder.absoluteAdapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: CategViewHolder, position: Int) {
        val currentItem= item[position]
        holder.titleView.text= currentItem.category
    }

    override fun getItemCount(): Int {
        return item.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun updatecategory(updatedcategory: ArrayList<horizon_adap>){
        item.clear()
        item.addAll(updatedcategory)

        notifyDataSetChanged()
    }
}

class CategViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleView: TextView = itemView.findViewById(R.id.title)


}

interface NewsItemClick {
    fun onItemClicked(item: horizon_adap) {

    }
}
