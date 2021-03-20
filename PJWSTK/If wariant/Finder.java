package zad21;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Finder {
    String plik;
    public Finder(String f) {
     plik=f;
    }
    
    public int getIfCount(){
        return this.getStringCount("if");
    }
    
    public int getStringCount(String s)  {
        File file;
        FileReader fileReader;
        BufferedReader bufferedReader;
        String line;
        s=s.toLowerCase();
        int count=0;
        try {
            file = new File(plik);
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                 line=line.toLowerCase();
                 Pattern p = Pattern.compile(s);
                 Matcher m = p.matcher(line);
                 while (m.find()) {
                    count +=1;
                 }
            }
            fileReader.close();

            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
    return count;
    }
    
}
