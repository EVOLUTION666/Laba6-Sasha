package com.example.laba6.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.laba6.DBHelper;
import com.example.laba6.Model;
import com.example.laba6.R;
import com.example.laba6.adapters.MainAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
 private RecyclerView recyclerView;
 DBHelper dbHelper;
 DBHelper db = new DBHelper(this);
    List<Model>listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        db.addProduct(new Model("Apelsin", "Orange apelsin", 1, 2));
//        db.addProduct(new Model("Potato","red potato", 15,25));
        listView = db.getAllProducts();
        Singleton.getInstance().setItems(listView);
        recyclerView=(RecyclerView)findViewById(R.id.MainAdapter);
        LinearLayoutManager linearLayout=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayout);
        MainAdapter mainAdapter=new MainAdapter(MainActivity.this, listView);
        recyclerView.setAdapter(mainAdapter);

    }
}
