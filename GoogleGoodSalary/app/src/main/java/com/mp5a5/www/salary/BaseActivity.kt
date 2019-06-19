package com.mp5a5.www.salary

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mp5a5.www.salary.annotation.BindIdApi
import com.mp5a5.www.salary.annotation.OnClickApi

/**
 * @author ：mp5a5 on 2019-05-21 11：43
 * @describe ：
 * @email ：wwb199055@126.com
 */
open class BaseActivity : AppCompatActivity() {
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    BindIdApi.bindId2(this)
    OnClickApi.bindOnClick(this)
    
    initView()
  }
  
  open fun initView() {
  
  }
  
}
