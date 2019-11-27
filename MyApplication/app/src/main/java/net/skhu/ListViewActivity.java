package net.skhu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        arrayList= new ArrayList<>();
        arrayList.add("one");
        arrayList.add("two");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

        Button  b = (Button)findViewById(R.id.btnAdd);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText e = (EditText)findViewById(R.id.editText);
                CharSequence s = e.getText();
                e.setText("");
                arrayList.add(s.toString());
                adapter.notifyDataSetChanged();
            }
        });
    }
}
