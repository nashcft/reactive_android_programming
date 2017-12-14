package com.rap.nashcft.rap

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife

class StockDataAdapter : RecyclerView.Adapter<StockDataAdapter.StockDataUpdateViewHolder>() {

    private val data = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): StockDataUpdateViewHolder {
        val v = LayoutInflater.from(parent?.context)
                .inflate(R.layout.stock_update_item, parent, false)
        return StockDataUpdateViewHolder(v)
    }

    override fun onBindViewHolder(holder: StockDataUpdateViewHolder?, position: Int) {
        holder?.stockSymbol?.text = data[position]
    }

    override fun getItemCount() = data.size

    fun add(stockSymbol: String) {
        data.add(stockSymbol)
        notifyItemInserted(data.size - 1)
    }

    class StockDataUpdateViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        @BindView(R.id.stock_item_symbol)
        lateinit var stockSymbol: TextView

        init {
            ButterKnife.bind(this, v)
        }
    }
}