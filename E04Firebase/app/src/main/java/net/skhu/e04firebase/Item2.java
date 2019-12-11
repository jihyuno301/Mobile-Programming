package net.skhu.e04firebase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Item2 {
    final static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String key;
    String title;
    Date date;
    boolean checked;

    public Item2() {
    }

    public Item2(String title, Date date) {
        this.title = title;
        this.date = date;
    }

    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }

    public String getDateFormatted() {
        return format.format(date);
    }

    public boolean isChecked() { return checked; }
    public void setChecked(boolean checked) { this.checked = checked; }
}
