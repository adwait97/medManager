import models.Managers;
import models.Owners;
import models.Workers;

public class WorkerFactory {
	
	public Workers getWorker(int mid, String fn, String ln, String pw, String em) {
		if(fn.contentEquals("--OWNER--")) {
			System.out.println("Factory produced --> Owner object");
			return new Owners(mid);
		}
		else {
			System.out.println("Factory produced --> Worker object");
			return new Managers(mid, fn, ln, pw, em);
		}
	}

}
