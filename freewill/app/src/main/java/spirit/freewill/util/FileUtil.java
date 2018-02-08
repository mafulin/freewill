package spirit.freewill.util;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import spirit.freewill.data.ConsciousnKind;
import spirit.freewill.data.FreewillItem;

import static spirit.freewill.util.Constant.context;

/**
 * Created by mafulin on 2018/1/16.
 */

public class FileUtil {
    public static final String LIST_KEY = "freewilllist";
    public static final String LIST_KIND_KEY = "ConsciousnList";
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

        return new ArrayList<FreewillItem>();

    }
    public static List<FreewillItem> addItem(FreewillItem freewillItem){
            List<FreewillItem> data = FileUtil.readlist(Constant.context);
            if(data == null){
                data = new ArrayList<FreewillItem>();
            }
            data.add(freewillItem);
            FileUtil.writeList(Constant.context,data);
        Log.i("123","addItem--"+data);
            data = FileUtil.readlist(Constant.context);
            return data;
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
    public static List<ConsciousnKind> readKindlist(Context context){
        try {
            FileInputStream openFileInput = context.openFileInput(LIST_KIND_KEY);
            ObjectInputStream objectInputStream = new ObjectInputStream(openFileInput);
            List<ConsciousnKind> data = (List<ConsciousnKind>) objectInputStream.readObject();
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

    public static void writeKindList(Context context,List<ConsciousnKind> data){
        try {
            FileOutputStream openFileOutput = context.openFileOutput(LIST_KIND_KEY, Context.MODE_PRIVATE);
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

    public static void deleteKindList(Context context){
        context.deleteFile(LIST_KIND_KEY);
    }
}
