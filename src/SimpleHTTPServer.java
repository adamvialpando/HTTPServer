/**
 * Created by avialpando on 6/17/16.
 */

import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SimpleHTTPServer
{
public static void main(String[] args) throws Exception
{   //This class implements server sockets. A server socket waits for requests to come in over the network.
    final ServerSocket server = new ServerSocket(8081);
    //Creates a server socket, bound to the specified port.
    System.out.println("Listening for connection on port 8081....");
    int i =0;
    while (true){
        // spin forever
        final Socket clientSocket = server.accept();
        //Listens for a connection to be made to this socket and accepts it.
        // blocking method call
        // 1. read HTTP request from the client socket
        // 2. Prepare an HTTP response
        // 3. Send HTTP response to the client
        // 4. Close the socket
        InputStreamReader isr =  new InputStreamReader(clientSocket.getInputStream());
        //a bridge from byte streams to character streams: It reads bytes and decodes them into characters
        BufferedReader reader = new BufferedReader(isr);
        //buffers characters so as to provide for the efficient reading of characters, arrays, and lines.
        String line = reader.readLine();
        //Reads a line of text. A line is considered to be terminated by any one of a line feed ('\n'), a carriage return ('\r'),
        while (!line.isEmpty())
        {
            System.out.println(line);
            line = reader.readLine();
        }
    }

}
}
