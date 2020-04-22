package ui;

import pojos.*;
import pojos.users.Role;
import pojos.users.User;
import ui.utilities.Adds;
import ui.utilities.Delete;
import ui.utilities.Exceptions;
import ui.utilities.Sets;
import ui.utilities.Utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.List;
import db.interfaces.*;
import db.jpa.JPAUserManager;
import db.sqlite.SQLiteDoctorManager;
import db.sqlite.SQLiteManager;

public class Menu {

	public static PatientManager patientManager;
	public static DoctorManager doctorManager;
	public static AdministrationManager administrationManager;
	public static DBManager dbManager;
	public static UserManager userManager;

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static void main(String[] args) throws Exception {

		dbManager = new SQLiteManager();
		dbManager.connect();
		patientManager = dbManager.getPatientManager();
		doctorManager = dbManager.getDoctorManager();
		administrationManager= dbManager.getAdministrationManager();
		
		//dbManager.createTables();
		userManager = new JPAUserManager();
		userManager.connect();
		
		dbManager.createTables();
		
		System.out.println("\n\n\n\n\n\n\n\nWelcome!");

		Menu();
	}

	private static void Menu() throws Exception {
		int option;
		do {
			System.out.println("What do you want to do?  ");
			System.out.println("\n\t1.Create a new user");
			System.out.println("\n\t2.Login");
			System.out.println("\n\t0.Exit");
			option = Exceptions.checkInt();
			switch (option) {
			case 1:
				newUser();
				break;
			case 2:
				login();
				break;
			case 0:
				dbManager.disconnect();
				userManager.disconnect();
				System.exit(0);
			}
		} while (option != 2);
	}
	
	private static void newUser() throws Exception {
		System.out.println("\nWhat role?");
		System.out.println("\n\t1.Doctor");
		System.out.println("\n\t2.Patient");
		System.out.println("\n\t3.Admin Staff");
		System.out.println("\n\t0.Back");
		int option = Exceptions.checkInt();

			switch (option) {
			case 1:
				System.out.println("Please type the user information: ");
				System.out.println("Username: ");
				String usernameDoctor = Utilities.read();
				System.out.println("Password: ");
				String passwordDoctor = Utilities.read();
				// Create the hash for password
				MessageDigest mdDoctor = MessageDigest.getInstance("MD5");
				mdDoctor.update(passwordDoctor.getBytes());
				byte[] hashPasswordDoctor = mdDoctor.digest();
				// Show all the roles available so the user choose
				List<Role> rolesDoctor = userManager.getRoles();
				for(Role role : rolesDoctor) {
					System.out.println(role);
				}
				System.out.println("Type the choosen id: ");
				int roleIdDoctor= Exceptions.checkInt();
				//get the role
				Role choosenRoleDoctor= userManager.getRole(roleIdDoctor);
				//create user
				User userDoctor = new User(usernameDoctor, hashPasswordDoctor, choosenRoleDoctor);
				//store user
				userManager.createUser(userDoctor);
				Adds.addDoctor(userDoctor);
				break;
			case 2:
				System.out.println("Please type the user information: ");
				System.out.println("Username: ");
				String usernamePatient = Utilities.read();
				System.out.println("Password: ");
				String passwordPatient = Utilities.read();
				// Create the hash for password
				MessageDigest mdPatient= MessageDigest.getInstance("MD5");
				mdPatient.update(passwordPatient.getBytes());
				byte[] hashPasswordPatient = mdPatient.digest();
				// Show all the roles available so the user choose
				List<Role> rolesPatient = userManager.getRoles();
				for(Role role : rolesPatient) {
					System.out.println(role);
				}
				System.out.println("Type the choosen id: ");
				int roleIdPatient= Exceptions.checkInt();
				//get the role
				Role choosenRolePatient= userManager.getRole(roleIdPatient);
				//create user
				User userPatient = new User(usernamePatient, hashPasswordPatient, choosenRolePatient);
				//store user
				userManager.createUser(userPatient);
				Adds.addPatient(userPatient);
				break;
			case 3:
				System.out.println("Please type the user information: ");
				System.out.println("Username: ");
				String usernameAdmin = Utilities.read();
				System.out.println("Password: ");
				String passwordAdmin = Utilities.read();
				// Create the hash for password
				MessageDigest mdAdmin= MessageDigest.getInstance("MD5");
				mdAdmin.update(passwordAdmin.getBytes());
				byte[] hashPasswordAdmin = mdAdmin.digest();
				// Show all the roles available so the user choose
				List<Role> rolesAdmin = userManager.getRoles();
				for(Role role : rolesAdmin) {
					System.out.println(role);
				}
				System.out.println("Type the choosen id: ");
				int roleIdAdmin= Exceptions.checkInt();
				//get the role
				Role choosenRoleAdmin= userManager.getRole(roleIdAdmin);
				//create user
				User userAdmin = new User(usernameAdmin, hashPasswordAdmin, choosenRoleAdmin);
				//store user
				userManager.createUser(userAdmin);
				break;
			case 0:
				Menu();
			}
		

	}
	
