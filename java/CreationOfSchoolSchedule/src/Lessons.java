
public class Lessons {
	private String name;
	private String codeName;
	private String classroom;
	private String    WeekHours; 
	public Lessons(String name , String codeName ,String classroom , String WeekHours){
		this.name=name;
		this.codeName=codeName;
		this.classroom=classroom;
		this.WeekHours=WeekHours;
		}
	
@Override
public String toString() {
	return name + " " + codeName +" "+ classroom + " " + WeekHours + " ";
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCodeName() {
	return codeName;
}

public void setCodeName(String codeName) {
	this.codeName = codeName;
}


public String getClassroom() {
	return classroom;
}

public void setClassroom(String class1) {
	classroom = class1;
}

public String getWeekHours() {
	return WeekHours;
}

public void setWeekHours(String weekHours) {
	WeekHours = weekHours;
}


}
