package net.skhu.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Date;

public class Comment1Activity extends AppCompatActivity {

    Comment1Adapter comment1Adapter;
    ArrayList<Item> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment1);

        arrayList = new ArrayList<Item>();
        arrayList.add(new Item("joh755807", "공부하기 싫어", new Date()));
        arrayList.add(new Item("jihyuno301", "졸령", new Date()));

        comment1Adapter = new Comment1Adapter(this, arrayList);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(comment1Adapter);

        Button b = (Button)findViewById(R.id.btnAdd);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText e1 = (EditText)findViewById(R.id.editText1);
                EditText e2 = (EditText)findViewById(R.id.editText2);
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                e1.setText("");
                e2.setText("");
                arrayList.add(new Item(s1,s2, new Date()));
                comment1Adapter.notifyDataSetChanged();
            }
        });
    }
}
