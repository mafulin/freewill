package spirit.freewill.data;

import java.io.Serializable;

/**
 * Created by mafulin on 2018/1/16.
 */

public class FreewillItem implements Serializable {

    private String kind;
    private long time;
    private int type;
    private String color;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public FreewillItem() {
    }
    public FreewillItem(int type, long time, String color) {
        this.time = time;
        this.type = type;
        this.color = color;
    }

    public FreewillItem(int type, long time, String kind, String color) {
        this.time = time;
        this.type = type;
        this.color = color;
        this.kind = kind;
    }



    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }



    @Override
    public String toString() {
        return "FreewillItem{" +
                "time=" + time +
                ", type=" + type +
                ", color='" + color + '\'' +
                ", kind='" + kind + '\'' +
                '}';
    }
}
