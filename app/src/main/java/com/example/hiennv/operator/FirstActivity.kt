package com.example.hiennv.operator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

class FirstActivity : AppCompatActivity() {
    @BindView(R.id.btn_open_second)
    lateinit var btnOpenSecond: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.btn_open_second)
    fun onClick(v: View){
        var intent = Intent(this,SecondActivity::class.java)
        startActivity(intent)
    }
}
