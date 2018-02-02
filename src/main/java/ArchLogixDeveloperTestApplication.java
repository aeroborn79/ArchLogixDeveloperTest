import com.archlogixdevelopertest.controllers.PathValidator;

public class ArchLogixDeveloperTestApplication {
	
	public static void main(String[] args) {
		
		if(args.length != 1) {
			System.out.println("One argument required: Path to file.");
			System.out.println("ex. C:/Users/Joe User/Documents/Hours 07242017-07282017.csv");
		}
		else PathValidator.pathValidator(args[0]);
	}

}
