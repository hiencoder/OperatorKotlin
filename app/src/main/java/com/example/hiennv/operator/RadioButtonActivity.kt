package com.example.hiennv.operator

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import butterknife.BindView
import butterknife.ButterKnife

class RadioButtonActivity : AppCompatActivity() {
    val TAG : String = RadioButtonActivity::class.java.simpleName
    @BindView(R.id.ll_main)
    lateinit var llMain: LinearLayout
    val array = arrayOf("Option 1","Option 2","Option 3")
    lateinit var options: List<String>
    //val options = arrayListOf(array)
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button)
        ButterKnife.bind(this)
        options = array.toList()

        val radioGroup = RadioGroup(this)
        for (i in options.indices){
            val rbItem = RadioButton(this)
            rbItem.text = options.get(i)
            rbItem.id = View.generateViewId()
            rbItem.tag = rbItem.text
            radioGroup.addView(rbItem)
        }

        radioGroup.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
                Log.i(TAG,"Id: " + p1)
                var rdItem: RadioButton = p0!!.findViewById(p1)
                Log.i(TAG,"Text: " + rdItem.text)
            }

        })
        llMain.addView(radioGroup)
    }


}
