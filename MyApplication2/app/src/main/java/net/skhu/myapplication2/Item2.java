package net.skhu.myapplication2;

public class Item2 {

    String comment;
    boolean checked;

    public Item2(String comment) {
        this.comment = comment;
    }


    public String getComment() {
        return comment;
    }

    public boolean isChecked() { return checked; }
    public void setChecked(boolean checked) { this.checked = checked; }

}
