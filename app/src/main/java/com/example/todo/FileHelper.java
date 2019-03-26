package com.example.todolist;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by amitm on 06-10-2018.
 */

public class FileHelper {

    public static final String FILENAME  =  "Listinfo.dat";
    public static void write_data(ArrayList<String> items, Context context){
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME,Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(items);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> read_data(Context context){
        ArrayList<String> items_list = null;
        try {
            FileInputStream fis= context.openFileInput(FILENAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            items_list = (ArrayList<String>) ois.readObject();

        } catch (FileNotFoundException e) {
            items_list = new ArrayList<String>();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return items_list;
    }
}
