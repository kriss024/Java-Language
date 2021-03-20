import com.opencsv.CSVReader;

import java.io.*;


/**
 * Created by Krzysiek on 2014-12-15.
 */
public class Main {

    public static void main(String [] args)
    {
        File file;
        FileReader fr;
        CSVReader reader=null;
        char separator = ';';

        try {
            file = new File("C://jcsv//Zeszyt1.csv");
            fr = new FileReader(file);
            reader  = new CSVReader(fr,separator);


        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }

        String [] nextLine;
        try {
            while ((nextLine = reader.readNext()) != null) {

               System.out.println(nextLine[0]+' '+nextLine[1]);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }


    }


}
