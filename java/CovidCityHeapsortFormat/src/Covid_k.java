package domes2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class Covid_k {


	public static void main(String[] args) {
		
		
		

		//read file
		try(BufferedReader in = new BufferedReader(new FileReader(args[0]))) {
			Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		    System.out.println("Please give parameter k");
		    int   parametr = Integer.parseInt(myObj.nextLine());
		    String str;
		    //text's number of lines
		    int lines = NumberOfLines(args[0]);
		    //currentline
		    int currentLine = 0 ;
		    //array that has all city objects
		    City[] vectorText =  new City[lines];
		    while ((str = in.readLine()) != null) {
		    	//string that has lines's words at index 0 ,1 ,2 ,3
		    	String[] tokens = str.split(" ");
		    	if(Integer.parseInt(tokens[0])<= 999 && Integer.parseInt(tokens[0]) >= 1 && Integer.parseInt(tokens[3]) < Integer.parseInt(tokens[2]) && Integer.parseInt(tokens[3]) > 0 && Integer.parseInt(tokens[2]) > 0 && Integer.parseInt(tokens[2]) < 10000000) {
		    		City cityExample = new City(Integer.parseInt(tokens[0]),tokens[1],Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]));
		    		vectorText[currentLine] 	  = cityExample  ;
		    		currentLine++;
		    	
				    
		    	}
		    	else {
		    		System.out.println("Error in data input");
		    		break;
		    	}
		    }	
		    Heapsort hipster = new Heapsort(vectorText);
		    hipster.heapSort(vectorText.length , false);
		    System.out.println("The top k cities are : ");
			for(int i = vectorText.length-1 ; i >= vectorText.length-parametr ; i--) {
			    System.out.println(vectorText[i].getName() );
			}
		    
		    
		    
		}
		catch (IOException e) {
		    System.out.println("File Read Error");
		}
		

		

}

public static int NumberOfLines(String text) throws IOException {
    try (Stream<String> fileStream = Files.lines(Paths.get(text))) {
        int noOfLines = (int) fileStream.count();
        return noOfLines;
    }

}}
