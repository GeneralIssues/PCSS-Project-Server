public class Lobby {

	protected String lobbyName;
	protected String state;
	protected Player[] players = new Player[5];
	protected int playerAmount;
	protected int runtime;
	
	Lobby(String lobbyName, Player player) {
		this.lobbyName = lobbyName;
		players[0] = player;
		playerAmount = 1;
	}
	
	//Player join
	public String joinLobby(Player newPlayer) {
		if (playerAmount < 5) {					//The game can only hold a maximum of 5 players
			players[playerAmount] = newPlayer;	//New player is added to the next spot in the array
			playerAmount++;						//Player amount increased
			return "Joined lobby";				//String is returned to player, client
		} else {
			return "Lobby is full";				//String is returned if full
		}
	}
	
	//Get and Set
	//Lobby name
	public String getLobbyName() {
		return lobbyName;
	}
	
	public void setLobbyName(String lobbyName) {
		this.lobbyName = lobbyName;
	}
	//end lobby name
	
	//State
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	//end state
	
	//Player array
	public Player[] getPlayer() {
		return players;
	}
	//end player
	
	//Runtime
	public int getRuntime() {
		return runtime;
	}
	//end runtime
	//end Get and Set
}
