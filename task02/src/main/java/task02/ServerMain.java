package task02;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

    public static void main(String[] args)throws IOException {

        
        // Create a server socket and listen to a port
        ServerSocket server = new ServerSocket(80);

        System.out.println("Waiting for connection on port 80...");
        // Wait for incoming client connection
        Socket sock = server.accept();
        System.out.println("Connection accepted");

        
        InputStream is = sock.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        //ObjectInputStream ois = new ObjectInputStream(is);

        // Get the output stream
        OutputStream os = sock.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        //ObjectOutputStream oos = new ObjectOutputStream(os);

        // Read request from client
        String request = dis.readUTF();
        
        Float request2 = dis.readFloat();
        
        boolean read = true;

        
        dos.writeUTF(request);
        System.out.printf("User ID: %s\n", request);
        dos.writeUTF(request);
        System.out.printf("User NRIC: %s\n", request);
        dos.writeUTF(request);
        System.out.printf("User EMAIL: %s\n", request);
        dos.writeFloat(request2);
        //do a math function to find the average value first before writing ? sorry I don't know..
        System.out.printf("Average value: %.2f\n", request2);

        if(request == null || request2 == null){
            read = false;
            dos.writeUTF("Failed");;
        }else dos.writeUTF("Success!");

        is.close();
        os.close();
        sock.close();

/*
        OutputStream clientOutput = sock.getOutputStream();
            clientOutput.write("userid" .getBytes());
            clientOutput.write("nric" .getBytes());
            clientOutput.write("email".getBytes());
            clientOutput.write("avg value".getBytes());
            clientOutput.flush();
            clientOutput.close();
   */     
    }

    
}
