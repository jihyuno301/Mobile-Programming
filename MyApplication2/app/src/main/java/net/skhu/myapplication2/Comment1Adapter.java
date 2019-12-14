package net.skhu.myapplication2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Comment1Adapter extends RecyclerView.Adapter<Comment1Adapter.ViewHolder>  {

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView1, textView2, textView3;

        public ViewHolder(View view) {
            super(view);
            textView1 = view.findViewById(R.id.textView_id);
            textView2 = view.findViewById(R.id.textView_content);
            textView3 = view.findViewById(R.id.textView_date);
            view.setOnClickListener(this);
        }

        public void setData() {
            Item item = arrayList.get(getAdapterPosition());
            textView1.setText(item.getId());
            textView2.setText(item.getComment());
            textView3.setText(item.getDateFormatted());
        }

        @Override
        public void onClick(View view) {
            Item item = arrayList.get(getAdapterPosition());
            String s = String.format("index: %d, id: %s", getAdapterPosition(), item.getId());
            Toast.makeText(view.getContext(), s, Toast.LENGTH_SHORT).show();
        }
    }

    LayoutInflater layoutInflater;
    ArrayList<Item> arrayList;

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
        View view = layoutInflater.inflate(R.layout.item1, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int index) {
        viewHolder.setData();
    }


}
