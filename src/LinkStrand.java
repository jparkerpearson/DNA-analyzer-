

public class LinkStrand implements IDnaStrand{

	
public class Node {
	String value;
	Node next;
	
	public Node(String s, Node link) {
		value=s;
		next=link;
	}
}
private Node myFront, myBack;
private long mySize;
private int myAppends;


	
	public LinkStrand() {
		this("");
	}
	
	public LinkStrand(String string) {
		initializeFrom(string);
	}

	public IDnaStrand cutAndSplice(String enzyme, String splicee) {
		// TODO Auto-generated method stub	
		if(myFront.next != null) {throw new RuntimeException("link strand has more than one node");}
		 int pos = 0;
	        int start = 0;
	        String search = this.toString();
	        boolean first = true;
	        LinkStrand ret = null;
	        
	        /*
	         * The next line is very syntax-dense. .indexOf looks for the 
	         * first index at which enzyme occurs, starting at pos. Saying 
	         * pos = ... assigns the result of that operation to the pos
	         * variable; the value of pos is then compared against zero.
	         * 
	         * .indexOf returns -1 if enzyme can't be found. Therefore, this
	         * line is:
	         * 
	         * "While I can find enzyme, assign the location where it occurs
	         * to pos, and then execute the body of the loop."
	         */
	        while ((pos = search.indexOf(enzyme, pos)) >= 0) {
	            if (first){
	                ret = new LinkStrand(search.substring(start, pos));
	                first = false;
	            }
	            else {
	                 ret.append(search.substring(start, pos));
	                 
	            }
	           
	            start = pos + enzyme.length();
	            ret.append(splicee);
	            pos++;
	        }

	        if (start < search.length()) {
	        	// NOTE: This is an important special case! If the enzyme
	        	// is never found, return an empty String.
	        	if (ret == null){
	        		ret = new LinkStrand("");
	        	}
	        	else {
	        		ret.append(search.substring(start));
	        	}
	        }
	        return ret;
    }


	@Override
	public long size() {
		return mySize;
	}

	@Override
	public void initializeFrom(String source) {
		myFront = new Node(source,null);
		myBack = myFront;
		mySize = source.length();
	}

	@Override
	public String strandInfo() {
		 return this.getClass().getName();
	}

	@Override
	public IDnaStrand append(IDnaStrand dna) {
		// TODO Auto-generated method stub
		
		if (dna instanceof LinkStrand) {
			myAppends++;
            LinkStrand ls = (LinkStrand) dna;
            Node curr=myBack;
            curr.next=ls.myFront;
            myBack=ls.myBack;
            mySize+=dna.toString().length();
            return this;
        } else {
            return append(dna.toString());
        }
	}

	@Override
	public IDnaStrand append(String dna) {
		// TODO Auto-generated method stub
		myAppends++;
		mySize+=dna.length();
		Node curr=myBack;
		    curr.next = new Node(dna, null);
		    myBack=curr.next;
		    return this;
	}

	@Override
	public IDnaStrand reverse() {
		Node current = myFront;
		Node left = null;
		myBack = myFront;
		while (current != null) {
			StringBuilder reverser = new StringBuilder(current.value);
	        current.value = reverser.reverse().toString();
			
			Node right = current.next;
			current.next = left;
			left = current;
			myFront = current;
			current = right;
		}
		
		return this;
	}

	@Override
	public String getStats() {
		return String.format("# append calls = %d",myAppends);
	}
	
	public String toString() {
		Node current = myFront;
		// String ret= current.value;
		String ret = "";
		while (current != null)	{
			ret = ret + current.value;
			current = current.next;
		}
		return ret;
	}

}
