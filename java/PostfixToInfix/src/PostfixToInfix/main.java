package domesErgasia1;
import domesErgasia2.PostfixToInfix; 
import domesErgasia2.DNAPalindrome;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringDoubleEndedQueueImpl queue =  new StringDoubleEndedQueueImpl();
		StringDoubleEndedQueueImpl queue1 =  new StringDoubleEndedQueueImpl();
	
		queue1.addLast("x");
		queue1.addLast("y");
		queue1.addLast("*");
		queue1.addLast("5");
		queue1.addLast("z");
		queue1.addLast("*");
		queue1.addLast("/");
		queue1.addLast("8");
		queue1.addLast("+");;
		queue1.printQueue(System.out);
		PostfixToInfix a = new PostfixToInfix();
		a.readInput();
		a.createListOfChars();
		
		
	}
	
}
