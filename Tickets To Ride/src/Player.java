
public class Player {
	int points;
	int trains;
	String name;
	//insert array of card objects here;
	//insert array of mission card objects here;
	
	//no-arg constructor because Kryonet requires it
	Player(){}
	
	public Player(int points, int trains, String name){
		this.points=points; 
		this.trains=trains;
		this.name=name;
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
