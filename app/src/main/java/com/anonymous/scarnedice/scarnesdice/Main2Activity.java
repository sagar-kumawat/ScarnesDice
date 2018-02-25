package com.anonymous.scarnedice.scarnesdice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }public void click(View view){
        Intent intent = new Intent(Main2Activity.this,User.class);
        startActivity(intent);

    }public void clickHere(View view){
        Intent intent = new Intent(Main2Activity.this,comp.class);
        startActivity(intent);

    }
}
