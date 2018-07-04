package com.example.hiennv.operator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputLayout
import android.text.Editable
import android.text.InputFilter
import android.text.Spanned
import android.text.TextWatcher
import android.util.Log
import android.view.ViewGroup
import android.widget.*
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnEditorAction

class EditTextActivity : AppCompatActivity() {
    val MAX_LENGTH: Int = 6
    val TAG: String = EditTextActivity::class.java.simpleName
    @BindView(R.id.ll_main)
    lateinit var llMain: LinearLayout
    @BindView(R.id.tv_content)
    lateinit var tvContent: TextView
    @BindView(R.id.til_data)
    lateinit var tilData: TextInputLayout
    @BindView(R.id.et_data)
    lateinit var etData: EditText

    lateinit var filter: InputFilter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text)
        ButterKnife.bind(this)
        val etSample = EditText(this)
        val tilSample = TextInputLayout(this)
        tilSample.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        etSample.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        etSample.hint = "Sample EditText"

        etSample.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                Log.d(TAG, "AfterTextChanged: " + p0.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d(TAG, "BeforeTextChanged: " + p0 + "\np1: $p1" +
                        "\nP2: $p2" + "\nP3: $p3")
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d(TAG, "OnTextChanged: " + p0 + "\np1: $p1" +
                        "\nP2: $p2" + "\nP3: $p3")
                tvContent.text = p0

            }

        })


        //etSample.filters = arrayOf(filter, InputFilter.LengthFilter(7))
        tilSample.addView(etSample)
        llMain.addView(tilSample)


        filter = InputFilter { source, start, end, dest, dstart, dend ->
            handleFilter(source, start, end, dest, dstart, dend)
        }
        etData.filters = arrayOf(filter,InputFilter.LengthFilter(6))
    }


    /*
        source: Charsequence

     */
    fun handleFilter(source: CharSequence, start: Int, end: Int, dest: Spanned, dstart: Int, dend: Int): CharSequence {
        Log.i(TAG, "HandleFilter: " + source +
                "\nStart: " + start + "\nEnd: " + end + "\nDest: " + dest.toString() + "\nDStart: " + dstart + "\nDEnd: " + dend)
/*
        if (source.length <= MAX_LENGTH - 1){
            return source
        }else{
            return source.subSequence(0,MAX_LENGTH)
        }
*/
        if (source.length > MAX_LENGTH) {
            //tilData.error = "Error"
            etData.error = "Error"
            //return source.subSequence(0,MAX_LENGTH)
        }
        return source
    }
}
