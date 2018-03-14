import java.util.Arrays;
import java.util.List;

public class Jug {
	// Kancsó
	
	public int[] Contents = new int[3];
	public static int[] Capacities = {2, 3, 5};
	
	public static List<Integer> Indices = Arrays.asList(0, 1, 2);
	
	public Jug() {
		
	}
	
	public Jug(int[] contents) {
		Contents[0] = contents[0];
		Contents[1] = contents[1];
		Contents[2] = contents[2];

	}

	@Override
	public String toString() {
		return "Jug [Contents=" + Arrays.toString(Contents) + "]";
	}
	
	
}
