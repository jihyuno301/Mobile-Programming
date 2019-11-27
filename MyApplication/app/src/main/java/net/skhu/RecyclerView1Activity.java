package net.skhu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerView1Activity extends AppCompatActivity {

    RecyclerView1Adapter recyclerView1Adapter;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view1);

        arrayList = new ArrayList<>();
        arrayList.add("one");
        arrayList.add("two");

        recyclerView1Adapter = new RecyclerView1Adapter(this)
    }
}
