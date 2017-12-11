package com.rap.nashcft.rap

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import io.reactivex.Observable

class MainActivity : AppCompatActivity() {

    @BindView(R.id.hello_world_salute)
    lateinit var helloText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButterKnife.bind(this)

        Observable.just("Hello! Please use this app responsibly!")
                .subscribe { helloText.text = it }
    }
}
