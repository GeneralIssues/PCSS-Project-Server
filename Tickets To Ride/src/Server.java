import java.io.*;
import java.net.*;

public class Server {
	//Array to store the data received in
	static byte[] data;
	//int to store portNumber
	static int portNumber = 4444;
	//Empty constructor for the Server class
	Server(){}

public static void main(String[] args){
	//Instantiate a Server objects
	Server serv = new Server();
	//Try to open a socket with portNumber and catch exceptions
	try {
		DatagramSocket socket = new DatagramSocket(portNumber);
		String receivedData = "";
		//While statement to keep listening until the quit command is received
		while(true){
		data = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data,1024);
		socket.receive(packet);
		//Store the data from the packet as a String in receivedData
		receivedData = new String(packet.getData());
		serv.ServerResponse(receivedData);
		//Check if the quit command is received, and break if it is
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

//Method for checking commands from the client and responding to them
//Done using startsWith since PacketSender which is used for testing sends
//a large amount of gibberish along with the actual packet content
//Switch statements would be faster but if-else worked so that is why they are utilised
//Using startsWith sets the limitation that no command must start with the same word as another command
//Otherwise the first command will be called instead
public void ServerResponse(String CommandArg) {
	if(CommandArg.startsWith("Start")){
		System.out.println("Client Started");

	}else if(CommandArg.startsWith("Connect")){
		System.out.println("Connected to server");
		
	}else if(CommandArg.startsWith("Create lobby")){
		System.out.println("Lobby created");

	}else if(CommandArg.startsWith("Join Lobby")){
		System.out.println("Lobby joined");
		
	}else if(CommandArg.startsWith("Close lobby")){
	System.out.println("Lobby closed");
	
	}else if(CommandArg.startsWith("Begin game")){
	System.out.println("Game started");

		}
	}
}
