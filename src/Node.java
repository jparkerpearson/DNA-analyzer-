
public class Node {
	String value;
	Node next;
	
	public Node(String s, Node link) {
		value=s;
		next=link;
	}
}
private Node myFront, myBack;
private int mySize;

