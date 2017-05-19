package com.example.leo.firstapp;

import android.app.ListActivity;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MyListActivity extends ListActivity implements AdapterView.OnItemClickListener {

    private String TAG = "mylist";
    Handler handler;
    private ArrayList<HashMap<String, String>> listItems; // 存放文字、图片信息
    private SimpleAdapter listItemAdapter; // 适配器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_my_list);

        initListView();
        this.setListAdapter(listItemAdapter);
        this.getListView().setOnItemClickListener(this);

    }

    private void initListView() {
        listItems = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 10; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("ItemTitle", "Rate： " + i); // 标题文字
            map.put("ItemDetail", "detail" + i); // 详情描述
            listItems.add(map);
        }
        // 生成适配器的Item和动态数组对应的元素
        listItemAdapter = new SimpleAdapter(this, listItems, // listItems数据源
                R.layout.list_item, // ListItem的XML布局实现
                new String[] { "ItemTitle", "ItemDetail" },
                new int[] { R.id.itemTitle, R.id.itemDetail }
        );
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.i(TAG, "onItemClick: adapterView:" + adapterView);
        Log.i(TAG, "onItemClick: view:" + view);
        Log.i(TAG, "onItemClick: i:" + i);
        Log.i(TAG, "onItemClick: l:" + l);

        HashMap<String, String> map = (HashMap<String, String>) adapterView.getItemAtPosition(i);
        Log.i(TAG, "title: " + map.get("ItemTitle"));
        Log.i(TAG, "detail: " + map.get("ItemDetail"));

        Log.i(TAG, "onItemClick: id=" + adapterView.getItemIdAtPosition(i));
    }
}
