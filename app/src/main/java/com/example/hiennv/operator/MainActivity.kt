package com.example.hiennv.operator

import android.os.Binder
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.view.View
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import butterknife.Unbinder
import com.example.hiennv.operator.R.id.cl_main
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    private fun handleToast() {
        Toast.makeText(this, "Hello Kotlin", Toast.LENGTH_SHORT).show()
    }

    @BindView(R.id.tv_hello)
    lateinit var tvHello: TextView

    lateinit var unBinder: Unbinder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        unBinder = ButterKnife.bind(this)
        val tvTextDynamic = TextView(this);
        tvTextDynamic.text = "Text dynamic"
        cl_main.addView(tvTextDynamic)
        tvHello = findViewById(R.id.tv_hello) as TextView
        tvHello.text = "Hello Kotlin"
        tvTextDynamic.setOnClickListener {
            handleToast()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        unBinder.unbind()
    }
    @OnClick(R.id.tv_hello)
    fun onClick(v : View?){
        when(v!!.id){
            R.id.tv_hello -> handleToast()
        }
    }
}
