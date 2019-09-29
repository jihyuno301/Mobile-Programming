package net.skhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    // 메뉴 생성되어야 할 때 저절로 호출되는 메소드
    public boolean onCreateOptionsMenu(Menu menu)  {
        // inflation : XML 리소스 파일의 내용대로 Java 객체를 자동으로 생성해주는 기능
        // R.menu.menu_main : res/menu/menu_main.xml 메뉴 리소스 파일의 id
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    // 메뉴 항목이 클릭되면 저절로 호출되는 메소드
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_signUp) {
            // Context 클래스는 모든 액티비티 클래스의 부모
            Intent intent = new Intent(this, SignupActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_memo) {
            Intent intent = new Intent(this, MemoActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_buttons) {
            Intent intent = new Intent(this, ButtonsActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.action_checkboxes) {
            Intent intent = new Intent(this, CheckboxesActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
