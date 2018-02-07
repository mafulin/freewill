package spirit.freewill.data;

import java.io.Serializable;

/**
 * Created by mafulin on 2018/1/16.
 */

public class FreewillItem implements Serializable {

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


    private long time;

    private int type;

    @Override
    public String toString() {
        return "FreewillItem{" +
                "time=" + time +
                ", type=" + type +
                '}';
    }
}
