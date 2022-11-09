package com.example.testappformvvm.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testappformvvm.databinding.ItemDataBinding
import com.example.testappformvvm.repository.model.ExampleData

class TestAdapter(private var exampleData: ExampleData) : RecyclerView.Adapter<TestAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = exampleData.list[position]
        holder.binding?.text?.text= data.sector
        holder.binding?.text1?.text= data.companyName
        holder.binding?.text2?.text= data.marketType
    }

    override fun getItemCount(): Int {
        return exampleData.list.size
    }

    class ViewHolder(item: ItemDataBinding): RecyclerView.ViewHolder(item.root) {
        var binding:ItemDataBinding?=null

        init {
            this.binding = item
        }

    }
}