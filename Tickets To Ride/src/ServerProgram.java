//Kryonet lib imports, used for TCP connections
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

//InetAdress import to get the localhost IPv4
import java.net.InetAddress;
import java.util.ArrayList;

//javax imports used for making a JFrame with JLabels
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ServerProgram extends Listener {

	//Server object
	static Server server;
	String command;
	
	//Stores the only active lobby
	static Lobby realLobby;
	
	//Bool to check if lobby exists
	public boolean isLobbyCreated;

	//Ports to listen on
	static int udpPort = 4445, tcpPort = 4444;
	
	public static void main(String[] args) throws Exception {
		System.out.println("Creating the server...");
		
		//Create the server
		server = new Server();
		
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
		server.getKryo().register(java.util.ArrayList.class);
		server.getKryo().register(String.class);
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
		
		//Alternatively, we could do:
		//c.sendUDP(packetMessage);
		//To send over UDP.
		
		c.setKeepAliveTCP(8000);
	}
	
	//This is run when we receive a packet.
	//When we receive an object, check what class it has and
	//Based on the class, either send to all or don't
	public void received(Connection c, Object p){
		System.out.println("Someone sent a package to the server!");
		
		if(p instanceof Lobby){
			System.out.println("1");
			Lobby lobby = (Lobby) p;
			
			if(lobby.commandString.equalsIgnoreCase("createLobby")){
				realLobby = lobby;
				isLobbyCreated = true;
				System.out.println("Stored Real Lobby");
			}
		}
		else if(p instanceof Player){
			System.out.println("1");
			Player plr = (Player) p;
			System.out.println(plr.commandString);
			System.out.println(plr.getName());
			if(plr.commandString.equalsIgnoreCase("joinLobby")){
				if(isLobbyCreated == true){
					realLobby.players.add(plr);
					sendToAll(c,realLobby.players);
				}
			}	
		} else if(p instanceof Map){
			System.out.println("3");
			Map map = (Map) p;
			
			/*if(com instanceof String){
				command = (String) com;
			}*/
			
			if(command == "!METHODNAME!"){
				//map.!METHODNAME!
				c.sendTCP(map);
			}
			sendToAll(c,p);
			
		}else if(p instanceof TrainCard){
			System.out.println("4");
			TrainCard traincard = (TrainCard) p;
			
			/*if(com instanceof String){
				command = (String) com;
			}*/
			
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
	
	//Method for finding the winner of the game
	public Player checkWinner() {
		
		//////////////////////////////////////////////////////////////////////////////
		ArrayList<Player> players = new ArrayList<Player>(); 	//DO NOT LEAVE HERE
		Map map = new Map();									//INSTATIATE ELSEWHERE
		//////////////////////////////////////////////////////////////////////////////
		
		int[] points = new int[players.size()];
		
		for (int i = 0; i < players.size(); i++) {
			points[i] = map.CalculatePoints(players.get(i));	
		}
		
		int highest = points[0];
		int index = 0;
		
		for (int i = 1; i < points.length; i++) {
			if (points[i] > highest)
				highest = points[i];
				index = i;
		}
		
		return players.get(index);
	}
	
	//Method for seeing if the game is on its last rounds
	//The current player should be added to a temp
	//The next player has their turn
	//If current player is = temp end game
	public boolean lastRound(Player player) {
		if (player.getTrains() <= 2)
			return true;
			
		return false;		
	}
	
	public void updatePlayers(Connection c){
		c.sendTCP(realLobby.players.get(1).getName());
	}
}