package domesErgasia2;

import domesErgasia1.Queue;
import domesErgasia1.StringDoubleEndedQueueImpl;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			StringDoubleEndedQueueImpl queue1 =  new StringDoubleEndedQueueImpl();
			//x y ^ 5 z * / 10 +
			/**
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
			**/
			DNAPalindrome  maou = new DNAPalindrome();
			maou.input();
			maou.queue.printQueue(System.out);
			System.out.println(maou.isReversed());
			//a.queue.printQueue(System.out);
			//System.out.println("\n");
			//a.turnPostToIn();
			//a.queue.printQueue(System.out);

			
			
			
			
			
	}

}
