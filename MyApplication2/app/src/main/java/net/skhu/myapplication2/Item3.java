package net.skhu.myapplication2;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Item3 implements Serializable  {
    final static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String key;
    String title;
    Date date;
    boolean checked;

    public Item3() {
    }

    public Item3(String title, Date date) {
        this.title = title;
        this.date = date;
    }

    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public String getDateFormatted() {
        return format.format(date);
    }

    public void setDateFormatted(String date) {
        try {
            this.date = format.parse(date);
        } catch (Exception e) {
        }
    }

    public boolean isChecked() { return checked; }
    public void setChecked(boolean checked) { this.checked = checked; }
}
