package ui.utilities;


import java.util.List;

import pojos.Appointment;
import pojos.Doctor;
import pojos.Patient;
import pojos.users.User;
import ui.Menu;

public class Action {
	public static void doctorSubMenu(Doctor doctor) throws Exception {
		int option;
		do {
			System.out.println("Select what you want to do");
			System.out.println("\n\t1.See Your schedule");
			System.out.println("\n\t2.List all your patients");
			System.out.println("\n\t3.Patient");
			System.out.println("\n\t4.Settings");
			System.out.println("\n\t0.Back");
			option = Exceptions.checkInt();
			switch (option) {
			case 1: 
				Utilities.getDoctorSchedule(doctor.getId());
				break;
			case 2:
				Utilities.listAllPatientsOfDoctor(doctor);
				break;
			case 3: 
				Patient patient = searchPatientMenu();
				if(patient!=null) {
					doctorPatientMenu(patient, doctor);
				}
				break;
			case 4: 
				String username=doctor.getUser().getUsername();
				User user=Menu.userManager.getUser(username);
				settingsMenu(user);
				break;
			case 0:
			     return;

			}

		} while (option != 0);

	}

	private static void doctorPatientMenu(Patient patient, Doctor doctor) throws Exception {
		int option;
		do {
		System.out.println("Select what you want to do");
		System.out.println("\n\t1.Create Examinations");
		System.out.println("\n\t2.View Examinations");
		System.out.println("\n\t3.Create Treatment");
		System.out.println("\n\t4.Modify Treatment");
		System.out.println("\n\t5.Delete Treatment");
		System.out.println("\n\t6.View Treatment");
		System.out.println("\n\t0.Back");
			option = Exceptions.checkInt();
			switch (option) {
			case 1:
				Adds.addExamination(patient, doctor);
				break;
			case 2:
				Utilities.viewExaminations(patient);
				break;
			case 3:
				Adds.addTreatment(patient, doctor);
				break;
			case 4:
				Sets.modifyTreatment(patient, doctor);
				break;
			case 5:
				Delete.deleteTreatment(patient, doctor);
				break;
			case 6:
				Utilities.viewTreatments(patient);
				break;
			case 0:
				return;
			}
		} while (option != 0);

	}

	public static void patientSubMenu(Patient patient) throws Exception {
		int option;
		do {
			System.out.println("Select what you want to do");
			System.out.println("\n\t1.Schedule");
			System.out.println("\n\t2.See examinations");
			System.out.println("\n\t3.Settings");
			System.out.println("\n\t0.Back");
			option = Exceptions.checkInt();
			switch (option) {
			case 1:
				Utilities.getPatientSchedule(patient.getId());
				break;
			case 2:
				Utilities.viewExaminations(patient);
				break;
			case 3:
				String username=patient.getUser().getUsername();
				User user=Menu.userManager.getUser(username);
				settingsMenu(user);
				break;
			case 0:
				return;
			}
		} while (option != 0);
	}

	private static Patient searchPatientMenu() {
		System.out.println("\n\t1.To search by id number");
		System.out.println("\n\t2.To search by name");
		System.out.println("\n\t3.To search by surname");
		int option = Exceptions.checkInt();
		Patient p = null;
		boolean yes=false;
		switch (option) {
		case 1:
			p = Exceptions.checkPatient();
			if(p==null) {
				System.out.println("This patient doesn't exist");
			}else {		
				System.out.println(p+"\n");
			}
			break;
		case 2:
			yes = Utilities.searchPatientByName();
			if(yes) {
				p = Exceptions.checkPatient();
			}
			System.out.println(p+"\n");
			break;
		case 3:
			yes = Utilities.searchPatientBySurname();
			if(yes) {
				p = Exceptions.checkPatient();
			}
			System.out.println(p+"\n");
			break;
		case 0:
			return  p ;
		}
		return p;
	}

