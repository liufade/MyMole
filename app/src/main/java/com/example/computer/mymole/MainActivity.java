package com.example.computer.mymole;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.computer.mymole.Adapter.VpAdapter;
import com.example.computer.mymole.Base.BaseFragment;
import com.example.computer.mymole.UI.FindFragment;
import com.example.computer.mymole.UI.MessageFragment;
import com.example.computer.mymole.UI.UserFragment;
import com.example.computer.mymole.UI.mainFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ViewPager mViewPager;
    List<BaseFragment> fragments;
    RadioGroup main_radiogroup;
    RadioButton foot_bar_home;
    RadioButton foot_bar_discover;
    RadioButton foot_bar_message;
    RadioButton foot_bar_user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        fragments=new ArrayList<BaseFragment>();
        fragments.add(new mainFragment());
        fragments.add(new FindFragment());
        fragments.add(new MessageFragment());
        fragments.add(new UserFragment());
        VpAdapter vpAdapter=new VpAdapter(getSupportFragmentManager(),fragments);
        mViewPager.setAdapter(vpAdapter);

    }

    private void initView() {
        mViewPager= (ViewPager) findViewById(R.id.mian_viewPager);
        foot_bar_home= (RadioButton) findViewById(R.id.foot_bar_home);
        foot_bar_discover= (RadioButton) findViewById(R.id.foot_bar_discover);
        foot_bar_message= (RadioButton) findViewById(R.id.foot_bar_message);
        foot_bar_user= (RadioButton) findViewById(R.id.foot_bar_user);
        foot_bar_home.setOnClickListener(this);
        foot_bar_discover.setOnClickListener(this);
        foot_bar_user.setOnClickListener(this);
        foot_bar_message.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.foot_bar_home:
                mViewPager.setCurrentItem(0);

                break;
            case R.id.foot_bar_discover:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.foot_bar_message:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.foot_bar_user:
                mViewPager.setCurrentItem(3);
                break;

        }
    }
}
