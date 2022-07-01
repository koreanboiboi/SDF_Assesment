package task02;

import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientMain 
{
    public static void main( String[] args ) throws IOException {

       
        System.out.println("Connecting to task02.chuklee.com at port 80");
        // Connect the server
     
        Socket sock = new Socket("task02.chuklee.com", 80);
        System.out.println("Connected ...");

       
        InputStream is = sock.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        //ObjectInputStream ois = new ObjectInputStream(is);

        // Get the output stream
        OutputStream os = sock.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        //ObjectOutputStream oos = new ObjectOutputStream(os);

        // Get input from user
        Console cons = System.console();
        String input = cons.readLine("User Id: ");
        input = cons.readLine("NRIC: ");
        input = cons.readLine("Email: ");
        Float input2 = Float.parseFloat(cons.readLine("Number: "));
   
        // Write to server
        dos.writeUTF(input);
        dos.writeFloat(input2);
        dos.flush();

        // Wait for response from server
        String response = dis.readUTF();
        System.out.printf(">> %s\n", response);

        
        is.close();
        os.close();
        sock.close();
        

    
        
    }
}