	private static void login() throws Exception {
		System.out.println("Please input your credentials: ");
		System.out.println("Username: ");
		String username = Utilities.read();
		System.out.println("Password: ");
		String password = Utilities.read();
		User user = userManager.checkPassword(username, password);
		if (user==null) {
			System.out.println("Wrong credentials, please try again!");
		}else if(user.getRole().getRole().equalsIgnoreCase("doctor")){
			Doctor  doctor = doctorManager.getDoctorByUsername(username);
			doctorSubMenu(doctor);
			System.out.println("Welcome doctor "+username+"!");
		}else if (user.getRole().getRole().equalsIgnoreCase("patient")) {
			Patient  patient = patientManager.getPatientByUsername(username);
			patientSubMenu(patient);
			System.out.println("Welcome "+username+"!");
		}else if (user.getRole().getRole().equalsIgnoreCase("admin staff")) {
			System.out.println("Welcome "+username+"!");
			adminMenu();
		}else {
			System.out.println("Invalid role.");
		}
	}
	
	
	
	/*private static void doctorMenu() throws Exception {
		Doctor doctor = null;
		try {
			doctor = Utilities.getDoctortById();
		}catch (NullPointerException e) {
			System.out.println("\n\n\tID not founded");
			doctor=null;
			return;
		}
		if (doctor == null) {
			return;
		} else {
			doctorSubMenu(doctor);
		}
	}*/

	private static void doctorSubMenu(Doctor doctor) throws Exception {
		int option;
		do {
			System.out.println("Select what you want to do");
			System.out.println("\n\t1.See Your schedule");
			System.out.println("\n\t2.List all your patients");
			System.out.println("\n\t3.Patient");
			System.out.println("\n\t0.Back");
			option = Exceptions.checkInt();
			switch (option) {
			case 1: // View schedule
				Utilities.getDoctorSchedule(doctor.getId());
				doctorSubMenu(doctor);
			case 2:
				Utilities.listAllPatientsOfDoctor(doctor.getId());
				break;
			case 3: // Patient
				Patient patient = searchPatientMenu();
				doctorPatientMenu(patient, doctor);
				break;
			case 0:
				Menu();

			}

		} while (option != 3);

	}

	private static void doctorPatientMenu(Patient patient, Doctor doctor) throws Exception {
		int option;
		do {
		System.out.println("Select what you want to do");
		System.out.println("\n\t1.Create Examinations");
		System.out.println("\n\t2.See Examinations");
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
				administrationManager.viewExamination(patient.getId());
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
				administrationManager.viewTreatment(patient.getId());
				break;
			case 0:
				doctorSubMenu(doctor);
			}
		} while (option != 5);

	}

/*	private static void patientMenu() throws Exception {
		Patient patient = null;
		try {
			patient = Utilities.getPatientById();
			 System.out.print(patient);
		} catch (NullPointerException e) {
			System.out.println("\n\n\tID not founded");
			return;
		}
		if (patient == null) {
			return;
		} else {
			patientSubMenu(patient);
		}
	}*/

	private static void patientSubMenu(Patient patient) throws Exception {
		int option;
		do {
			System.out.println("Select what you want to do");
			System.out.println("\n\t1.Schedule");
			System.out.println("\n\t2.See examinations");
			System.out.println("\n\t0.Back");
			option = Exceptions.checkInt();
			switch (option) {
			case 1:
				Utilities.getPatientSchedule(patient.getId());
				break;
			case 2:
				// Uitlizar la funcion creada con doctorPatientMenu
				List<Examination> a = patient.getExaminations();
				break;
			case 0:
				Menu();
			}
		} while (option != 3);
	}

	private static Patient searchPatientMenu() {
		System.out.println("\n\t1.To search by id number");
		System.out.println("\n\t2.To search by name");
		System.out.println("\n\t3.To search by surname");
		//System.out.println("\n\tIf you want to go back press 0");
		int option = Exceptions.checkInt();
		Patient p = null;
		switch (option) {
		case 1:
			p = Utilities.getPatientById();
			if(p==null) {
				System.out.println("This patient do not exit");
			}
			break;
		case 2:
			Utilities.searchPatientByName();
			p = Utilities.getPatientById();
			if(p==null) {
				System.out.println("This patient do not exit");
			}
			break;
		case 3:
			Utilities.searchPatientBySurname();
			p = Utilities.getPatientById();
			if(p==null) {
				System.out.println("This patient do not exit");
			}
			break;
		}
	
		return p;
	}

	private static void adminMenu() throws Exception {
		System.out.println("\nSelect what you want to do");
		System.out.println("\n\t1.List all patients");
		System.out.println("\n\t2.View a patient");
		System.out.println("\n\t3.Delete a patient");
		System.out.println("\n\t4.Add a new patient");
		System.out.println("\n\t5.Appointments");
		System.out.println("\n\t6.Add new doctor");
		System.out.println("\n\t0.Back");
		int option = Exceptions.checkInt();
		switch (option) {
		case 1:
			Utilities.listAllPatiens();
			adminMenu();
		case 2:
			Patient p1=searchPatientMenu();
			System.out.println(p1);
			adminMenu();
		case 3:
			Patient p2=searchPatientMenu();
			Delete.deletePatient(p2);
			adminMenu();
		case 4:
			Adds.addPatient();
			adminMenu();
		case 5:
			appointmentMenu();
			break;
		case 6:
			Adds.addDoctor();
			adminMenu();
		case 0:
			Menu();

		}
	}

	private static void appointmentMenu() throws Exception {
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
			Adds.addAppointment(p);
			appointmentMenu();
		case 2:
			System.out.println("From what patient do you want to modify the appointment: ");
			p = searchPatientMenu();
			Sets.modifyAppointment(p);
			appointmentMenu();
		case 3:
			Utilities.searchAppointmentByDate();
			appointmentMenu();
		case 4:
			System.out.println("From what patient do you want to delete the appointment: ");
			p = searchPatientMenu();
			Delete.deleteAppointment(p);
			appointmentMenu();
		case 0:
			adminMenu();

		}

	}

	
}
