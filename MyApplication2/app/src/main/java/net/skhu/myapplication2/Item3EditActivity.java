package net.skhu.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Item3EditActivity extends AppCompatActivity {

    public static final int REQUEST_EDIT = 1; // 데이터 수정 요청 코드
    public static final int REQUEST_CREATE = 2; // 데이터 생성 요청 코드

    EditText editText_title; // 제목을 수정할 EditText
    EditText editText_date;  // 날짜를 수정할 EditText
    Item3 item; // 수정할 EditText 객체

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item3_edit);

        editText_title = findViewById(R.id.editText_title);
        editText_date = findViewById(R.id.editText_date);

        // 수정할 Item2 객체를 Intent에서 꺼낸다.
        item = (Item3) getIntent().getSerializableExtra("item"); // 복구

        // 수정할 내용을 EditText에 채운다.
        editText_title.setText(item.getTitle());
        editText_date.setText(item.getDateFormatted());
    }

    // 저장 버튼 클릭
    public void btnSave_clicked(View view) {
        // EditText에 입력된 내용을 item 객체에 채운다.
        item.setTitle(editText_title.getText().toString());
        item.setDateFormatted(editText_date.getText().toString());

        // 내용이 수정된 item 객체를, intent 객체에 넣어서 리턴한다.
        Intent intent = new Intent();
        intent.putExtra("item", item);
        setResult(Activity.RESULT_OK, intent); // RESULT_OK: 작업 완료
        finish(); // 이 액티비티를 종료하고, 이전 액티비티로 돌아간다
    }

    // 취소 버튼 클릭
    public void btnCancel_clicked(View view) {
        Intent intent = new Intent();
        setResult(Activity.RESULT_CANCELED, intent); // / RESULT_CANCELED: 작업 실패
        finish();
    }
}
