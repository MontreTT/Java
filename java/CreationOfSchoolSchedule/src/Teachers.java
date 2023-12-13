
public class Teachers {
	String code;
	String name;
	String lessonsCode;
	String    maxHours;
	Boolean[] availability = {true,true,true,true,true,true,true};
	

	public Teachers(String code,String name,String lessonsCode,String maxHours) {
		this.code=code;
		this.name=name;
		this.lessonsCode=lessonsCode;
		this.maxHours=maxHours;
		
	}
@Override
public String toString() {
	return code + " " +  name +" "+ lessonsCode + " " + maxHours + " " ;
	}
public String getMaxHours() {
	return maxHours;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLessonsCode() {
	return lessonsCode;
}
public void setLessonsCode(String lessonsCode) {
	this.lessonsCode = lessonsCode;
}
public void setMaxHours(String maxHours) {
	this.maxHours = maxHours;
}
public Boolean getAvailability(int number) {
	return availability[number];
	}
public void setAvailability(int number, boolean nice) {
	availability[number] = nice;
}
}
