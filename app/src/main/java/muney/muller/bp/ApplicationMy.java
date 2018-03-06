package muney.muller.bp;

import android.app.Application;
import android.content.Context;
import com.fynov.lib_data.DataAll;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by Bor on 05/03/2018.
 */

public class ApplicationMy extends Application {
    DataAll all;
    Context ac;

    private static final String FILE_NAME = "coupons.json";

    @Override
    public void onCreate() {
        super.onCreate();
        ac=this;
    }

    public boolean readFromFile() {
        File file = new File(this.getFilesDir(), ""
                + FILE_NAME);

        try {
            System.out.println("Load "+file.getAbsolutePath()+" "+file.getName());
            FileInputStream fstream = new FileInputStream(file);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader( new InputStreamReader(in));
            StringBuffer sb = new StringBuffer();
            String strLine;
            while ((strLine = br.readLine()) != null) {sb.append(strLine).append('\n');}
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            DataAll a = gson.fromJson(sb.toString(), DataAll.class);
            if (a!=null)
                all = a;
            else return false;
        } catch (IOException e) {
            System.out.println("Error load "+e.toString());
        }
        return true;
    }

    public void writeToFile() {
        File file = new File(this.getFilesDir(), ""
                + FILE_NAME);

        try {
            long start = System.currentTimeMillis();
            System.out.println("Save "+file.getAbsolutePath()+" "+file.getName());
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            PrintWriter pw = new PrintWriter(file);
            String sss=gson.toJson(all);
            System.out.println("Save time gson:"+(double)(System.currentTimeMillis()-start)/1000);
            pw.println(sss);
            pw.close();
            System.out.println("Save time s:"+(double)(System.currentTimeMillis()-start)/1000);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error save! (FileNotFoundException)");
        } catch (IOException e) {
            System.out.println("Error save! (IOException)");
        }
    }
}


