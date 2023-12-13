import java.util.Vector;

public class Vprogramma {
	Vector<String[][]> vProgramma ;
	Vector<String[][]> vKathigites;
	public Vprogramma(Vector<String[][]> vProgramma, Vector<String[][]> vKathigites){
		this.vProgramma=vProgramma;
		this.vKathigites=vKathigites;
	}
	public Vector<String[][]> getvProgramma() {
		return vProgramma;
	}
	public void setvProgramma(Vector<String[][]> vProgramma) {
		this.vProgramma = vProgramma;
	}
	public Vector<String[][]> getvKathigites() {
		return vKathigites;
	}
	public void setvKathigites(Vector<String[][]> vKathigites) {
		this.vKathigites = vKathigites;
	}
	
	
	
	
	
	

}
