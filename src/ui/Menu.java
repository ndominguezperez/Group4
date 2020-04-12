package ui;

import pojos.*;
import ui.utilities.Adds;
import ui.utilities.Exceptions;
import ui.utilities.Utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.List;
import db.interfaces.*;
import db.sqlite.SQLiteDoctorManager;
import db.sqlite.SQLiteManager;

public class Menu {

	public static PatientManager patientManager;
	public static DoctorManager doctorManager;
	public static AdministrationManager administrationManager;
	public static DBManager dbManager;

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static void main(String[] args) {

		dbManager = new SQLiteManager();
		dbManager.connect();
		patientManager = dbManager.getPatientManager();
		doctorManager = dbManager.getDoctorManager();
		administrationManager= dbManager.getAdministrationManager();
		System.out.println("Welcome!");
		dbManager.createTables();

		int option;
		do {
			System.out.println("Select who you are");
			System.out.println("\n\t1.Doctor");
			System.out.println("\n\t2.Patient");
			System.out.println("\n\t3.Admin Staff");
			System.out.println("\n\t4.Exit");
			option = Exceptions.checkInt();
			switch (option) {
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
		} while (option != 4);
	}

	// Esto seria con la contraseña y eso supongo....
	private static void doctorMenu() {
		Doctor doctor = null;
		try {
			doctor = Utilities.getDoctortById();
		} catch (NullPointerException e) {
			System.out.println("\n\n\tID not founded");
			return;
		}
		System.out.println("Estoy aqui");
		if (doctor == null) {
			System.out.println("Estoy");
			return;
		} else {
			doctorSubMenu(doctor.getId());
		}
	}

	private static void doctorSubMenu(int doctorId) {
		int option;
		do {
			System.out.println("Select what you want to do");
			System.out.println("\n\t1.See Your schedule");
			System.out.println("\\n\\t2.List all your patients");
			System.out.println("\n\t3.Patient");
			System.out.println("\n\t4.Exit");
			option = Exceptions.checkInt();
			switch (option) {
			case 1: // View schedule
				System.out.println("\n\n\tYour schedule Doctor:%d \n" + doctorId);
				Utilities.getDoctorSchedule(doctorId);
				System.out.println("\n\n\tPulse intro togo bacj to your menu");
				Utilities.read();
				break;
			case 2:
				Utilities.listAllPatientsOfDoctor(doctorId);
			case 3: // Patient
				Patient a = searchPatientMenu();
				doctorPatientMenu(a);
			case 4:
				break;

			}

		} while (option != 3);

	}

	private static void doctorPatientMenu(Patient patient) {
		System.out.println("Select what you want to do");
		System.out.println("\n\t1.See Examinations");
		System.out.println("\n\t2.Modify Examination");
		System.out.println("\n\t3.Create Treatment");
		System.out.println("\n\t4.Modify Treatment");
		System.out.println("\n\t5.View Treatment");
		System.out.println("\n\t6.Back");
		int option;
		do {
			option = Exceptions.checkInt();
			switch (option) {
			case 1:
				// habria que hacer una funcion
				// patient.getExaminations(); y un print como en patient
				break;
			case 2:
				// funcion en utilities con sets
				break;
			case 3:
				// fucnicon
				break;
			case 4:
				// fnction
				break;
			case 5:
				// function con
				// patient.getTreatments();
				break;
			case 6:
				return;
			}
		} while (option != 6);

	}

	private static void patientMenu() {
		Patient patient = null;
		try {
			patient = Utilities.getPatientById();
		} catch (NullPointerException e) {
			System.out.println("\n\n\tID not founded");
			return;
		}
		System.out.println("Estoy aqui");
		if (patient == null) {
			System.out.println("Estoy");
			return;
		} else {
			patientSubMenu(patient);
		}
	}

	private static void patientSubMenu(Patient patient) {
		int option;
		do {
			System.out.println("Select what you want to do");
			System.out.println("\n\t1.Schedule");
			System.out.println("\n\t2.See examinations");
			System.out.println("\n\t3.Go back");
			option = Exceptions.checkInt();
			switch (option) {
			case 1:
				Utilities.getPatientSchedule(patient.getId());
				break;
			case 2:
				// Uitlizar la funcion creada con doctorPatientMenu
				List<Examination> a = patient.getExaminations();
				break;
			case 3:
				return;
			}
		} while (option != 3);
	}

	private static Patient searchPatientMenu() {
		System.out.println("\n\t1.To search by id number");
		System.out.println("\n\t2.To search by name");
		System.out.println("\n\t3.To search by surname");
		System.out.println("\n\tIf you want to go back press 0");
		int option = Exceptions.checkInt();
		Patient p = null;
		switch (option) {
		case 1:
			p = Utilities.getPatientById();
			break;
		case 2:
			Utilities.searchPatientByName();
			p = Utilities.getPatientById();
			break;
		case 3:
			Utilities.searchPatientBySurname();
			p = Utilities.getPatientById();
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
		System.out.println("\n\t5.Add new doctor");
		System.out.println("\n\t6.Exit");
		int option = Exceptions.checkInt();
		switch (option) {
		case 1:
			Utilities.listAllPatiens();
			break;
		case 2:
			searchPatientMenu();
			break;
		case 3:
		
			Adds.addPatient();
			break;
		case 4:
			appointmentMenu();
			break;
		case 5:
			Adds.addDoctor();
			break;
		case 6:
			return;

		}
	}

	private static void appointmentMenu() {
		//Patient p = searchPatientMenu();
		System.out.println("Select what you want to do");
		System.out.println("\n\t1.Set Up a new one");
		System.out.println("\n\t2.Modify");
		System.out.println("\n\t3.Search appointment by date");
		System.out.println("\n\t4.Exit");
		int option = Exceptions.checkInt();
		List<Patient> patientsList = patientManager.listAllPatients();
		List<Doctor> doctorsList = doctorManager.listAllDoctors();
		switch (option) {
		case 1:
			Patient patient1 = patientsList.get(0);
			Doctor doctor1 = doctorsList.get(0);
			Adds.addAppointment(patient1,doctor1);
		case 2:
			Patient patient2 = patientsList.get(0);
			Doctor doctor2 = doctorsList.get(0);
			Adds.addResult(patient2,doctor2);
			//Utilities.modifyAppointment();
			break;
		case 3:
			appointmentMenu();

		}

	}

	
}
