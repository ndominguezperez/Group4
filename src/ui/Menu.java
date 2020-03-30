package ui;
import pojos.*;
 

//import utilities.Utilities;


public class Menu {
	private static void doctorSubMenu (int doctor_id) {		
		int option;
			do {
				System.out.println("Select what you want to do");
				System.out.println("\n\t1.Schedule");		
				System.out.println("\n\t2.Patient");
				System.out.println("\n\t3.Exit");
				option = utilities.Exceptions.checkInt();
			
	        switch (option) {
	        	case 1: //View schedule
	        		System.out.println("\n\n\tYour schedule Doctor:%d \n" + doctor_id);
	        		utilities.Utilities.getDoctorSchedule(doctor_id); //Tener que meter el doctor_id
	        		utilities.Utilities.read();
	        		break;
	        		
	        	case 2: //Patient	
	        		System.out.println("\nHow do you want to search your patient?");
	        		System.out.println("\n\t1.By name");
	        		System.out.println("\n\t2.By surname");
	        		System.out.println("\n\t3.By id");
	        		System.out.println("\n\t4.I don´t want to search a patient");
	        		int patient_option;
	        		do {
	        		patient_option = utilities.Exceptions.checkInt();}
	        		while (patient_option != 1 || patient_option != 2|| patient_option != 3 || patient_option != 4);
	        		switch (patient_option) {
	        			case 1: 
	        				System.out.println("Patient searched by name");
	        				utilities.Utilities.searchPatientByName();
	        				utilities.Utilities.read();
	        				break;
	        			case 2: 
	        				System.out.println("Patient searched by surname");
	        				utilities.Utilities.searchPatientBySurname();
	        				utilities.Utilities.read();
	        				break;
	        			case 3: 
	        				System.out.println("\nPatient searched by id");
	        				utilities.Utilities.getPatientById();
	        				utilities.Utilities.read();
	        				break;
	        			case 4: 
	        				utilities.Utilities.read();
	        				break;
	        		}
	        		break;
	        	case 3: 
	        		break;	        		
	        		
	        }
	        
	        }while (option !=1 || option !=2 || option != 3);
	        
		}

}

