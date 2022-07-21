package it.elsalamander.calculatorbridge.layout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import it.elsalamander.calculatorbridge.R

class DrawerAdapter(private val dataSet: Array<String>, val callback: DrawerAdapterCallback): RecyclerView.Adapter<DrawerAdapter.ViewHolder>() {

    interface DrawerAdapterCallback {
        fun onDrawerItemClick (value: String)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val title : TextView
        val desc : TextView

        init{
            title = view.findViewById(R.id.item_layout_text_title)
            desc = view.findViewById(R.id.item_layout_text_description)

            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            callback.onDrawerItemClick(title.text.toString())
        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_drawer, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.title.text = dataSet[position]
        viewHolder.desc.text = "prove"
    }

    override fun getItemCount() = dataSet.size
}
