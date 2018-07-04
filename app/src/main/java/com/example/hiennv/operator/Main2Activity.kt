package com.example.hiennv.operator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.Unbinder

class Main2Activity : AppCompatActivity() {
    @BindView(R.id.ll_main)
    lateinit var llMain : LinearLayout

    lateinit var unbinder: Unbinder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        unbinder = ButterKnife.bind(this)
        val button : Button = Button(this)
        button.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT)
        button.text = "Button"
        llMain.addView(button)
    }

    override fun onDestroy() {
        super.onDestroy()
        unbinder.unbind()
    }
}
