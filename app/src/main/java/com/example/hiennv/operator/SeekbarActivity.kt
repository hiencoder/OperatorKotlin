package com.example.hiennv.operator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife

class SeekbarActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener{
    // 0 -> 100 => set value progress (step 1) 100/100
    // 10 -> 160 => set value (step 5) 160/5 = 32
    override fun onStartTrackingTouch(seekBar: SeekBar?) {
        tvStatus.text = "Start tracking"
        when(seekBar!!.id){
            R.id.sb_custom -> tvValue.text = VALUE_START.toString()
            R.id.sb_sample -> tvValue.text = "0"
        }
    }

    override fun onStopTrackingTouch(p0: SeekBar?) {
        tvStatus.text = "Stop tracking"
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, p2: Boolean) {
        tvStatus.text = "Progress change"
        when(seekBar!!.id){
            R.id.sb_sample -> tvValue.text = progress.toString()
            R.id.sb_custom -> {
                var progressCustom = VALUE_START + (progress.times(STEP))
                tvValue.text = progressCustom.toString()
            }
        }

    }

    //    https://github.com/vekexasia/android-edittext-validator
    @BindView(R.id.tv_status)
    lateinit var tvStatus : TextView
    @BindView(R.id.tv_value)
    lateinit var tvValue: TextView
    @BindView(R.id.sb_sample)
    lateinit var sbSample: SeekBar
    @BindView(R.id.sb_custom)
    lateinit var sbCustom: SeekBar

    val STEP: Int = 5
    val VALUE_START: Int = 10
    val VALUE_MAX: Int = 160


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seekbar)
        ButterKnife.bind(this)
        sbCustom.max = (VALUE_MAX - VALUE_START)/STEP
        sbSample.setOnSeekBarChangeListener(this)
        sbCustom.setOnSeekBarChangeListener(this)
    }


}
