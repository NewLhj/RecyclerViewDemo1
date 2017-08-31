package com.example.administrator.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		List<News>  newses=new ArrayList<News>();
        newses.add(new News(1,"qq"));
        newses.add(new News(3,"qq"));
        newses.add(new News(1,"qq"));
        newses.add(new News(2,"qq"));
        newses.add(new News(2,"qq"));
        newses.add(new News(2,"qq"));
        newses.add(new News(1,"qq"));
        newses.add(new News(2,"qq"));
        newses.add(new News(2,"qq"));
        newses.add(new News(2,"qq"));

        RecyclerView viewById = (RecyclerView) findViewById(R.id.cable_recyclerview);
        viewById.setLayoutManager(new LinearLayoutManager(this));
        viewById.setAdapter(new NewsAdapter(MainActivity.this,newses));
    }
}
