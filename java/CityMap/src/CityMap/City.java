package doMesErgasia2;

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
	
	public float getPercentage() {
		return percentage;
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
