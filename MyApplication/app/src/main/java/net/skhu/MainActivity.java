package net.skhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 버튼을 눌렀을 때 SpinnersActivity로 가도록
        View.OnClickListener listener1 = new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, SpinnersActivity.class);
                startActivity(intent);
            }
        };
        Button button1= (Button)findViewById(R.id.button1);
        button1.setOnClickListener(listener1);
    }
}
