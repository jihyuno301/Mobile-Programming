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

public class Comment2Adapter extends RecyclerView.Adapter<Comment2Adapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
        TextView textView;
        CheckBox checkBox;

        public ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.textView);
            checkBox = view.findViewById(R.id.checkBox);
            textView.setOnClickListener(this);
            this.checkBox.setOnCheckedChangeListener(this);
        }

        public void setData() {
            Item2 item = arrayList.get(getAdapterPosition());
            textView.setText(item.getComment());
            checkBox.setChecked(item.isChecked());
        }

        @Override
        public void onClick(View view) {
            Item2 item = arrayList.get(getAdapterPosition());
            String s = String.format("index: %d, comment : %s", getAdapterPosition(), item.getComment());
            Toast.makeText(view.getContext(), s, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Item2 item = arrayList.get(super.getAdapterPosition());
            item.setChecked(isChecked);
            boolean invalidateMenu = false;
            if (isChecked) invalidateMenu = (++checkedItemCount == 1);
            else invalidateMenu = (--checkedItemCount == 0);
            if (invalidateMenu) {
                ((Activity) textView.getContext()).invalidateOptionsMenu();
            }
        }
    }

    LayoutInflater layoutInflater;
    ArrayList<Item2> arrayList;
    int checkedItemCount = 0;

    public Comment2Adapter(Context context, ArrayList<Item2> arrayList) {
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


