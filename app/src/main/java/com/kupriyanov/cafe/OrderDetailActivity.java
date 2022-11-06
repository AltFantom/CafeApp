package com.kupriyanov.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderDetailActivity extends AppCompatActivity {
    private static final String EXTRA_USER_NAME = "userName";
    private static final String EXTRA_ADDITIVES = "additives";
    private static final String EXTRA_DRINK = "drink";
    private static final String EXTRA_TYPE_OF_DRINK = "typeOFfDrink";

    private TextView textViewName;
    private TextView textViewDrink;
    private TextView textViewOrderDetailTypeOfDrink;
    private TextView textViewOrderDetailAdditives;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);
        initViews();
        setTextFromIntent();
    }

    private void setTextFromIntent() {
        Intent intent = getIntent();
        String userName = intent.getStringExtra(EXTRA_USER_NAME);
        textViewName.setText(userName);
        String additives = intent.getStringExtra(EXTRA_ADDITIVES);
        textViewOrderDetailAdditives.setText(additives);
        String drink = intent.getStringExtra(EXTRA_DRINK);
        textViewDrink.setText(drink);
        String typeOfDrink = intent.getStringExtra(EXTRA_TYPE_OF_DRINK);
        textViewOrderDetailTypeOfDrink.setText(typeOfDrink);
    }

    public static Intent newIntent(
            Context context,
            String userName,
            String additives,
            String drink,
            String typeOfDrink){
        Intent intent = new Intent(context, OrderDetailActivity.class);
        intent.putExtra(EXTRA_USER_NAME, userName)
                .putExtra(EXTRA_ADDITIVES, additives)
                .putExtra(EXTRA_TYPE_OF_DRINK, typeOfDrink)
                .putExtra(EXTRA_DRINK, drink);
        return intent;
    }
    private void initViews() {
        textViewName = findViewById(R.id.textViewName);
        textViewDrink = findViewById(R.id.textViewDrink);
        textViewOrderDetailTypeOfDrink = findViewById(R.id.textViewOrderDetailTypeOfDrink);
        textViewOrderDetailAdditives = findViewById(R.id.textViewOrderDetailAdditives);
    }
}