
public class Route extends Map {
	
	private int length;
	private int colour;
    //0 : empty/blank
    //1 : purple
    //2 : white
    //3 : blue
    //4 : yellow
    //5 : orange
    //6 : black
    //7 : red
    //8 : green
	
	private Player player;
	
	Route() {
		
	}
	
	public boolean CheckRouteOccupied() {
		if (this.player == null)
			return false;
		else 
			return true;
	}
	
	/////////////////////////////////////////
	
	public void SetRoute(Player player) {
		this.player = player;
	}
	
	public void CreateRoute(int length, int colour) {
		this.length = length;
		this.colour = colour;
	}
	
	/////////////////////////////////////////
	
	public int GetLength() {
		return this.length;
	}
	
	public int GetColour() {
		return this.colour;
	}
	
	public Player GetPlayer() {
		return this.player;
	}
	
}
