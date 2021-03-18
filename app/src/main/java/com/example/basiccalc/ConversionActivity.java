package com.example.basiccalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConversionActivity extends AppCompatActivity {
Button backbutton,covertbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);
         backbutton = findViewById(R.id.btnback);
         covertbutton = findViewById(R.id.btncovert);


         // back to calculator

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConversionActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
