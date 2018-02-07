package spirit.freewill.util;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import spirit.freewill.data.FreewillItem;

import static spirit.freewill.util.Constant.context;

/**
 * Created by mafulin on 2018/1/16.
 */

public class FileUtil {
    public static final String LIST_KEY = "freewilllist";
    public static List<FreewillItem> readlist(Context context){
        try {
            FileInputStream openFileInput = context.openFileInput(LIST_KEY);
            ObjectInputStream objectInputStream = new ObjectInputStream(openFileInput);
            List<FreewillItem> data = (List<FreewillItem>) objectInputStream.readObject();
            openFileInput.close();
            objectInputStream.close();
            return data;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static void writeList(Context context,List<FreewillItem> data){
        try {
            FileOutputStream openFileOutput = context.openFileOutput(LIST_KEY, Context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(openFileOutput);

            objectOutputStream.writeObject(data);
            openFileOutput.close();
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void deleteList(Context context){
        context.deleteFile(LIST_KEY);
    }
}
