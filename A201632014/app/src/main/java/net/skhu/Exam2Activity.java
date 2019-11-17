package net.skhu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Exam2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam2);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.alert_title);
        builder.setMessage(R.string.alert_content);
        builder.setPositiveButton(R.string.one, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int i) {
                EditText e = (EditText)findViewById(R.id.editText);
                e.setText(R.string.one);
            }

        });
        builder.setNegativeButton(R.string.two, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                EditText e = (EditText)findViewById(R.id.editText);
                e.setText(R.string.two);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void button_clicked(View button) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.alert_title);
        builder.setMessage(R.string.alert_content);
        builder.setPositiveButton(R.string.one, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int i) {
                EditText e = (EditText)findViewById(R.id.editText);
                e.setText(R.string.one);
            }

        });
        builder.setNegativeButton(R.string.two, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                EditText e = (EditText)findViewById(R.id.editText);
                e.setText(R.string.two);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
