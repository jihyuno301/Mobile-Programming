package net.skhu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SwapStringActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swap_string);

        Button b = (Button)findViewById(R.id.button );
        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                EditText editText1 = (EditText)findViewById(R.id.editText1);
                EditText editText2 = (EditText)findViewById(R.id.editText2);
                // return Editable Interface
                // Editable implements CharSequence
                CharSequence text1 = editText1.getText();
                CharSequence text2 = editText2.getText();

                editText1.setText(text2);
                editText2.setText(text1);
            }
        };
        b.setOnClickListener(listener);
    }
}
