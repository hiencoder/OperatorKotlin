package com.example.hiennv.operator

import android.app.AlertDialog
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

class AlertDialogActivity : AppCompatActivity() {
    @BindView(R.id.btn_show_dialog)
    lateinit var btnShowDialog : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)
        ButterKnife.bind(this)
    }

    @OnClick(R.id.btn_show_dialog)
    fun onClick(v: View){
        when(v.id){
            R.id.btn_show_dialog -> showAlertDialog("Test dialog")
        }
    }

    private fun showAlertDialog(message: String) {
        var dialog = AlertDialog.Builder(this)
                .setTitle("Tilte")
                .setMessage(message)
                .setNegativeButton("No", DialogInterface.OnClickListener{
                    dialogInterface, i -> dialogInterface.cancel()
                })
                .setPositiveButton("Yes",DialogInterface.OnClickListener { dialogInterface, i ->
                    handleOk()
                }).create()
        dialog.show()
    }

    private fun handleOk() {
        Toast.makeText(this,"Ok",Toast.LENGTH_LONG).show()
    }


}
