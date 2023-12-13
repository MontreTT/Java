package domes2;

//Class heapSort 
public class Heapsort {
	private  City[] heapArray;
	
	
	public Heapsort(City[] vectorText){
		this.heapArray = vectorText;
			
	}
	public Heapsort() {}
	
	
	
	// boolean reversed is for a max heap or a min heap 
	public  void heapSort( int length , boolean reversed) {
		length--; 
		// this is to create the heap.  Start a level before leafs  and pick the max from the 3 nodes(parent , left child , right child) then go one level above 
		// and do the same thing till u reach the root 
		// then u have a heap 
		for (int i = (length+1/ 2)-1; i >= 0; i--) {
			heapify(heapArray, i, length , reversed);
		 }
		
		 
		 //after u have the heap ready , exchange first(max) and last element from list then the last item will be the max.Isolate it
		// for the size-1 now heap make it a heap again by calling heapify function
		// then its a heap , second max will be on first element now , witch with size-2 position the call heapify
		// do this size times and u get sorted array
		 for(int j= length; j>=0; j--) {
			 
			 City temp = new City( heapArray[0].getID(),heapArray[0].getName(),heapArray[0].getPopulation(),heapArray[0].getCovidCases());
			 heapArray[0] = new City( heapArray[j].getID(),heapArray[j].getName(),heapArray[j].getPopulation(),heapArray[j].getCovidCases()) ;
		     heapArray[j]= new City(temp.getID(),temp.getName(),temp.getPopulation(),temp.getCovidCases());
		     
		     heapify(heapArray, 0, j-1 , reversed);
				 
		         }
		 	
		     
		   }


	//heapify makes the array a heap by changing its elements position if reversed then it makes it  a min heap , else max heap
	// get a node index , then compare it to it's children, then his child with his children and etc... do this till u reach the end of the array boundaries 
	
	public void heapify (City[] heapArray, int node, int heapSize , boolean reversed) {
		if(reversed == false) {
		int left = 2*node +1 ;
		int right = 2*node +2 ;
		int indexMAX = node;
	    if (left<= heapSize && comparedTo(heapArray[left],  heapArray[node])) {
	    	indexMAX = left;
	    }
			      
	    if (right <= heapSize && comparedTo(heapArray[right],  heapArray[indexMAX])) {
	    	indexMAX = right;
		}
		if (indexMAX != node) {
			
			City temp = new City(heapArray[node].getID(),heapArray[node].getName(),heapArray[node].getPopulation(),heapArray[node].getCovidCases());
			heapArray[node]= new City(heapArray[indexMAX].getID(),heapArray[indexMAX].getName(),heapArray[indexMAX].getPopulation(),heapArray[indexMAX].getCovidCases());
			heapArray[indexMAX] =  new City( temp.getID(),temp.getName(),temp.getPopulation(),temp.getCovidCases());
			heapify(heapArray, indexMAX, heapSize , reversed );
			     }}
		if(reversed == true) {
			int left = 2*node +1 ;
			int right = 2*node +2 ;
			int indexMIN = node;
		    if (left<= heapSize && comparedTo(heapArray[node],heapArray[left]  )) {
		    	indexMIN = left;
		    }
				      
		    if (right <= heapSize && comparedTo(heapArray[indexMIN],heapArray[right]  )) {
		    	indexMIN = right;
			}
			if (indexMIN != node) {
				
				City temp = new City(heapArray[node].getID(),heapArray[node].getName(),heapArray[node].getPopulation(),heapArray[node].getCovidCases());
				heapArray[node]= new City(heapArray[indexMIN].getID(),heapArray[indexMIN].getName(),heapArray[indexMIN].getPopulation(),heapArray[indexMIN].getCovidCases());
				heapArray[indexMIN] =  new City( temp.getID(),temp.getName(),temp.getPopulation(),temp.getCovidCases());
				heapify(heapArray, indexMIN, heapSize , reversed );
			
		}
		   }}
	
	
	// comparedTo just compares fast  2 cities.percentages
	// in case of equality ,aplhabet wins
	public boolean comparedTo(City a , City b) {
		if( a != null && b != null) {
			if (a.getPercentage().compareTo( b.getPercentage()) >0 ){
				return true;
		}
			else if(a.getPercentage().compareTo( b.getPercentage()) == 0) {
				int compare = a.getName().compareTo(b.getName());  

				if (compare < 0) {  
			    
					return true;
				}
				else if (compare > 0) {
			    return false;
				}
				else {  
					return false;
				} 
			}
			return false;}
		
	  return false;
	}
}


