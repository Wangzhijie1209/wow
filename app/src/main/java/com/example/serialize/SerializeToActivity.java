package com.example.serialize;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;

import java.io.Serializable;

public class SerializeToActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serialize_to);
        TextView serialize_TextView = findViewById(R.id.serialize_TextView);
        TextView serialize_TextView2 = findViewById(R.id.serialize_TextView2);
//        Person person = (Person) getIntent().getSerializableExtra("person_data");
        Person person = (Person) getIntent().getParcelableExtra("person_data");

        Log.d("SerializeToActivity", "age= "+person.getAge()+"     name="+person.getName());


    }
}