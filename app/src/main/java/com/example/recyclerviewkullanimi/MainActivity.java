package com.example.recyclerviewkullanimi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<String> olkelerList;
    private RVAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        rv.setLayoutManager(new LinearLayoutManager(this));

        //rv.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL));

        olkelerList = new ArrayList<String>();
        olkelerList.add("Azerbaijan");
        olkelerList.add("England");
        olkelerList.add("Germany");
        olkelerList.add("Russia");
        olkelerList.add("Japan");

        adapter = new RVAdapter(this,olkelerList);

        rv.setAdapter(adapter);
    }
}