package domes2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class DynamicCovid_k_withPQ {
	PQ pq = new  PQ();
	Heapsort a;
	int parametr ;
	
	
	
	
	// parametr defines how many items will be stored and printed in PQ
	public DynamicCovid_k_withPQ(int parametr) {
		this.parametr =parametr;
		
		
		
		
	}
	public static void main(String[] args) {
		//read file
				
					Scanner myObj = new Scanner(System.in);  // Create a Scanner object
				    System.out.println("Please give parameter k");
				    int   parametr = Integer.parseInt(myObj.nextLine());
				    DynamicCovid_k_withPQ c = new DynamicCovid_k_withPQ(parametr);
				    c.action(args[0]);
	}
	
	// loads text
	// String input is text adress
	
	public void  action(String text) {
		try(BufferedReader in = new BufferedReader(new FileReader(text))) {
		    String str;
		    
		    int currentLine = 0 ;
		    int i = 0 ;
		    // get input line-line
		    while ((str = in.readLine()) != null  ) {
		    	//split line to array
		    	String[] tokens = str.split(" ");
		    	// pass it as city object
			    City cityExample = new City(Integer.parseInt(tokens[0]),tokens[1],Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]));
			    
			    // initialise heapsort u just need to call compare function later on
			    a = new Heapsort();
			    // till u reach the parametr number add on the queue
		    	if(i < parametr ) {
		    	// add function adds city at the ends then makes it a heap again
		    	// its actually a min heap so first element will be always minimum
			    pq.add(cityExample);
			   
			    i++;
		    	}
		    	// after pq is filled with all cities till parametr level ,each next one will have to be compared with the minimum
		    	// if more than minimum  take its place
		    	// after getMin() and add are called pq becomes a min heap
		    	else if(a.comparedTo(cityExample,pq.min())) {
		    		City removed = pq.getMin();
		    		pq.add(cityExample);
		    		
		    		
		    	}
		    	// each time u compare 5 values update the present max  Cities with CovidCases%
		    	if(currentLine % 5== 0 && currentLine != 0  ) {
		    		
		    		
		    		System.out.println("The top " + parametr + " cities are : ");
				    pq.printPQ();
		    		}
		    	// next line please
		    	currentLine++;
		    }
		    // at the end print again the cities
		    System.out.println("The top " + parametr + " cities are : ");
		    pq.printPQ();

		}
		//just  a catch
		catch (IOException e) {
			System.out.println("File Read Error");
	}
	
	}

}