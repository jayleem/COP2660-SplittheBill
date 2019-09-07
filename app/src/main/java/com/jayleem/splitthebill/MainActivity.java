package com.jayleem.splitthebill;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.menuBtn);
        // Register the onClick listener with the implementation above
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Launch the HomeScreen activity
               startActivity(new Intent(MainActivity.this, HomeScreen.class));
            }
        });
    }
}