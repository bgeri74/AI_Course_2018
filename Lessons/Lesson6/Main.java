import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static boolean isGoalState(Jug jug) {
		// Az utolsó kancsóban 4 liter van
		return jug.Contents[2] == 4; 
	}
	
	public static void sleep(int duration) {
		try {
			Thread.sleep(duration * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static Jug actualState;
	
	public static List<Operator> operators = Arrays.asList(
			new Operator(0, 1),
			new Operator(0, 2),
			new Operator(1, 0),
			new Operator(1, 2),
			new Operator(2, 0),
			new Operator(2, 1)
			);
	
	public static void main(String[] args) {
		Jug start = new Jug(new int[] {0, 0, 5});
		
		actualState = start;
		
		while(true) {
			if(isGoalState(actualState)) {
				break;
			}
			
			List<Operator> operatorsAvailable = 
					operators.stream()
					.filter(o -> o.preconditionFulfilled(actualState))
					.collect(Collectors.toList());
			
			if(!operatorsAvailable.isEmpty()) {
				Operator operator = operatorsAvailable.get(0);
				
				actualState = operator.use(actualState);
				
				System.out.println(actualState);
				
				sleep(1);
			}
			else {
				break;
			}
		}
		
		if(isGoalState(actualState)) {
			System.out.println(actualState);
		}
		else {
			System.out.println("Sikertelen keresés. ");
		}
	}

}
