import java.util.ArrayList;

public class Player {
	private int points;
	private int trains;
	private String name;
	//insert array of card objects here;
	//insert array of mission card objects here;
	
	//this array should only be accessed through TrainCard class
	public ArrayList<TrainCard> hand = new ArrayList<TrainCard>();
	
	//no-arg constructor because Kryonet requires it
	Player(){}
	
	public Player(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getTrains() {
		return trains;
	}

	public void setTrains(int trains) {
		this.trains = trains;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
