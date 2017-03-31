package com.app.demo2;


import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends FragmentActivity {

    private FragmentManager manager;
    private FragmentTransaction trans;
    private RadioGroup rg; /*底部菜单选项卡*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();

        trans = manager.beginTransaction();
        fra_home one = new fra_home();
        trans.add(R.id.frame, one, "frag");
        trans.commit();


        rg = (RadioGroup)findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.r1:
                        trans = manager.beginTransaction();
                        trans.replace(R.id.frame, new fra_home(), "frag");
                        //trans.addToBackStack("back");
                        trans.commit();
                        break;
                    case R.id.r2:
                        trans = manager.beginTransaction();
                        trans.replace(R.id.frame, new fra_menu(), "frag");
                        //trans.addToBackStack("back");
                        trans.commit();
                        break;
                    case R.id.r3:
                        trans = manager.beginTransaction();
                        trans.replace(R.id.frame, new fra_friends(), "frag");
                        //trans.addToBackStack("back");
                        trans.commit();
                        break;
                    case R.id.r4:
                        trans = manager.beginTransaction();
                        trans.replace(R.id.frame, new fra_set(), "frag");
                        //trans.addToBackStack("back");
                        trans.commit();
                        break;
                }
            }
        });
    }
}
