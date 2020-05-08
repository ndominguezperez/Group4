package ui.utilities;

import java.util.List;

import pojos.Doctor;
import pojos.Examination;
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
			case 1: // View schedule
				Utilities.getDoctorSchedule(doctor.getId());
				doctorSubMenu(doctor);
				break;
			case 2:
				Utilities.listAllPatientsOfDoctor(doctor);
				doctorSubMenu(doctor);
				break;
			case 3: // Patient
				Patient patient = searchPatientMenu();
				if(patient!=null) {
					doctorPatientMenu(patient, doctor);
				}
				doctorSubMenu(doctor);
			case 4: 
				String username=doctor.getUser().getUsername();
				User user=Menu.userManager.getUser(username);
				settingsMenu(user);
			case 0:
			     Menu.Menu();

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
				doctorPatientMenu(patient,doctor);
				break;
			case 2:
				Utilities.viewExaminations(patient);
				doctorPatientMenu(patient,doctor);
				break;
			case 3:
				Adds.addTreatment(patient, doctor);
				doctorPatientMenu(patient,doctor);
				break;
			case 4:
				Sets.modifyTreatment(patient, doctor);
				doctorPatientMenu(patient,doctor);
				break;
			case 5:
				Delete.deleteTreatment(patient, doctor);
				doctorPatientMenu(patient,doctor);
				break;
			case 6:
				Utilities.viewTreatments(patient);
				doctorPatientMenu(patient,doctor);
				break;
			case 0:
				doctorSubMenu(doctor);
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
				patientSubMenu(patient);
				break;
			case 2:
				Utilities.viewExaminations(patient);
				patientSubMenu(patient);
				break;
			case 3:
				String username=patient.getUser().getUsername();
				User user=Menu.userManager.getUser(username);
				settingsMenu(user);
			case 0:
				Menu.Menu();
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
			}
			break;
		case 2:
			yes = Utilities.searchPatientByName();
			if(yes) {
				p = Exceptions.checkPatient();
			}
			break;
		case 3:
			yes = Utilities.searchPatientBySurname();
			if(yes) {
				p = Exceptions.checkPatient();
			}
			break;
		case 0:
			return  p ;
		}
		return p;
	}

	public static void adminMenu(User user) throws Exception {
		System.out.println("\nSelect what you want to do");
		System.out.println("\n\t1.List all patients");
		System.out.println("\n\t2.View a patient");
		System.out.println("\n\t3.Delete a patient");
		System.out.println("\n\t4.Appointments");
		System.out.println("\n\t5.View a list of doctors in XML");
		System.out.println("\n\t6.Settings");
		System.out.println("\n\t0.Back");
		int option = Exceptions.checkInt();
		switch (option) {
		case 1:
			Utilities.listAllPatiens();
			adminMenu(user);
		case 2:
			Patient p1=searchPatientMenu();
			if(p1!=null) {
			System.out.println(p1);
			}
			adminMenu(user);
		case 3:
			Patient p2=searchPatientMenu();
			if(p2!=null) {
				Delete.deletePatient(p2);
			}else {
				System.out.println("This patient doesn't exist");
			}
			adminMenu(user);
		case 4:
			appointmentMenu(user);
			break;
		case 5:
			
			break;
		case 6:
			settingsMenu(user);
			break;
		case 0:
			Menu.Menu();

		}
	}

	private static void appointmentMenu(User user) throws Exception {
		System.out.println("Select what you want to do");
		System.out.println("\n\t1.Set Up a new one");
		System.out.println("\n\t2.Modify appointment");
		System.out.println("\n\t3.Search appointment by date");
		System.out.println("\n\t4.Delete appointment ");
		System.out.println("\n\t0.Back");
		int option = Exceptions.checkInt();
		Patient p ;
		switch (option) {
		case 1:
			System.out.println("Patient: ");
			p = searchPatientMenu();
			if(p!=null) {
				Adds.addAppointment(p);
			}else {
				System.out.println("This patient doesn't exist");
			}
			appointmentMenu(user);
		case 2:
			System.out.println("From what patient do you want to modify the appointment: ");
			p = searchPatientMenu();
			if(p!=null) {
				Sets.modifyAppointment(p);
			}else {
				System.out.println("This patient doesn't exist");
			}
			appointmentMenu(user);
		case 3:
			Utilities.searchAppointmentByDate();
			appointmentMenu(user);
		case 4:
			System.out.println("From what patient do you want to delete the appointment: ");
			p = searchPatientMenu();
			if(p!=null) {
				Delete.deleteAppointment(p);
			}else {
				System.out.println("This patient doesn't exist");
			}
			appointmentMenu(user);
		case 0:
			adminMenu(user);

		}
	}
	
	private static void settingsMenu(User user) {
		System.out.println("\n\t1.Delete user");
		System.out.println("\n\t2.Modify password");
		System.out.println("\n\t0.Back");
		int option = Exceptions.checkInt();
		Patient p ;
		switch (option) {
		case 1:
				String username=null;
				int n =user.getRole().getId();
				boolean sure=false;
				switch(n) {
					case 1:
						System.out.println("A doctor can not be deleted");
						settingsMenu(user);
					case 2: 
						
						username=user.getUsername();
						Patient patient = Menu.patientManager.getPatientByUsername(username);
						sure=Delete.deletePatient(patient);
						if(sure) {
						Menu.userManager.deleteUser(user);
						System.out.println("\nDeleted succed");
						}else {
							settingsMenu(user);
						}
						break;
					case 3:
						sure=Exceptions.reconfirmation();
						if(sure) {
						Menu.userManager.deleteUser(user);
						System.out.println("\nDeleted succed");
						}else {
							settingsMenu(user);
						}
						break;
					}	
				try {
					Menu.Menu();
				} catch (Exception e) {
					System.out.println("\nSomething went wrong");
					e.printStackTrace();
				}
			break;
		case 2:
			Menu.userManager.modifyPassword(user);
			break;
		case 0:
			return;

		}
	}
}
