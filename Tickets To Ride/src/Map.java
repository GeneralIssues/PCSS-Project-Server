
public class Map {

	Route[] route = new Route[100];
	
	//Creating a map will create all the routes on the map
	//The specific connections are not made
	//as we do not use missions cards or look for longest route
	Map() {	
		//blank routes
		for (int i = 0; i < 9; i++) {
			route[i].CreateRoute(1, 0);
		}
		
		for (int i = 9; i < 35; i++) {
			route[i].CreateRoute(2, 0);
		}
		
		for (int i = 35; i < 41; i++) {
			route[i].CreateRoute(3, 0);
		}
		
		route[41].CreateRoute(4, 0);
		route[42].CreateRoute(4, 0);
		
		route[43].CreateRoute(6, 0);
		//end blank
		
		//green routes
		route[44].CreateRoute(2, 8);
		route[45].CreateRoute(2, 8);
		route[46].CreateRoute(3, 8);
		route[47].CreateRoute(4, 8);
		route[48].CreateRoute(5, 8);
		route[49].CreateRoute(5, 8);
		route[50].CreateRoute(6, 8);
		//end green
		
		//white routes
		route[51].CreateRoute(2, 2);
		route[52].CreateRoute(2, 2);
		route[53].CreateRoute(3, 2);
		route[54].CreateRoute(4, 2);
		route[55].CreateRoute(5, 2);
		route[56].CreateRoute(5, 2);
		route[57].CreateRoute(6, 2);
		//end white
		
		//purple routes
		route[58].CreateRoute(2, 1);
		route[59].CreateRoute(3, 1);
		route[60].CreateRoute(3, 1);
		route[61].CreateRoute(4, 1);
		route[62].CreateRoute(4, 1);
		route[63].CreateRoute(5, 1);
		route[64].CreateRoute(6, 1);
		//end purple
		
		//blue routes
		route[65].CreateRoute(2, 3);
		route[66].CreateRoute(3, 3);
		route[67].CreateRoute(3, 3);
		route[68].CreateRoute(4, 3);
		route[69].CreateRoute(4, 3);
		route[70].CreateRoute(5, 3);
		route[71].CreateRoute(6, 3);
		//end blue
		
		//yellow routes
		route[72].CreateRoute(2, 4);
		route[73].CreateRoute(3, 4);
		route[74].CreateRoute(3, 4);
		route[75].CreateRoute(4, 4);
		route[76].CreateRoute(4, 4);
		route[77].CreateRoute(5, 4);
		route[78].CreateRoute(6, 4);
		//end blue
		
		//orange routes
		route[79].CreateRoute(2, 5);
		route[80].CreateRoute(3, 5);
		route[81].CreateRoute(3, 5);
		route[82].CreateRoute(4, 5);
		route[83].CreateRoute(4, 5);
		route[84].CreateRoute(5, 5);
		route[85].CreateRoute(6, 5);
		//end orange
		
		//black routes
		route[86].CreateRoute(2, 6);
		route[87].CreateRoute(3, 6);
		route[88].CreateRoute(3, 6);
		route[89].CreateRoute(4, 6);
		route[90].CreateRoute(4, 6);
		route[91].CreateRoute(5, 6);
		route[92].CreateRoute(6, 6);
		//end black
		
		//black routes
		route[93].CreateRoute(2, 7);
		route[94].CreateRoute(3, 7);
		route[95].CreateRoute(3, 7);
		route[96].CreateRoute(4, 7);
		route[97].CreateRoute(4, 7);
		route[98].CreateRoute(5, 7);
		route[99].CreateRoute(6, 7);
		//end black	
	}
}
