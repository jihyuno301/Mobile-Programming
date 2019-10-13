package net.skhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // inflation : XML 리소스 파일의 내용대로 자동으로 자바 객체를 생성해주는 것을 말한다.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_spinners) {
            Toast.makeText(this, "move to spinners test", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, SpinnersActivity.class);
            startActivity(intent);
            return true;
        } else if(id == R.id.action_swap) {
            Toast.makeText(this, "move to swap string test", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, SwapStringActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_signUp) {
            Intent intent = new Intent(MainActivity.this, SignupActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_memo) {
            Intent intent = new Intent(MainActivity.this, MemoActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
