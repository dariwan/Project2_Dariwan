package com.example.project8_dariwan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button internal, exsternal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        internal = findViewById(R.id.btnInternal);
        exsternal = findViewById(R.id.btnExternal);

        internal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, InternalStorage.class);
                startActivity(i);
            }
        });

        exsternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(MainActivity.this, ExternalStorage.class);
                startActivity(j);
            }
        });

    }
}