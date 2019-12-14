package net.skhu.myapplication2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Item {
    final static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String id;
    String comment;
    Date date;

    public Item(String id, String comment, Date date) {
        this.id = id;
        this.comment = comment;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public Date getDate() {
        return date;
    }

    public String getDateFormatted() {
        return format.format(date);
    }
}
