package domesErgasia2;
import java.util.Scanner;
import java.util.stream.Stream;
import domesErgasia1.Queue;
import domesErgasia1.StringDoubleEndedQueueImpl;



public class DNAPalindrome {
	StringDoubleEndedQueueImpl queue = new StringDoubleEndedQueueImpl();
	private String inputData;
	boolean flag = true;
	boolean flagReverse = true ;
	public DNAPalindrome() {
		
	}
	
	public boolean isReversed() {

	  for(int i = 0 ; i < queue.size(); i++) {
		  if (queue.size() >= 2) {
			  if(!(lexigram(queue.removeLast().charAt(0)) == queue.removeFirst().charAt(0))) {
				
				  
				  return false;
			  }

		  }
	  }
	  return true;
	}
	
	
	private char  lexigram(char x) {
		 if(x == 'A' ) {
			 return 'T';
			 
		 }
		 else if(x == 'T' ) {
			 return 'A';
			 
		 }
		 else if(x == 'C') {
			 return 'G';
			 
		 }
		 else if(x == 'G'){
			 return 'C';
			 
		 }
		 return '0';
		
	}
	
	
	public void input() {
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Enter the DNA sequence");
		inputData = myObj.nextLine();
		;
		for (int i = 0 ; i < inputData.length(); i++) {
			
			if( !(inputData.charAt(i) == 'A' ||  inputData.charAt(i) == 'T' ||  inputData.charAt(i)  == 'G' || inputData.charAt(i) == 'C' )) {
				flag = false;
				break;
			}
			queue.addLast(String.valueOf(inputData.charAt(i)));
		}
		if(flag == false) {
			System.out.println("invalid input sorry");
		}
	}
}
