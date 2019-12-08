package net.skhu;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecyclerView2Adapter extends RecyclerView.Adapter<RecyclerView2Adapter.ViewHolder> {

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
        TextView textView1, textView2;
        CheckBox checkBox;

        public ViewHolder(View view) {
            super(view); // RecyclerView.ViewHolder 부모클래스 생성자 호출
            textView1 = view.findViewById(R.id.textView1);
            textView2 = view.findViewById(R.id.textView2);
            checkBox = view.findViewById(R.id.checkBox);
            // button.setOnClickLIstener(new View.OnClickListener() { @Override ~ onClick)
            // setOnClickListener -> @Override onClick
            // 데이터항목 뷰 객체에 리스너 객체를 등록
            textView1.setOnClickListener(this);
            this.checkBox.setOnCheckedChangeListener(this);
        }

        public void setData() {
            // 인스턴스 변수를 사용해야하므로 ViewHolder 클래스는 non-static하여야 한다.
            Item2 item = arrayList.get(getAdapterPosition());
            textView1.setText(item.getTitle());
            textView2.setText(item.getDateFormatted());
            checkBox.setChecked(item.isChecked());
        }

        @Override
        public void onClick(View view) {
            Item2 item = arrayList.get(getAdapterPosition());
            String s = String.format("index: %d,  title: %s", getAdapterPosition(), item.getTitle());
            Toast.makeText(view.getContext(), s, Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Item2 item = arrayList.get(super.getAdapterPosition());
            item.setChecked(isChecked);
            //체크박스의 체크상태가 변경될 때마다 이 코드가 실행된다.
            boolean invalidateMenu = false;
            if (isChecked) invalidateMenu = (++checkedItemCount == 1);
            else invalidateMenu = (--checkedItemCount == 0);
            if (invalidateMenu)
                // 액티비티의 메뉴가 다시 생성되도록 강제한다.
                // 액티비티의 메뉴가 다시 생성될 때 액티비티의 onCreateOptionsMenu 메소드가 자동으로 호출된다.
                ((Activity) textView1.getContext()).invalidateOptionsMenu();
        }
    }

    LayoutInflater layoutInflater;
    ArrayList<Item2> arrayList;
    int checkedItemCount = 0;


    public RecyclerView2Adapter(Context context, ArrayList<Item2> arrayList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.arrayList = arrayList;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = layoutInflater.inflate(R.layout.item2a, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int index) {
        viewHolder.setData();
    }
}
