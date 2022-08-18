package com.example.myapplication.activityresultsapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.R;

public class BActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bactivity);

        String askMsg = getIntent().getStringExtra("message");
        Toast.makeText(this, askMsg, Toast.LENGTH_SHORT).show();

        findViewById(R.id.b_button).setOnClickListener(View -> {
            //回传数据
            Intent intent = new Intent();
            intent.putExtra("message", "答:我吃过了");
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}