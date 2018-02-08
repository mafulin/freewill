package spirit.freewill.data;

import java.io.Serializable;

/**
 * Created by mafulin on 2018/1/16.
 */

public class ConsciousnKind implements Serializable {

    private int index;

    private String kind;

    private String color;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ConsciousnKind(int index, String kind, String color) {
        this.index = index;
        this.kind = kind;
        this.color = color;
    }

    @Override
    public String toString() {
        return "FreewillItem{" +
                "index=" + index +
                ", kind='" + kind + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
