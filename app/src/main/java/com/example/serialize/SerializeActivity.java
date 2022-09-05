package com.example.serialize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class SerializeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serialize);
        Button serialize_button = findViewById(R.id.serialize_button);
        serialize_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //这里我们创建了一个Person的实例,然后直接将它传入到了putExtra()方法中,
                //由于Person类实现了Serializable接口,所以才可以这样写
                Person person = new Person();
                person.setName("Tom");
                person.setAge(20);
                Intent intent = new Intent(SerializeActivity.this, SerializeToActivity.class);
                intent.putExtra("person_data",person);
                startActivity(intent);
            }
        });
    }
}