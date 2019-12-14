package net.skhu.myapplication2;

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

public class Comment1Adapter extends RecyclerView.Adapter<Comment1Adapter.ViewHolder>  {

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, CompoundButton.OnCheckedChangeListener  {
        TextView textView1, textView2, textView3;
        CheckBox checkBox;

        public ViewHolder(View view) {
            super(view);
            textView1 = view.findViewById(R.id.textView_id);
            textView2 = view.findViewById(R.id.textView_content);
            textView3 = view.findViewById(R.id.textView_date);
            checkBox = view.findViewById(R.id.checkBox);
            textView2.setOnClickListener(this);
            this.checkBox.setOnCheckedChangeListener(this);
        }

        public void setData() {
            Item item = arrayList.get(getAdapterPosition());
            textView1.setText(item.getId());
            textView2.setText(item.getComment());
            textView3.setText(item.getDateFormatted());
            checkBox.setChecked(item.isChecked());
        }

        @Override
        public void onClick(View view) {
            Item item = arrayList.get(getAdapterPosition());
            String s = String.format("index: %d, id: %s", getAdapterPosition(), item.getId());
            Toast.makeText(view.getContext(), s, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Item item = arrayList.get(super.getAdapterPosition());
            item.setChecked(isChecked);
            boolean invalidateMenu = false;
            // checkedItemCount가 0->1 / 1->0이 될 때 메뉴가 변경되어야 한다.
            if(isChecked) invalidateMenu = (++checkedItemCount == 1);
            else invalidateMenu = (--checkedItemCount == 0);
            if(invalidateMenu) {
                ((Activity) textView1.getContext()).invalidateOptionsMenu();
            }
        }
    }

    LayoutInflater layoutInflater;
    ArrayList<Item> arrayList;
    int checkedItemCount = 0;

    public Comment1Adapter(Context context, ArrayList<Item> arrayList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.arrayList = arrayList;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = layoutInflater.inflate(R.layout.item1a, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int index) {
        viewHolder.setData();
    }


}
