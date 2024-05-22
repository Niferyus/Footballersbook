package com.example.footballersbook

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.footballersbook.databinding.RecyclerRowBinding

class FootballerAdapter(val footballerlist: ArrayList<Footballer>): RecyclerView.Adapter<FootballerAdapter.FootballerHolder>() {
    class FootballerHolder(val binding: RecyclerRowBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FootballerHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return FootballerHolder(binding)
    }

    override fun getItemCount(): Int {
     return  footballerlist.size
    }

    override fun onBindViewHolder(holder: FootballerHolder, position: Int) {
        holder.binding.rvtextview.text = footballerlist.get(position).name
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context,DetailsActivity::class.java)
            intent.putExtra("footballer",footballerlist.get(position))
            holder.itemView.context.startActivity(intent)

        }
    }
}