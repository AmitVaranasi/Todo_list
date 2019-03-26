package com.example.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.todo.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private EditText itmET;
    private Button btn;
    private ListView ltsvw;
    private ArrayList<String> items;
    private ArrayAdapter<String > adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itmET = (EditText)findViewById(R.id.item_edit_text);
        btn = (Button) findViewById(R.id.add_btn);
        ltsvw = (ListView) findViewById(R.id.items_List);
        items = com.example.todolist.FileHelper.read_data(this);
        adapter = new ArrayAdapter<String>(this ,android.R.layout.simple_list_item_1,items);
        ltsvw.setAdapter(adapter);

        btn.setOnClickListener(this);
        ltsvw.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_btn:
                String item_entered = itmET.getText().toString();
                adapter.add(item_entered);
                itmET.setText("");
                com.example.todolist.FileHelper.write_data(items,this);
                Toast.makeText(this, "item added", Toast.LENGTH_SHORT).show();

        }
    }




    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        items.remove(position);
        adapter.notifyDataSetChanged();
        com.example.todolist.FileHelper.write_data(items,this);
        Toast.makeText(this, "items deleted", Toast.LENGTH_SHORT).show();

    }
};

        




