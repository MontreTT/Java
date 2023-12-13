package doMesErgasia2;

import java.io.PrintStream;
import java.util.NoSuchElementException;


public class StringDoubleEndedQueueImpl  {
	Node head =  new Node();
	private int itemNum = 0;
	
	public boolean isEmpty() {
		 if(itemNum == 0) {
		return true;}
		 return false;
	}

	
	public void addToHeap(City item) {
		if(isEmpty()) {
			head =  new Node(item);
			itemNum ++ ;
		}
		else if(itemNum == 1) {
			if( item.getPercentage() > head.returnObject().getPercentage()){
				Node newNode = new Node(head.returnObject());
				head = new Node(item);
				head.left = newNode;
				newNode.parent = head;
				itemNum ++;
			}
			else {
				Node newNode = new Node(item); 
				head.left = newNode;
				newNode.parent = head;
				itemNum ++;
			}	
		}
		else {
			Node newNode = new Node(item);
			boolean flag = false;
			Node currentNode = head; 
			while(flag ==false) {
				if(newNode.returnObject().getPercentage() < currentNode.returnObject().getPercentage()) {
					if(currentNode.left == null) {
						currentNode.left = newNode;
						newNode.parent = currentNode;
						itemNum ++;
						flag = true;
						
					}
					else if(currentNode.right == null) {
						currentNode.right = newNode;
						newNode.parent = currentNode;
						itemNum ++;
						flag = true;	
					}
					else{
						if(currentNode.left.returnObject().getPercentage() < newNode.returnObject().getPercentage() ){
							Node temp = new Node(currentNode.left.returnObject());
							currentNode.left = newNode;
							newNode.parent = currentNode;
							currentNode = temp;
						}
						else if(currentNode.right.returnObject().getPercentage() < newNode.returnObject().getPercentage()) {
							Node temp = new Node(currentNode.left.returnObject());
							currentNode.right = newNode;
							newNode.parent = currentNode;
							currentNode = temp;
						}
						else {
							if(Math.abs(newNode.returnObject().getPercentage() - currentNode.left.returnObject().getPercentage()) <=  Math.abs(newNode.returnObject().getPercentage() -currentNode.right.returnObject().getPercentage()) ) {
								currentNode = currentNode.left;
							}
							
							else {
								currentNode = currentNode.right;
							}
						}
					}
					
				}

				
			}
			
			

		}
	}

/*
	public City removeFirst() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException("No such ElementException");

		}
		else if(itemNum == 1) {
			City City1 = firstNode.returnObject();
			firstNode = new Node();
			itemNum--;
			return City1;
		}
		else{
			Node temp = firstNode;
			firstNode = firstNode.next;
			firstNode.previous = null;
			itemNum--;
			return temp.returnObject();
		}

	}

	
	public void addLast(City item) {
		if(isEmpty()) {
			lastNode = new Node(item);
			firstNode = lastNode;
			itemNum++;
		}
		else if(itemNum == 1) {
			Node currentNode = new Node(lastNode.returnObject());
			lastNode.previous = currentNode;
			currentNode.next =lastNode;
			lastNode.Object = item;
			firstNode = currentNode;
			itemNum++;
			
		}
		else {
		Node temp = new Node(lastNode.returnObject());
		temp.previous = lastNode.previous;
		lastNode.previous.next = temp;
		temp.next = lastNode;
		lastNode.previous = temp;
		lastNode.Object = item;
		itemNum++;
		// TODO Auto-generated method stub
		}
	}

	
	public City removeLast() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException("No such ElementException");
			
		}
		else if(itemNum == 1) {
			City tempString = lastNode.returnObject();
			lastNode = new Node();
			itemNum--;
			return tempString;
		
		}
		else{
			Node temp = lastNode;
			lastNode = lastNode.previous;
			lastNode.next = null;
			itemNum--;
			return temp.returnObject();
			
		}
	}


	public City getFirst() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException("No such ElementException");
		}
		else{
			return firstNode.returnObject();}
	}

	public City getLast() throws NoSuchElementException {
		if(isEmpty()) {
			throw new NoSuchElementException("No such ElementException");

		}
		else{
			return lastNode.returnObject();}
	}

	
	public void printQueue(PrintStream stream) {
		// TODO Auto-generated method stub
		Node temp = firstNode;
		for(int i  =0 ; i <itemNum;i++ ) {
			
		stream.print(temp.returnObject().getName());
		temp = temp.next;
		
		}
	}

*/	
	public int size() {
		return itemNum;
	}
	

}
