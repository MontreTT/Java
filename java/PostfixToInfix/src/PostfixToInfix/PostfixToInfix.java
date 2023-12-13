package domesErgasia2;
import java.util.Scanner;
import domesErgasia1.StringDoubleEndedQueueImpl;

public class PostfixToInfix {
	public String inputData;
	private boolean flag = true;
	StringDoubleEndedQueueImpl queue = new StringDoubleEndedQueueImpl();
	public PostfixToInfix( ){}
	
	
	
	
	public void createListOfChars() {
		for(int i = 0 ; i < inputData.length(); i++) { 
			queue.addLast(String.valueOf(inputData.charAt(i)));
			
		}
		
		
	}
	
	
	
	public void turnPostToIn() {
		StringDoubleEndedQueueImpl temp = new StringDoubleEndedQueueImpl();
		temp.addLast(queue.removeFirst());
		temp.addLast(queue.removeFirst());
		
		while (queue.size()!= 0) {
			if(isChar(queue.getFirst().charAt(0))) {
				System.out.println("char");
				System.out.println(queue.getFirst());
				temp.addLast(queue.removeFirst());
				
			}

			else if (isOperand(queue.getFirst().charAt(0))) {
				System.out.println("operand");
				String Tes1 = temp.removeLast();
				String Tes2 = temp.removeLast();
				String tempString = "(" +  Tes2 + queue.removeFirst() + Tes1 + ")";
				temp.addLast(tempString);
				System.out.println(tempString);
			}	
			
		}
		queue = temp;
		
	}
	
	
	
	
	
	
	
	
	
	
	public void readInput() {
		do{
			Scanner myObj = new Scanner(System.in);  // Create a Scanner object
			System.out.println("Enter a Postfix sequense ");
			inputData = myObj.nextLine();
			flag = true;
			for (int i = 0 ; i < inputData.length(); i++) {
				
				if( !(isOperand(inputData.charAt(i)) ||  isChar(inputData.charAt(i)))) {
					flag = false;
				}
			}
	    }
		while(!flag);	
	}
	
	
	
	

	
	public boolean isChar(char x) {
		

	
		 return ((x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z') ||  (x >= '0' && x <= '9')); 
	}
	
	
	
	
	
	
	
	public boolean isOperand(char x){
		 if(x == '*' || x == '+' ||  x == '-' || x == '/') {
			 return true;
		 }
		 return false;
		 
	 }

}
