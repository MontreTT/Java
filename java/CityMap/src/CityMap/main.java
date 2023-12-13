package doMesErgasia2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class main {


	public static void main(String[] args) {
		
		
		try(BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Μανώλης\\Desktop\\domesErgasia2.txt"))) {
		    String str;
		    Vector<City> vectorText = new Vector<City>();
		    StringDoubleEndedQueueImpl heapArray = new StringDoubleEndedQueueImpl();
		    while ((str = in.readLine()) != null) {
		    	String[] tokens = str.split(" ");
		    	City cityExample = new City(Integer.parseInt(tokens[0]),tokens[1],Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]));
		    	vectorText.add(cityExample); 
		    	heapArray.addToHeap(cityExample);
		    	
		    	
		    }
		    for(int i = 0 ; i < vectorText.size() ; i ++) {
		    	System.out.println(vectorText.get(i).getPercentage());
		    }
		}
		catch (IOException e) {
		    System.out.println("File Read Error");
		}
		



}



}
