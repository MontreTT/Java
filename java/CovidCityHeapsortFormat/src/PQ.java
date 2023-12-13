package domes2;


public class PQ {
	Heapsort heapy;



	    private City[] heap; // the heap to store data in
	    private int size; // current size of the queue
	    
	    Heapsort a = new Heapsort();
	    private static final int DEFAULT_CAPACITY = 4; // default capacity

	    public PQ() {
	        this.heap = new City[DEFAULT_CAPACITY + 1];
	        this.size = 0;
	        
	    }


	    // matches id with id of city in list and removes it , u need to make rest of array heap again,
	    // thats why u call heapify(written in Heapsort)
	    public  City removeID(int ID) {
	    	for(int i = 0 ; i < size ; i++) {
	    		if(heap[i].getID() == ID) {
	    			City temp = heap[i];
	    			heap[i] =  new City(heap[size].getID(),heap[size].getName(), heap[size].getPopulation() , heap[size].getCovidCases());
	    			size--;
	    			heapy = new Heapsort(heap);
	    			heapy.heapify(heap, i, size, true);
	    			return temp;
	    		}
	    	}
	    	return null;
	    	
	    }
	    // checks if its empty , instance sizes gives u that ,O(1)
	    public boolean isEmpty() {
	    	if(size == 0 ) {
	    		return true;
	    	}
	    	return false;
	    }
	    
	    public int size() {
	    	return size;
	    }
	    
	    
	    // check if size is greater equal to 3/4 of heap length if so it doubles it
	    //add item at the end then make it   again a heap by calling heapify
	    // each time u check parent and children , then compare parents parent with its children  and etc
	    // each time number is halved so u need O(log(n)) steps 
	    public void add(City item) {
	        // Check available space
	        if (size >= heap.length * (3/4)) {
	            grow();
	        }
	        if (size >0) {
	        // Place item at the next available position
	        	
	        	heap[size] = item;
	        	size ++;
	        
	        // Let the newly added item swim
	        	heapy= new Heapsort(heap);
	        	for (int i = size ; i > 0 ; i = i/2) {
	        	heapy.heapify(heap, i/2, size-1, true);
	        	}
	        }
	        else {
	        	heap[0] = item;
	        	size++;
	        }
	    }

	    public City min() {
	        // Ensure not empty
	        if (size == 0)
	            return null;

	        // return root without removing
	        return heap[0];
	    }


	   // get minimum from array which is heap[0] 
	   // last item goes first then
	   // then make it a heap again 
	    
	    public City getMin() {
	        // Ensure not empty
	        if (size == 0) {
	            return null;
	        }
	        
	        
				 
				 
			City root = heap[0];		 
			heap[0] =   new City(heap[size-1].getID(),heap[size-1].getName(), heap[size-1].getPopulation() , heap[size-1].getCovidCases());
	        size--;  
	     
	        
	    	

	        // Dispose the rightmost leaf
	        // Sink the new root element
	        heapy= new Heapsort(heap);
	        heapy.heapify(heap, 0, size , true);
	    	
	        // Return the int removed
	        return root;
	    }
	    // when called make the  arrays size x2
	    private void grow() {
	    	City[] newHeap = new City[heap.length + size];

	       // copy array
		   //(notice: in the priority queue, elements are located in the array slots with positions in [1, size])
	       for (int i = 0; i <  size; i++) {
	           newHeap[i] = heap[i];
	       }
	      

	        heap = newHeap;
	    }
	    
	    // sortcut to print required items at the end
	    public void printPQ() {
	    	for(int i = size; i > 0; i --) {
	    		a = new Heapsort(heap);
	    		a.heapSort(size, false);
	    		System.out.println(heap[i-1].getName()+ "    " + heap[i-1].getPercentage());
	    		
	    	}
	    }
	    // return array with cities
	    public City[] returnArray() {
	    	
	    	return heap;
	    }
	}



