package com.example.leo.firstapp;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity implements Runnable {
    private static final String TAG = "Main";
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                Log.i("handle","handleMessage");
                Log.i("handle","msg.what=" + msg.what);
                String getStr = (String) msg.obj;
                Log.i("handle","getStr=" + getStr);

                super.handleMessage(msg);
            }
        };
    }

    public void onClick(View btn){
        Log.i("main","onClicked.....");
        Thread t = new Thread(this);
        t.start();

    }

    public void counter(View btn){
        Intent counterIntent = new Intent(this,CounterActivity.class);
        startActivity(counterIntent);
    }

    public void openCoffee(View btn){
        Intent intent = new Intent(this,CoffeActivity.class);
        startActivity(intent);
    }

    public void openBirthday(View btn){
        Intent intent = new Intent(this,BirthdayActivity.class);
        startActivity(intent);
    }

    public void open(View btn){
        Log.d(TAG, "open() called with: btn = [" + btn + "]");
        Log.i(TAG, "open: ");
        Intent intent = new Intent(this,MyListActivity.class);
        startActivity(intent);
    }


    @Override
    public void run() {

        Log.i("run","run....");
        StringBuilder sb = new StringBuilder();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.1.104/study","root","mysql");
            Log.i("run","conn=" + conn);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM SUBJECT");

            while(rs.next()){
                sb.append(rs.getString("subjectname"));
                sb.append(",");
            }

            rs.close();
            stmt.close();
            conn.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Message msg = handler.obtainMessage();
        msg.what = 3;
        msg.obj = sb.toString();
        handler.sendMessage(msg);

    }
}
