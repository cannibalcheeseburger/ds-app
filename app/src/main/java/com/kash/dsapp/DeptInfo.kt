package com.kash.dsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_dept_info.*

class DeptInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dept_info)
        val bundle: Bundle? = intent.extras
        val name = bundle?.getString("name")
        val des = bundle?.getString("des")
        val image = bundle?.getInt("image")
        ivDept.setImageResource(image!!)
        tvName.text = name
        tvDes.text = des
    }
}
