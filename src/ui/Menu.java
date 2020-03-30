 package ui;
 
import utilities.Utilities;


public class Menu {
	private static void doctorSubMenu (int doctor_id) {
		while (true) {
			System.out.println("Select what you want to do");
			System.out.println("\n\t1.Schedule");		
			System.out.println("\n\t2.Patient");
			String read;
			read= utilities.Utilities.read();
	        int option = Integer.parseInt(read);
	        switch (option) {
	        	case 1: //View schedule
	        		
	        		break;
	        		
	        	case 2: //Patient	
	        		//Which patient you want?
	        		Utilities.askForId();
	        		
	        		//
	        		
	        		break;
	        
	        }
	        
		}
	}
}

