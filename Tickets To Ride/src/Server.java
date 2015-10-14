import java.io.*;
import java.net.*;

public class Server {

	public static void main(String[] args) {
		
		
		try {
			ServerSocket socket = new ServerSocket(4444);
			String receivedData = "";
			while(true){
	            BufferedReader inFromClient =
	                    new BufferedReader(new InputStreamReader(socket.getInputStream()));
	                 DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());
	                 receivedData = inFromClient.readLine();
	                 System.out.println("Received: " + receivedData);
	                 outToClient.writeBytes(receivedData);
			System.out.println(receivedData);
				if(receivedData.startsWith("quit")){
					break;
				}
			}
			socket.close();
		} catch (IOException e1) {
			System.out.println("Error: SocketExecption");
			e1.printStackTrace();
		}

	}
	
}
