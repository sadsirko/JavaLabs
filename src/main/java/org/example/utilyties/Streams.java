package org.example.utilyties;

import org.example.userClasses.Readers;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Streams {
    private static final String placeToSaveOutput = "result.txt";
    private static final String placeDB = "readerdata.obj";
    public static void saveResult( String res) throws IOException {
        Date dateTime = new Date();
        BufferedWriter writer = new BufferedWriter(new FileWriter(placeToSaveOutput, true));
        writer.append('\n');
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        writer.append(formatter.format(dateTime));
        writer.append(res);
        writer.close();
    }

    public static void serializeDB(Readers[] dataBase){
        try
        {
            FileOutputStream fos = new FileOutputStream(placeDB);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(dataBase);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    public static Readers[] deserializeDB(Readers[] dataBase) throws Exception{

            FileInputStream fis = new FileInputStream(placeDB);
            ObjectInputStream ois = new ObjectInputStream(fis);

            dataBase = (Readers[]) ois.readObject();

            ois.close();
            fis.close();


        return dataBase;
    }
}
