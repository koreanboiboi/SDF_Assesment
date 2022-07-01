package task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class MainCopy 
{
    
    public static void main( String[] args )throws IOException{

        String dataFile = args[0];
        String formatFile = args[1];

        MailMerge mailMerge = new MailMerge();

        //this will read my args 0
        Reader csvReader = new FileReader(dataFile);
        BufferedReader br = new BufferedReader(csvReader);

        String data = br.readLine();

        while(null != data){
            data = br.readLine();
            mailMerge.read(data);
        }

        //this will read my csv and store data into variable
        //mailMerge.read(data);

        //this will read my txt
        
            try(BufferedReader br2 = new BufferedReader(new FileReader(formatFile))) {
            StringBuilder sb = new StringBuilder();
            String line = br2.readLine();
        
            for(int i =0; i<4; i++){
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br2.readLine();
            }
            String everything = sb.toString()
            System.out.println(everything);
        }
    }
        
    }
}
