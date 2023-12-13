package doMesErgasia2;



public class Node {
	Node left;
	Node right;
	Node parent;
	City Object;
	public Node(City Object ){
		left = null;
		right  = null;
		parent = null ;
		this.Object = Object;
		
		
	}
	public Node() {
		left=null;
		right = null;
	}
 public City  returnObject() {
	 return Object;
 }
}
