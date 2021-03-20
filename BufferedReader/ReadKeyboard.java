package jobiekt;
import java.io.*;

public class ReadKeyboard {
    public ReadKeyboard(){
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
            String sample = null;
            try {
                sample = br.readLine();
            } catch (IOException e) {
                 System.err.println("I/O Exception");
            }
            System.out.println(sample);
        }
    
    }

    public static void main(String[] args)  {
        ReadKeyboard readKeyboard = new ReadKeyboard();
    
        
    }
}
