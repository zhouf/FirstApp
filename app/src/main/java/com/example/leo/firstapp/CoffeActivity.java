package com.example.leo.firstapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class CoffeActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffe);
        display();
    }

    public void increment(View btn){
        if(quantity==30){
            return;
        }
        quantity++;
        display();
    }
    public void decrement(View btn){
        if(quantity==0) {
            return;
        }
        quantity--;
        display();
    }

    public void submitOrder(View btn){
        CheckBox hasWhippedCream = (CheckBox)findViewById(R.id.whipped_cream_checkbox);
        CheckBox chocolate = (CheckBox)findViewById(R.id.chocolate_checkbox);
        EditText txtName = (EditText)findViewById(R.id.text_name);
        String userName = txtName.getText().toString();

        int price = calculatePrice(hasWhippedCream.isChecked(),chocolate.isChecked());
        String msg = createOrderSummary(userName,price,hasWhippedCream.isChecked(),chocolate.isChecked());

        displayMessage(msg);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order Coffee for " + userName);
        intent.putExtra(Intent.EXTRA_TEXT, msg);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void display(){
        TextView tvQuantity = (TextView)findViewById(R.id.txt_quantity);
        tvQuantity.setText("" + quantity);
    }

    private void displayMessage(String msg){
        TextView tvMsg = (TextView)findViewById(R.id.order_summary_text_view);
        tvMsg.setText(msg);
    }

    private int calculatePrice(boolean addWhippedCream,boolean addChocolate){
        int basePrice = 5;
        if(addWhippedCream){
            basePrice += 1;
        }
        if(addChocolate){
            basePrice += 2;
        }
        return quantity * basePrice;
    }

    private String createOrderSummary(String userName,int price,boolean addWhippedCream,boolean addChocolate){
        String priceMessage = "Name: " + userName;
        priceMessage += "\nAdd Whipped Cream:" + addWhippedCream;
        priceMessage += "\nAdd Chocolate:" + addChocolate;
        priceMessage += "\nQuantity:" + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

}
