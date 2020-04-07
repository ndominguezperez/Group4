package ui;
import db.interfaces.DBManager;
import pojos.*;
import utilities.Exceptions;
import utilities.Utilities;
import java.util.List;

import db.interfaces.*;
 import utilities.Utilities;


public class Menu {
	
	// DB Managers
		private static DBManager dbManager;
		private static PatientManager patientManager;
		private static DoctorManager medicineManager;

	public static void main(String[] args){
		int option;
		System.out.println("Select who you are");
		System.out.println("\n\t1.Doctor");		
		System.out.println("\n\t2.Patient");
		System.out.println("\n\t3.Admin Staff");
		System.out.println("\n\t4.Exit");
		do {
		option=Exceptions.checkInt();
		switch(option) {
		case 1:
			doctorMenu();
			break;
		case 2:
			patientMenu();
	        break;
		case 3: 
			adminMenu();
			break;
		case 4:
			System.exit(0);
		}
		}while(option != 4);
	}
	
	//Esto seria con la contraseña y eso supongo....
	private static void doctorMenu () {		
	  Doctor doctor= Utilities.getDoctortById();
	  if (doctor==null) {
		return;
	  }
	   else {// esta funcion mal
		doctorSubMenu(doctor.getId());
	     }
	}
	private static void doctorSubMenu (int doctor_id) {		
		int option;
			do {
				System.out.println("Select what you want to do");
				System.out.println("\n\t1.Schedule");		
				System.out.println("\n\t2.Patient");
				System.out.println("\n\t3.Exit");
				option = Exceptions.checkInt();
			
	        switch (option) {
	        	case 1: //View schedule
	        		System.out.println("\n\n\tYour schedule Doctor:%d \n" + doctor_id);
	        		Utilities.getDoctorSchedule(doctor_id); //Tener que meter el doctor_id
	        		Utilities.read();
	        		break;
	        		
	        	case 2: //Patient	
	        		System.out.println("\nHow do you want to search your patient?");
	        		System.out.println("\n\t1.By name");
	        		System.out.println("\n\t2.By surname");
	        		System.out.println("\n\t3.By id");
	        		System.out.println("\n\t4.I don´t want to search a patient");
	        		int patient_option;
	        		do {
	        		patient_option = Exceptions.checkInt();}
	        		while (patient_option != 1 || patient_option != 2|| patient_option != 3 || patient_option != 4);
	        		switch (patient_option) {
	        			case 1: 
	        				System.out.println("Patient searched by name");
	        				Utilities.searchPatientByName();
	        				Utilities.read();
	        				break;
	        			case 2: 
	        				System.out.println("Patient searched by surname");
	        				Utilities.searchPatientBySurname();
	        				Utilities.read();
	        				break;
	        			case 3: 
	        				System.out.println("\nPatient searched by id");
	        				Utilities.getPatientById();
	        				Utilities.read();
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
	private static void patientMenu() {	
		System.out.println("Select what you want to do");
		System.out.println("\n\t1.Schedule");
		System.out.println("\n\t2.See examinations");
		System.out.println("\n\t3.G0 back");
		int option= Exceptions.checkInt();
		Patient p;
		 switch(option) {
		  case 1:
			  p=searchPatientMenu();
			  Utilities.getPatientSchedule(p.getId());
			  break;
		  case 2:
			  p=searchPatientMenu();
			  List <Examination> a=p.getExaminations();
			  break;
		  case 3:
			 return;
		  }
	}
	private static Patient searchPatientMenu() {
		  System.out.println("\n\t1.To search by id number");
		  System.out.println("\n\t2.To search by name");
		  System.out.println("\n\t3.To search by surname");
		  System.out.println("\n\tIf you want to go back press 0");
		  int option= Exceptions.checkInt();
		  Patient p=null;
		  switch(option) {
		  case 1:
			  p= Utilities.getPatientById();
			  break;
		  case 2:
			  Utilities.searchPatientByName();
			  p= Utilities.getPatientById();
			  break;
		  case 3:
			  Utilities.searchPatientBySurname();
			  p= Utilities.getPatientById();
			  break;
		  case 0:
			 break;
		  }
		  return p;
	}
	
	private static void adminMenu() {
		System.out.println("Select what you want to do");
		System.out.println("\n\t1.List all patients");		
		System.out.println("\n\t2.View a patient");
		System.out.println("\n\t3.Add a new patient");
		System.out.println("\n\t4.Appointmets");
		System.out.println("\n\t5.Exit");
		int option = Exceptions.checkInt();
		switch(option) {
		case 1:
			Utilities.listAllPatiens();
			break;
		case 2:
			searchPatientMenu();
		    break;
		case 3:
			Utilities.addPatient();
		    break;
		case 4:
			appointmentMenu();
			break;
		case 5:
			return;
			
		}
	}
	private static void appointmentMenu() {
		Patient p= searchPatientMenu();
		System.out.println("Select what you want to do");
		System.out.println("\n\t1.Set Up a new one");		
		System.out.println("\n\t2.Modify");
		System.out.println("\n\t3.Search appointment by date");		
		System.out.println("\n\t4.Exit");
		int option = Exceptions.checkInt();
		switch(option) {
		case 1:
			//funcion sin hacer!!! 
			Utilities.setUpAppointment(p);
		case 2:
			
			Utilities.modifyAppointment(p);
		    break;
		case 3:
			appointmentMenu();
			
		}

	}

}

