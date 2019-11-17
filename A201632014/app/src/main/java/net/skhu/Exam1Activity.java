package net.skhu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Exam1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam1);

        Button b = (Button) findViewById(R.id.button);
        View.OnClickListener li = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText)findViewById(R.id.editText);
                TextView textView = (TextView)findViewById(R.id.textView);
                CharSequence s = editText.getText();
                editText.setText(textView.getText());
                textView.setText(s);
            }
        };
        b.setOnClickListener(li);
    }
}
