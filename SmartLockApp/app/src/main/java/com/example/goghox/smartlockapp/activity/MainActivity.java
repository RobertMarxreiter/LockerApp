package com.example.goghox.smartlockapp.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.goghox.smartlockapp.AppConstant;
import com.example.goghox.smartlockapp.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout llCombo1;
    private ImageView ivShowPic1;
    private TextView tvMoney1;
    private RadioButton rbCombo1;
    private TextView tvDescription1;
    private RadioGroup rgCombo;
    private LinearLayout llCombo2;
    private ImageView ivShowPic3;
    private ImageView ivShowPic2;
    private TextView tvMoney2;
    private RadioButton rbCombo2;
    private TextView tvDescription2;
    private LinearLayout llCombo3;
    private TextView tvMoney3;
    private RadioButton rbCombo3;
    private TextView tvDescription3;

    /* arg */
    private int selectComboIndex = 0;
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        
        // reset the RadioButton status
        rbCombo1.setChecked(false);
        rbCombo2.setChecked(false);
        rbCombo3.setChecked(false);

        Log.i(TAG, "onRestart: reset the radioButton status");
    }

    private void initData() {
        // require server to get the picture

    }

    private void initView() {
        rgCombo = (RadioGroup) findViewById(R.id.rg_combo);

        /* Combo 1 */
        llCombo1 = (LinearLayout) findViewById(R.id.ll_combo_1);
        ivShowPic1 = (ImageView) findViewById(R.id.iv_show_pic_1);
        tvMoney1 = (TextView) findViewById(R.id.tv_money_1);
        rbCombo1 = (RadioButton) findViewById(R.id.rb_combo_1);
        tvDescription1 = (TextView) findViewById(R.id.tv_description_1);

        /* Combo 2 */
        llCombo2 = (LinearLayout) findViewById(R.id.ll_combo_2);
        ivShowPic2 = (ImageView) findViewById(R.id.iv_show_pic_2);
        tvMoney2 = (TextView) findViewById(R.id.tv_money_2);
        rbCombo2 = (RadioButton) findViewById(R.id.rb_combo_2);
        tvDescription2 = (TextView) findViewById(R.id.tv_description_2);
        
        /* Combo 3 */
        llCombo3 = (LinearLayout) findViewById(R.id.ll_combo_3);
        ivShowPic3 = (ImageView) findViewById(R.id.iv_show_pic_3);
        tvMoney3 = (TextView) findViewById(R.id.tv_money_3);
        rbCombo3 = (RadioButton) findViewById(R.id.rb_combo_3);
        tvDescription3 = (TextView) findViewById(R.id.tv_description_3);

        // set click enable
        llCombo1.setOnClickListener(this);
        llCombo2.setOnClickListener(this);
        llCombo3.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_combo_1:
                rbCombo1.setChecked(true);
                selectComboIndex = AppConstant.COMBO_1;
                break;
            case R.id.ll_combo_2:
                rbCombo2.setChecked(true);
                selectComboIndex = AppConstant.COMBO_2;
                break;
            case R.id.ll_combo_3:
                rbCombo3.setChecked(true);
            selectComboIndex = AppConstant.COMBO_3;
            break;
        }

        // enter next activity
        Intent intent = new Intent(this, SelTimeActivity.class);
        intent.putExtra(AppConstant.COMBO_TAG, selectComboIndex);
        startActivity(intent);
    }


    private void setPicture(int comboIndex, Drawable pic){
        switch (comboIndex){
            case AppConstant.COMBO_1:
                ivShowPic1.setImageDrawable(pic);
                break;
            case AppConstant.COMBO_2:
                ivShowPic2.setImageDrawable(pic);
                break;
            case AppConstant.COMBO_3:
                ivShowPic3.setImageDrawable(pic);
                break;
        }
    }

    private void getPictureFromServer(){
        
    }
}

