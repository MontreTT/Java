
package domes2;

import java.math.RoundingMode;
import java.text.DecimalFormat;
//Create a City Object that has an ID , a name , population number , covidCases number(daily) , and percentage ( just covidCases / population)
public  class City implements CityInterface {
	
	private int ID ; 
	private String name;
	private int population ;
	private int covidCases ;
	private float percentage ;
	public City(int ID , String name , int population , int covidCases) {
		this.ID= ID;
		this.name=name;
		this.population= population;
		this.covidCases = covidCases;
		this.percentage = (float) covidCases / population;
		
	}
	
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public String getPercentage() {
		DecimalFormat df = new DecimalFormat("0.00"); // for rounding to 2 digit ,purposes
		df.setRoundingMode(RoundingMode.DOWN);//
		String a = df.format(percentage);
		
		return a;
	}

	public int getID() {
		return ID;
	}
	public String getName() {
		return name;
	}
	public int getPopulation() {
		return population;
	}
	public int getCovidCases() {
		return covidCases;
	}
	public void setID(int ID) {}
	public void setName(String name) {}
	public void setPopulation(int population) {}
	public void setCovidCases(int CovidCases) {}

}
