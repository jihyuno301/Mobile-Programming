package net.skhu.myapplication2;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class Firebase2Adapter extends RecyclerView.Adapter<Firebase2Adapter.ViewHolder> {

    class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
        TextView textView1, textView2;
        CheckBox checkBox;

        public ViewHolder(View view) {
            super(view);
            textView1 = view.findViewById(R.id.textView1);
            textView2 = view.findViewById(R.id.textView2);
            checkBox = view.findViewById(R.id.checkBox);
            textView1.setOnClickListener(this);
            this.checkBox.setOnCheckedChangeListener(this);
        }

        public void setData() {
            Item3 item = arrayList.get(getAdapterPosition());
            textView1.setText(item.getTitle());
            textView2.setText(item.getDateFormatted());
            checkBox.setChecked(item.isChecked());
        }

        @Override
        public void onClick(View view) {
//            Item3 item = arrayList.get(super.getAdapterPosition());
//            String s = String.format("index: %d,  title: %s", super.getAdapterPosition(), item.getTitle());
//            Toast.makeText(view.getContext(), s, Toast.LENGTH_SHORT).show();
            Firebase3Activity activity = (Firebase3Activity)view.getContext();
            Item3 item = arrayList.get(getAdapterPosition());
            Intent intent = new Intent(activity, Item3EditActivity.class);
            intent.putExtra( "item", item);
            activity.startActivityForResult(intent, Item3EditActivity.REQUEST_EDIT);

        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Item3 item = arrayList.get(super.getAdapterPosition());
            item.setChecked(isChecked);
            boolean invalidateMenu = false;
            if (isChecked) invalidateMenu = (++checkedItemCount == 1);
            else invalidateMenu = (--checkedItemCount == 0);
            if (invalidateMenu)
                ((Activity) textView1.getContext()).invalidateOptionsMenu();
        }
    }

    LayoutInflater layoutInflater;
    ArrayList<Item3> arrayList;
    int checkedItemCount = 0;

    public Firebase2Adapter(Context context, ArrayList<Item3> arrayList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.arrayList = arrayList;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = layoutInflater.inflate(R.layout.item3, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int index) {
        viewHolder.setData();
    }
}

