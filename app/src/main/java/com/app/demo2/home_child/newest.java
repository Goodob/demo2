package com.app.demo2.home_child;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.demo2.R;
import com.app.demo2.entity.Message;
import com.app.demo2.menu_child.menuInformation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */
public class newest extends FragmentActivity{

    private ListView lv_newest;

    private List<Message> messageList = new ArrayList<Message>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_newest);

        for (int i = 0; i < 10; i++) {
            Message m = new Message();
            m.setMenuName("沙拉");
            m.setImg("R.mipmap.aa");

            messageList.add(m);//上周
            //定义一个界面与数据的混合体,一个item代表一行记录

        }
        lv_newest = (ListView)findViewById(R.id.newsList);

        /**/
        lv_newest.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return messageList.size();
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = null;
                if(convertView==null){
                    Log.i("info:", "没有缓存，重新生成"+position);
                    LayoutInflater inflater = newest.this.getLayoutInflater();
                    //因为getView()返回的对象，adapter会自动赋给ListView
                    view = inflater.inflate(R.layout.item_newest, null);
                }else{
                    Log.i("info:", "有缓存，不需要重新生成"+position);
                    view = convertView;
                }
                Message m = messageList.get(position);
                RelativeLayout r = (RelativeLayout) view.findViewById(R.id.list_ra);
               /* Resources resources = getApplicationContext().getResources();
                Drawable btnDrawable = resources.getDrawable(R.mipmap.aa);

                r.setBackgroundDrawable(btnDrawable);*/
                /*设置listview菜名*/
                TextView t = (TextView) view.findViewById(R.id.list_i_txt);
                t.setText(m.getMenuName()+(position+1));

                return view;
            }
        });
        lv_newest.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(newest.this,new menuInformation().getClass());
                newest.this.startActivity(intent);
            }
        });

        
    }
}
