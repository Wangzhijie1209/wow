package com.example.myapplication.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initFruits();//初始化水果数据
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        recyclerView.setLayoutManager(linearLayoutManager);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        FruitAdapter fruitAdapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(fruitAdapter);
    }

    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            Fruit kiwifruit = new Fruit("kiwifruit", R.drawable.kiwifruit);
            fruitList.add(kiwifruit);
            Fruit litchi = new Fruit("litchi", R.drawable.litchi);
            fruitList.add(litchi);
            Fruit lemon = new Fruit("lemon", R.drawable.lemon);
            fruitList.add(lemon);
            Fruit mango = new Fruit("mango", R.drawable.mango);
            fruitList.add(mango);
            Fruit mangosteen = new Fruit("mangosteen", R.drawable.mangosteen);
            fruitList.add(mangosteen);
            Fruit persimmon = new Fruit("persimmon", R.drawable.persimmon);
            fruitList.add(persimmon);
            Fruit strawberry = new Fruit("strawberry", R.drawable.strawberry);
            fruitList.add(strawberry);
            Fruit watermelon = new Fruit("watermelon", R.drawable.watermelon);
            fruitList.add(watermelon);
            Fruit waxapple = new Fruit("waxapple", R.drawable.waxapple);
            fruitList.add(waxapple);
        }
    }
}