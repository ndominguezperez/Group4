package ui;

import pojos.*;
import pojos.users.Role;
import pojos.users.User;
import ui.utilities.Action;
import ui.utilities.Adds;
import ui.utilities.Exceptions;
import ui.utilities.Utilities;
import java.security.MessageDigest;
import db.interfaces.*;
import db.jpa.JPAUserManager;
import db.sqlite.SQLiteManager;

public class Menu {

	public static PatientManager patientManager;
	public static DoctorManager doctorManager;
	public static AdministrationManager administrationManager;
	public static DBManager dbManager;
	public static UserManager userManager;


	public static void main(String[] args) throws Exception {

		dbManager = new SQLiteManager();
		dbManager.connect();
		patientManager = dbManager.getPatientManager();
		doctorManager = dbManager.getDoctorManager();
		administrationManager= dbManager.getAdministrationManager();
		
		dbManager.createTables();
		userManager = new JPAUserManager();
		userManager.connect();
		
		//dbManager.createTables();
		
		System.out.println("\n\n\n\n\n\n\n\nWelcome!");

		Beginning();
	}

	public static void Beginning() throws Exception {
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
		} while (option != 0);
	}
	
	private static void newUser() throws Exception {
		System.out.println("\nWhat role?");
		System.out.println("\n\t1.Doctor");
		System.out.println("\n\t2.Patient");
		System.out.println("\n\t3.Admin Staff");
		System.out.println("\n\t0.Back");
		int option = Exceptions.checkInt();
		boolean exist;

			switch (option) {
			case 1:
				System.out.println("Please type the user information: ");
				System.out.println("Username: ");
				String usernameDoctor = Utilities.read();
			    exist= Exceptions.checkUsername(usernameDoctor);
			    if(!exist) {
				System.out.println("Password: ");
				String passwordDoctor = Utilities.read();
				// Create the hash for password
				MessageDigest mdDoctor = MessageDigest.getInstance("MD5");
				mdDoctor.update(passwordDoctor.getBytes());
				byte[] hashPasswordDoctor = mdDoctor.digest();
				Role choosenRoleDoctor= userManager.getRole(1);
				//create user
				User userDoctor = new User(usernameDoctor, hashPasswordDoctor, choosenRoleDoctor);
				//store user
				userManager.createUser(userDoctor);
				Adds.addDoctor(userDoctor);
				System.out.println("\nUser created!\n");
			    }else {
			    	System.out.println("This username already exist!");
			    }
				break;
			case 2:
				String usernamePatient =null;
				if(doctorManager.listAllDoctors().size()>0) {
				System.out.println("Please type the user information: ");
				System.out.println("Username: ");
			    usernamePatient = Utilities.read();
			    exist= Exceptions.checkUsername(usernamePatient);
			    if(!exist) {
				System.out.println("Password: ");
				String passwordPatient = Utilities.read();
				// Create the hash for password
				MessageDigest mdPatient= MessageDigest.getInstance("MD5");
				mdPatient.update(passwordPatient.getBytes());
				byte[] hashPasswordPatient = mdPatient.digest();
				Role choosenRolePatient= userManager.getRole(2);
				//create user
				User userPatient = new User(usernamePatient, hashPasswordPatient, choosenRolePatient);
				//store user
				userManager.createUser(userPatient);
				Adds.addPatient(userPatient);
				System.out.println("\nUser created!\n");
			    }else {
			    	System.out.println("This username already exist!");
			    }
				}else {
					System.out.println("You can't be a patient if there are no doctors");
				}
				break;
			case 3:
				System.out.println("Please type the user information: ");
				System.out.println("Username: ");
				String usernameAdmin = Utilities.read();
				exist= Exceptions.checkUsername(usernameAdmin);
			    if(!exist) {
				System.out.println("Password: ");
				String passwordAdmin = Utilities.read();
				// Create the hash for password
				MessageDigest mdAdmin= MessageDigest.getInstance("MD5");
				mdAdmin.update(passwordAdmin.getBytes());
				byte[] hashPasswordAdmin = mdAdmin.digest();
				Role choosenRoleAdmin= userManager.getRole(3);
				//create user
				User userAdmin = new User(usernameAdmin, hashPasswordAdmin, choosenRoleAdmin);
				//store user
				userManager.createUser(userAdmin);
				System.out.println("\nUser created!\n");
			    }else {
			    	System.out.println("This username already exist!");
			    }
				break;
			case 0:
				return;
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
			System.out.println("Welcome doctor "+ username +"!");
			Doctor  doctor = doctorManager.getDoctorByUsername(username);
			Action.doctorSubMenu(doctor);
		}else if (user.getRole().getRole().equalsIgnoreCase("patient")) {
			System.out.println("Welcome "+ username +"!");
			Patient  patient = patientManager.getPatientByUsername(username);
			Action.patientSubMenu(patient);
		}else if (user.getRole().getRole().equalsIgnoreCase("admin")) {
			System.out.println("Welcome "+ username +"!");
			Action.adminMenu(user); 
		}else {
			System.out.println("Invalid role.");
		}
	}
	
}	