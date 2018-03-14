import java.util.stream.Collectors;

public class Operator {
	public int From;
	public int To;
	public Operator(int from, int to) {
		super();
		From = from;
		To = to;
	}
	
	public boolean preconditionFulfilled(Jug jug) {
		return jug.Contents[From] != 0
				&& jug.Contents[To] != Jug.Capacities[To];
	}
	
	public Jug use(Jug jug) {
		Jug result = new Jug();
		
		int volume = Math.min(jug.Contents[From], Jug.Capacities[To] - jug.Contents[To]);
		
		int indexUntouched = Jug.Indices.stream().filter(i -> i != From && i!= To).collect(Collectors.toList()).get(0);
		
		result.Contents[From] = jug.Contents[From] - volume;
		result.Contents[To] = jug.Contents[To] +  volume;
		result.Contents[indexUntouched] = jug.Contents[indexUntouched];
		
		return result;
	}

	@Override
	public String toString() {
		return "Operator [From=" + From + ", To=" + To + "]";
	}

}
