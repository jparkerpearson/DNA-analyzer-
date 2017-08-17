import java.util.ArrayList;


public class EmergencyNetwork {
	public int lagTime(int[] bosses) {
		
		return minLag(0,bosses);
	}

	public int minLag(int me, int[] bossArray) {
		// find the time it takes subords
		ArrayList<Integer> subords= new ArrayList<Integer>();
		
		// sort the time 
		// incremently 1, 2, 3, .... 1st, 2nd, 3rd sorted child
		
		
		
		//base case for leaf (no subordinates)
		return 0;
	}
}
