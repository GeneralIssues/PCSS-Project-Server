import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;


public class ClientProgram extends Listener {

	//The client object.
	static Client client;
	
	//IP to connect to. !IMPORANT VARIABLE! REMEMBER TO CHANGE BASED ON HOST IP
	static String ip = "192.168.43.14";
	
	//Ports to connect to.
	static int udpPort = 4445, tcpPort = 4444;
	
	//Boolean to check if a packet is received
	static boolean messageReceived = false;
	
	//Test objects
	static Player pl = new Player("Name");
	static Lobby test = new Lobby("Kek",pl,"createLobby");
	
	public static void main(String[] args) throws Exception {
		System.out.println("Connecting to the server...");
		
		//Create the client.
		client = new Client();
		
		//Register different classes.
		client.getKryo().register(Lobby.class);
		client.getKryo().register(Player.class);
		client.getKryo().register(Player[].class);
		client.getKryo().register(TrainCard.class);
		client.getKryo().register(Map.class);
		client.getKryo().register(Route.class);
		client.getKryo().register(java.util.ArrayList.class);
		client.getKryo().register(String.class);
		
		//Start the client
		new Thread(client).start();
		//The client MUST be started before connecting can take place.
		
		//Connect to the server - wait 5000ms before failing.
		client.connect(5000, ip, tcpPort, udpPort);
		
		//Add a listener
		client.addListener(new ClientProgram());
		
		System.out.println("Connected! The client program is now waiting for a packet...\n");
		
		client.sendTCP(test);
		
		//This is here to stop the program from closing before we receive a message.
		while(!messageReceived){
			System.out.println("No messege yet");
			Thread.sleep(1000);
		}
		//This happens when messegeReceived is true
		System.out.println("Client will now exit.");
		//System.exit(0);
	}
	
	//This is called whenever a packet is received from the server
	public void received(Connection c, Object p){
		//If the class of the packet is Lobby then do the following
		if (p instanceof Player){
			//messageReceived = true;
		}
	}
}