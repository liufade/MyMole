package com.example.computer.mymole;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

import com.example.computer.mymole.Adapter.VpAdapter;
import com.example.computer.mymole.Base.BaseFragment;
import com.example.computer.mymole.UI.FindFragment;
import com.example.computer.mymole.UI.MessageFragment;
import com.example.computer.mymole.UI.PersonalFragment;
import com.example.computer.mymole.UI.mainFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ViewPager mViewPager;
    List<BaseFragment> fragments;
    RadioGroup main_radiogroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager= (ViewPager) findViewById(R.id.mian_viewPager);
        main_radiogroup= (RadioGroup) findViewById(R.id.main_radiogroup);
        main_radiogroup.setOnClickListener(this);
        fragments=new ArrayList<BaseFragment>();
        fragments.add(new mainFragment());
        fragments.add(new FindFragment());
        fragments.add(new MessageFragment());
        fragments.add(new PersonalFragment());
        VpAdapter vpAdapter=new VpAdapter(getSupportFragmentManager(),fragments);
        mViewPager.setAdapter(vpAdapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.foot_bar_home:
                Intent intent=new Intent(this,mainFragment.class);
                
        }
    }
}
