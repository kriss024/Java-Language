import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {
  public static void main(String[] args) throws Exception {
	  
    ServerSocket serverSocket = new ServerSocket(12900, 100, 
        InetAddress.getByName("192.168.58.130"));
    System.out.println("Server started  at:  " + serverSocket.toString());


      System.out.println("Waiting for a  connection...");

      final Socket activeSocket = serverSocket.accept();

      System.out.println("Received a  connection from  " + activeSocket.toString());
      
      Thread task = new Thread(new Runnable() {
          public void run()
          {
        	  
        	  handleClientRequest(activeSocket);
          }
      });
      task.start();


  }

  public static void handleClientRequest(Socket socket) {
    try{
      BufferedReader socketReader = null;
      BufferedWriter socketWriter = null;
      socketReader = new BufferedReader(new InputStreamReader(
          socket.getInputStream()));
      socketWriter = new BufferedWriter(new OutputStreamWriter(
          socket.getOutputStream()));

      String inMsg = null;
      while ((inMsg = socketReader.readLine()) != null) {
        System.out.println("Received from client: " + inMsg);

        String outMsg = inMsg;
        socketWriter.write(outMsg);
        socketWriter.write("\n");
        socketWriter.flush();
      }
      socket.close();
      System.out.println("Connection is closed.");
    }catch(Exception e){
    	System.err.println(e.getMessage());
    	System.exit(1);
    }

  }
}