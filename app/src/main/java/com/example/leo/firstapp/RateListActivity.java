package com.example.leo.firstapp;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;

public class RateListActivity extends ListActivity implements AdapterView.OnItemClickListener,AdapterView.OnItemSelectedListener {

    private String TAG = "List";

    private String[] list_data = {"one","two","three","four"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_rate_list);

        List<String> data = new ArrayList<String>();
        for (int i = 10; i < 60 ; i++) {
            data.add("Data" + i);
        }

        ListAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        setListAdapter(adapter);
        this.getListView().setOnItemClickListener(this);
        this.getListView().setOnItemSelectedListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Log.i(TAG, "onItemClick: adapterView=" + adapterView);
        Log.i(TAG, "onItemClick: view=" + view);
        Log.i(TAG, "onItemClick: i=" + i);
        Log.i(TAG, "onItemClick: l=" + l);

        String str = (String) adapterView.getItemAtPosition(i);
        Log.i(TAG, "onItemClick: str=" + str);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
