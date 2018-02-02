import com.archlogixdevelopertest.controllers.FileProcessor;
import com.archlogixdevelopertest.controllers.PathUtils;
import com.archlogixdevelopertest.controllers.PostController;
import com.archlogixdevelopertest.models.Employee;

public class ArchLogixDeveloperTestApplication {
	
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("One argument required: Path to file.");
			System.out.println("ex. Payroll/Timesheets/Hours 07242017-07282017.csv");
			System.out.println("File must be named: \"Hours MMDDYYYY-MMDDYYYY.csv");
		}
		else {
			String path = args[0];
			System.out.println(path);
			if(System.getProperty("os.name").toLowerCase().contains("windows")) {
				path = PathUtils.pathConverter(path);
			}
			PostController.clearHours();
			FileProcessor.fileProcessor(path);			
		}
	}

}
