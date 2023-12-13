import java.util.Vector;

public class Stigmiotupo  {
	//ποσους καθηγητες εχουμε προσθέσει
	double stigCost ;
	Vector<String[][]> programma;
	Vprogramma programm;
	Vector<Integer> burnedNums = new Vector<Integer>();
 	boolean isBurned = false; // αν εχει εμφανιστεί 
 	Vector<Object> vKathigites;
 	Vector<Object> vLessons;
	
	public Stigmiotupo(double stigCost , Vector<Object> vKathigites,Vector<Object> vLessons,Vector<String[][]> programm) {
		this.stigCost=stigCost;
		this.programma=programm;
		this.vKathigites=vKathigites;
		this.vLessons=vLessons;
	}

	public double getStigCost() {
		return stigCost;
	}

	public void setStigCost(double stigCost) {
		this.stigCost = stigCost;
	}

	public Vector<String[][]> getStigmiotupo() {
		return programma;
	}

	public void setStigmiotupo(Vector<String[][]> stigmiotupo) {
		this.programma = stigmiotupo;
	}

	@Override
	public String toString() {
		return "Stigmiotupo [stigCost=" + stigCost + ", stigmiotupo=" + programma + "]";
	}

	public boolean isBurned() {
		return isBurned;
	}

	public void setBurned(boolean isBurned) {
		this.isBurned = isBurned;
	}

	public Vector<Integer> getBurnedNums() {
		return burnedNums;
	}

	public void setBurnedNums(Vector<Integer> burnedNums) {
		this.burnedNums = burnedNums;
	}

	public Vector<Object> getvKathigites() {
		return vKathigites;
	}

	public void setvKathigites(Vector<Object> vKathigites) {
		this.vKathigites = vKathigites;
	}


	public void setProgramm(Vprogramma programm) {
		this.programm = programm;
	}

	public Vector<Object> getvLessons() {
		return vLessons;
	}

	public void setvLessons(Vector<Object> vLessons) {
		this.vLessons = vLessons;
	}



	
}
