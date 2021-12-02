package com.example.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler.databinding.ListHeaderBinding
import com.example.recycler.databinding.ListItemBinding

class ListAdapter(private val data:List<ListData>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    object viewTypes  {
        val HEADER = 1
        val ITEM = 2
        val FOOTER = 3
    }

    inner class HeaderHolder(view: View):RecyclerView.ViewHolder(view){
        val textView:TextView = view.findViewById(R.id.list_header)

        fun bind(position: Int){
            textView.text = "Header"
        }
    }

    inner class ListHolder(view:View):RecyclerView.ViewHolder(view){
        val textVeiw:TextView = view.findViewById(R.id.list_item)

        fun bind(position: Int){
            val item = data[position-1]
            textVeiw.text = item.title
        }
    }

    inner class FooterHolder(view: View):RecyclerView.ViewHolder(view){
        val textView:TextView = view.findViewById(R.id.list_header)

        fun bind(position: Int){
            textView.text = "Footer"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        return when(viewType){
            viewTypes.ITEM->{
                val binding = ListItemBinding.inflate(inflator, parent, false)
                ListHolder(binding.root)
            }
            viewTypes.HEADER->{
                val binding = ListHeaderBinding.inflate(inflator, parent, false)
                HeaderHolder(binding.root)
            }
            else->{
                val binding = ListHeaderBinding.inflate(inflator, parent, false)
                FooterHolder(binding.root)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder.itemViewType == viewTypes.ITEM){
            val view = holder as ListHolder
            view.bind(position)
        }else if (holder.itemViewType == viewTypes.HEADER){
            val view = holder as HeaderHolder
            view.bind(position)
        }else if (holder.itemViewType == viewTypes.FOOTER){
            val view = holder as FooterHolder
            view.bind(position)
        }
    }

    override fun getItemCount(): Int {
        return data.size+1
    }

    override fun getItemViewType(position: Int): Int {
        if(position == 0){
            return viewTypes.HEADER
        }else if(position>0 && position<(itemCount-1)){
            return viewTypes.ITEM
        }else{
            return viewTypes.FOOTER
        }
    }
}