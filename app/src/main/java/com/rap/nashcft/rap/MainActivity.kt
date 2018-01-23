package com.rap.nashcft.rap

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import io.reactivex.Observable
import java.math.BigDecimal
import java.util.*

class MainActivity : AppCompatActivity() {

    @BindView(R.id.hello_world_salute)
    lateinit var helloText: TextView

    @BindView(R.id.stock_updates_recycler_view)
    lateinit var recyclerView: RecyclerView

    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var stockDataAdapter: StockDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButterKnife.bind(this)

        Observable.just("Hello! Please use this app responsibly!")
                .subscribe { helloText.text = it }

        recyclerView.setHasFixedSize(true)

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        stockDataAdapter = StockDataAdapter()
        recyclerView.adapter = stockDataAdapter

        Observable.just(
                StockUpdate("GOOGLE", BigDecimal(12.43), Date()),
                StockUpdate("APPL", BigDecimal(645.1), Date()),
                StockUpdate("TWTR", BigDecimal(1.43), Date())
        ).subscribe { stockDataAdapter.add(it) }
    }
}
