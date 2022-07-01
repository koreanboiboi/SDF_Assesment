package task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


//this is a trying out page because too many changes on base code
public class MainDuplicate
{
    
    public static void main( String[] args )throws IOException{

        String dataFile = args[0];
        String formatFile = args[1];
        String [] fields;
        String f1;
        String f2;
        String f3;
        String f4;

        MailMerge mailMerge = new MailMerge();

        //this will read my args 0
        Reader csvReader = new FileReader(dataFile);
        BufferedReader br = new BufferedReader(csvReader);

        String data = br.readLine();

        while(null != data){
            data = br.readLine();

             fields = data.split(",");
        
             f1 = removeN(fields[0]);
             f2 = removeN(fields[1]);
             f3 = removeN(fields[2]);
             f4 = removeN(fields[3]);
    
            System.out.printf("%s %s %s %s\n", f1, f2, f3, f4);

            //System.out.println(data);
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
            String everything = sb.toString().replace("__address__",f3).replace("__first_name__", f1).replace("__years__", f4).replace("__salutations__", f1).replace("__last_name__", f2).replace("__package_name__", f3).replace("__price__", f4);
            System.out.println(everything);
        }
    }
        
    }

    private static String removeN(String string) {
        return string.replace("\\n", " ");
    }
}
