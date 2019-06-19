package com.mp5a5.www.salary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.mp5a5.www.module_annotation.FindId;
import com.mp5a5.www.module_annotation.OnClick;
import com.mp5a5.www.module_api.TAHelper;

/**
 * @author ：mp5a5 on 2019-05-21 17：22
 * @describe ：
 * @email ：wwb199055@126.com
 */
@FindId(R.layout.activity_main)
public class TestActivity extends AppCompatActivity {

    @FindId(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAHelper.inject(this);
        if (tv != null) {
            tv.setText("hahaha,how are you?");
        }
    }

    @OnClick({R.id.tv})
    void clickTest(View view) {
        switch (view.getId()) {
            case R.id.tv:
                Toast.makeText(TestActivity.this, "test click", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
