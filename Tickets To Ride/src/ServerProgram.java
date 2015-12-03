//Kryonet lib imports, used for TCP connections
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

//InetAdress import to get the localhost IPv4
import java.net.InetAddress;

//javax imports used for making a JFrame with JLabels
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ServerProgram extends Listener {

	//Server object
	static Server server;
	static Client client;
	String command;
	
	//Lobby name for test lobby objects
	static String lName = "THIS IS A LOBBY";

	//Ports to listen on
	static int udpPort = 4445, tcpPort = 4444;
	
	public static void main(String[] args) throws Exception {
		System.out.println("Creating the server...");
		
		//Create the server
		server = new Server();
		
		client = new Client();
		//Finds the current hosts LAN IPv4
		InetAddress inet = InetAddress.getLocalHost();
		
		// Open a window to provide an easy way to stop the server.
		JFrame frame = new JFrame("Ticket To Ride Server");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new JLabel("Server running on IP " + inet + " and UDP port " + udpPort +" TCP port "+ tcpPort));
		frame.setSize(510, 300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		//Register classes
		server.getKryo().register(Lobby.class);
		server.getKryo().register(Player.class);
		server.getKryo().register(Player[].class);
		server.getKryo().register(TrainCard.class);
		server.getKryo().register(Map.class);
		server.getKryo().register(Route.class);
		
		//server.getKryo().register(Board.class);
		//We can only send objects as packets if they are registered.
		
		//Bind to a port
		server.bind(tcpPort, udpPort);
		
		//Start the server
		server.start();
		
		//Add the listener
		server.addListener(new ServerProgram());
		
		//Tell us that the server is running
		//System.out.println("Server is running!");
		
	}
	
	//This is run when a connection is received!
	public void connected(Connection c){
		System.out.println("Received a connection from "+c.getRemoteAddressTCP().getHostString());
		
		
		
		//Send the message
		//System.out.println("Sending packet to client containing an instance of " + lobby.getClass().getName());
		//c.sendTCP(lobby);
		
		//Alternatively, we could do:
		//c.sendUDP(packetMessage);
		//To send over UDP.
	}
	
	//This is run when we receive a packet.
	public void received(Connection c, Object p, Object com){
		System.out.println("Someone sent a package to the server!");
		System.out.println(p.getClass().getName());
		
		int ID = c.getID();
		
		//When we receive an objects, check what class it has and
		//Based on the class name, either send to all or don't
		if(p.getClass().getName() == "Lobby"){
			System.out.println(p.getClass().getName());
			Lobby lobby = (Lobby) p;
			if(com.getClass().getName() == "String"){
				command = (String) com;
			}
			if(command == "!METHODNAME!"){
				//lobby.!METHODNAME!
				c.sendTCP(lobby);
				//Either or
				sendToAll(c,p);
			}
			
			
		} else if(p.getClass().getName() == "Player"){
			Player player = (Player) p;
			
			if(com.getClass().getName() == "String"){
				command = (String) com;
			}
			if(command == "!METHODNAME!"){
				//player.!METHODNAME!
				c.sendTCP(player);
			}
			//Don't send to all
			
		} else if(p.getClass().getName() == "Map"){
			Map map = (Map) p;
			
			if(com.getClass().getName() == "String"){
				command = (String) com;
			}
			
			if(command == "!METHODNAME!"){
				//map.!METHODNAME!
				c.sendTCP(map);
			}
			sendToAll(c,p);
			
		}else if(p.getClass().getName() == "TrainCard"){
			TrainCard traincard = (TrainCard) p;
			if(com.getClass().getName() == "String"){
				command = (String) com;
			}
			
			if(command == "!METHODNAME!"){
				//traincard.!METHODNAME!
				
				c.sendTCP(traincard);
			}
			//Don't send to all
		}
	}
		
	//This is run when a client has disconnected.
	public void disconnected(Connection c){
		System.out.println("A client disconnected!");
	}
	
	//This is used to send an object(p) to all TCP connections on the socket/connection(c)
	public void sendToAll(Connection c , Object p){
		server.sendToAllTCP(p);
	}
}