	public static void adminMenu(User user) throws Exception {
		int option;
		do{
			System.out.println("\nSelect what you want to do");
			System.out.println("\n\t1.List all patients");
			System.out.println("\n\t2.View a patient");
			System.out.println("\n\t3.Delete a patient");
			System.out.println("\n\t4.Appointments");
			System.out.println("\n\t5.Set up appointment with XML");
			System.out.println("\n\t6.Generate XML");
			System.out.println("\n\t7.Settings");
			System.out.println("\n\t0.Back");
			option= Exceptions.checkInt();
			switch (option) {
			case 1:
				Utilities.listAllPatiens();
				break;
			case 2:
				searchPatientMenu();
				break;
			case 3:
				Patient p2=searchPatientMenu();
				if(p2!=null) {
					Delete.deletePatient(p2);
				}else {
					System.out.println("This patient doesn't exist");
				}
				break;
			case 4:
				appointmentMenu(user);
				break;
			case 5:
				Utilities.setUpAppointmentByXML();
				break;
			case 6:
				boolean doc= Exceptions.chooseDocOrPat();
				int id;
				if (doc) {
					Utilities.listAllDoctors();
					Doctor doctor =Exceptions.checkDoctor();
					List <Appointment> a=Utilities.getDoctorScheduleList(doctor.getId());
					if(a.size()>=1) {
						id=Utilities.askForId();
						Utilities.generateXML(id);
					}else{
						System.out.println("There are no appointments");
					}
				}else {
					Patient patient=searchPatientMenu();
					List <Appointment> a=Utilities.getPatientScheduleList(patient.getId());
					if(a.size()>=1) {
						id=Utilities.askForId();
						Utilities.generateXML(id);
					}else{
						System.out.println("There are no appointments");
					}
				}
				
				break;
			case 7:
				settingsMenu(user);
				break;
			case 0:
				return;

			}
		}while (option!=0);
		
	}

	private static void appointmentMenu(User user) throws Exception {
		int option ;
		do {
		System.out.println("Select what you want to do");
		System.out.println("\n\t1.Set Up a new one");
		System.out.println("\n\t2.Modify appointment");
		System.out.println("\n\t3.Search appointment by date");
		System.out.println("\n\t4.Delete appointment ");
		System.out.println("\n\t0.Back");
		 option = Exceptions.checkInt();
		Patient p ;
		switch (option) {
		case 1:
			System.out.println("Patient: ");
			p = searchPatientMenu();
			if(p!=null) {
				Adds.addAppointment(p);
			}
			break;
		case 2:
			System.out.println("From what patient do you want to modify the appointment: ");
			p = searchPatientMenu();
			if(p!=null) {
				Sets.modifyAppointment(p);
			}
			break;
		case 3:
			Utilities.searchAppointmentByDate();
			break;
		case 4:
			System.out.println("From what patient do you want to delete the appointment: ");
			p = searchPatientMenu();
			if(p!=null) {
				Delete.deleteAppointment(p);
			}
			break;
		case 0:
			return;

		}
		}while(option!=0);
	}
	
	private static void settingsMenu(User user) {
		int option ;
		do {
		System.out.println("\n\t1.Delete user");
		System.out.println("\n\t2.Modify password");
		System.out.println("\n\t0.Back");
	   option = Exceptions.checkInt();
		switch (option) {
		case 1:
				String username=null;
				int n =user.getRole().getId();
				boolean sure=false;
				switch(n) {
					case 1:
						System.out.println("A doctor can not be deleted");
						break;
					case 2: 
						username=user.getUsername();
						Patient patient = Menu.patientManager.getPatientByUsername(username);
						sure=Delete.deletePatient(patient);
						if(sure) {
						Menu.userManager.deleteUser(user);
						System.out.println("\nDeleted succed");
						try {
							Menu.Beginning();
						} catch (Exception e) {
							System.out.println("Something went wrong");
							e.printStackTrace();
						}
						break;
						}else {
							break;
						}
					case 3:
						sure=Exceptions.reconfirmation();
						if(sure) {
						Menu.userManager.deleteUser(user);
						System.out.println("\nDeleted succed");
						try {
							Menu.Beginning();
						} catch (Exception e) {
							System.out.println("Something went wrong");
							e.printStackTrace();
						}
						break;
						}else {
					    	break;
						}
				}
				break;
		case 2:
			Menu.userManager.modifyPassword(user);
			break;
		case 0:
			return;

		}
		}while(option!=0);
	}
	

}
