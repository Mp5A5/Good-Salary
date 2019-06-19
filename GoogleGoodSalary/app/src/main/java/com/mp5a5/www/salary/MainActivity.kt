package com.mp5a5.www.salary

import android.content.Intent
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.mp5a5.www.salary.annotation.BindId
import com.mp5a5.www.salary.annotation.OnClick

@BindId(R.layout.activity_main)
class MainActivity : BaseActivity() {


    @BindId(R.id.tv)
    private lateinit var tv: TextView

    @BindId(R.id.tv1)
    private lateinit var tv1: TextView

    /*override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      //setContentView(R.layout.activity_main)
      BindIdApi.bindId2(this)
      OnClickApi.bindOnClick(this)
      tv.text = "我是注解测试"
      tv1.text = "我是注解测试2"
    }*/


    override fun initView() {
        tv.text = "我是注解测试"
        tv1.text = "我是注解测试2"
    }


    @OnClick(R.id.tv, R.id.tv1)
    private fun onClick(view: View) {
        when (view.id) {
            R.id.tv -> Toast.makeText(this, tv.text.toString(), Toast.LENGTH_SHORT).show()
            R.id.tv1 -> startActivity(Intent(this, TestActivity::class.java))
        }
    }
}
