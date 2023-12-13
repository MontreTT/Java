package doMesErgasia2;

import java.util.Vector;

public class CityMap {
	int ID = 0 ;
	public Vector<City> map  = new Vector();
	public CityMap() {

	}
	 void createCity(String name , int population , int covidCases) {
			City a1 = new City(ID ,name, population , covidCases);
			ID ++;
			map.add(a1);
	 }
	
}
