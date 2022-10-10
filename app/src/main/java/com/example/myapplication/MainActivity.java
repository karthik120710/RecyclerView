package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements recyclerViewAdapter.ItemClickInterface {

    recyclerViewAdapter recyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> name=new ArrayList<>();
        name.add("Python");
        name.add("Java");
        name.add("C++");
        name.add("Flutter");

        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter=new recyclerViewAdapter(this,name,this);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void OnItemClick(View view, int position) {
        Snackbar.make(view,"Clicked "+recyclerViewAdapter.getItem(position),
                Snackbar.LENGTH_LONG).show();
    }
}