package com.rap.nashcft.rap

import android.support.v7.widget.RecyclerView
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.Date

class StockDataAdapter : RecyclerView.Adapter<StockDataUpdateViewHolder>() {

    private val data = mutableListOf<StockUpdate>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): StockDataUpdateViewHolder {
        val v = LayoutInflater.from(parent?.context)
                .inflate(R.layout.stock_update_item, parent, false)
        return StockDataUpdateViewHolder(v)
    }

    override fun onBindViewHolder(holder: StockDataUpdateViewHolder?, position: Int) {
        val stockUpdate = data[position]
        holder?.setStockUpdate(stockUpdate)
    }

    override fun getItemCount() = data.size

    fun add(stockUpdate: StockUpdate) {
        data.add(stockUpdate)
        notifyItemInserted(data.size - 1)
    }

}

class StockDataUpdateViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    @BindView(R.id.stock_item_symbol)
    lateinit var stockSymbol: TextView

    @BindView(R.id.stock_item_date)
    lateinit var date: TextView

    @BindView(R.id.stock_item_price)
    lateinit var price: TextView

    private val priceFormat = DecimalFormat("#0.00")

    init {
        ButterKnife.bind(this, v)
    }

    fun setStockUpdate(stockUpdate: StockUpdate) {
        stockSymbol.text = stockUpdate.stockSymbol
        date.text = DateFormat.format("yyyy-MM-dd hh:mm", stockUpdate.date)
        price.text = priceFormat.format(stockUpdate.price.toFloat())
    }
}

data class StockUpdate(val stockSymbol: String, val price: BigDecimal, val date: Date)