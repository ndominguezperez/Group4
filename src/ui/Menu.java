package ui;

import pojos.*;
import utilities.Exceptions;
import utilities.Utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.List;
import db.interfaces.*;
import db.sqlite.SQLiteDoctorManager;
import db.sqlite.SQLiteManager;
import utilities.Utilities;

public class Menu {

	private static PatientManager patientManager;
	private static DoctorManager doctorManager;
	private static AdministrationManager adminManager;
	private static DBManager dbManager;

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static void main(String[] args) {

		dbManager = new SQLiteManager();
		dbManager.connect();
		patientManager = dbManager.getPatientManager();
		doctorManager = dbManager.getDoctorManager();
		// adminManager= dbManager.getAdminManager();
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
				// Uitlitzar la funcion creada con doctorPatientMenu
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
			listAllPatiens();
			break;
		case 2:
			searchPatientMenu();
			break;
		case 3:
			addPatient();
			break;
		case 4:
			appointmentMenu();
			break;
		case 5:
			addDoctor();
			break;
		case 6:
			return;

		}
	}

	private static void appointmentMenu() {
		Patient p = searchPatientMenu();
		System.out.println("Select what you want to do");
		System.out.println("\n\t1.Set Up a new one");
		System.out.println("\n\t2.Modify");
		System.out.println("\n\t3.Search appointment by date");
		System.out.println("\n\t4.Exit");
		int option = Exceptions.checkInt();
		switch (option) {
		case 1:
			// funcion sin hacer!!!
			Utilities.setUpAppointment(p);
		case 2:

			Utilities.modifyAppointment(p);
			break;
		case 3:
			appointmentMenu();

		}

	}

	private static void addDoctor() {
		System.out.print("Hole Name: ");
		String name = Utilities.read();
		System.out.print("Salary: ");
		Float salary = Exceptions.checkFloat();
		System.out.print("Speciality: ");
		String speciality = Utilities.read();
		System.out.print("Date of birth(yyyy-MM-dd): ");
		Date dob = Exceptions.checkDate();
		System.out.print("Start date(yyyy-MM-dd): ");
		Date startDate = Exceptions.checkDate();
		Doctor doctor = new Doctor(name, salary, speciality, dob, startDate);
		doctorManager.addNewDoctor(doctor);
	}

	private static void addPatient() {
		boolean p=true; 
		int id=0;
		System.out.print("ID Number: ");
		do {
			p=true;
			id = Exceptions.checkInt();
			List<Patient> patientsList = patientManager.listAllPatients();
			if(patientsList!=null) {
				for (Patient patient : patientsList) {
					if (patient.getId()==id){
						System.out.print("That id already exist, try another one: \n");
						p=false;
						break;
					}
				}
			}else {
				p=true;
			}
		}while (p==false);
		
	System.out.print("Name: ");
	String name = Utilities.read();System.out.print("Surname: ");
	String surname = Utilities.read();System.out.print("Date of birth(yyyy-MM-dd): ");
	Date date = Exceptions.checkDate();System.out.print("Gender: ");
	String gender = Utilities.read();System.out.print("Medical Chart: ");
	String medicalChart = Utilities.read();
	Patient patient = new Patient(id, name, surname, date, medicalChart,
			gender);System.out.println(patient);patientManager.addNewPatient(patient);
	}

	private static void listAllPatiens() {
		List<Patient> patientsList = patientManager.listAllPatients();
		if (patientsList != null) {
			for (Patient patient : patientsList) {
				System.out.println(patient);
			}
		} else {
			System.out.print("There are no patients already\n");
		}
	}
	
	private static void addResult() {
		
		System.out.print("Type: ");
		String type = Utilities.read();
		System.out.print("Date: ");
		Date date = Exceptions.checkDate();
		Result result = new Result (type, date);
		adminManager.addNewResult(result);
	
	}
	private static void addExamination() {
		System.out.println("Introduce the temperature");
		Float temperature = Exceptions.checkFloat();
		System.out.println("Introduce the breathing rate");
		int breathingRate = Exceptions.checkInt();
		System.out.println("Introduce the heart rate");
		int heartRate = Exceptions.checkInt();
		System.out.println("Introduce the blood presure");
		Float bloodPreasure = Exceptions.checkFloat();
		System.out.println("Introduce the oxygen saturation");
		Float oxygenSaturation= Exceptions.checkFloat();
		System.out.println("Introduce the observations");
		String observations = Utilities.read();
		Examination examination = new Examination(observations, temperature,breathingRate,heartRate, bloodPreasure, oxygenSaturation );
		System.out.println(examination);
		adminManager.addNewExamination(examination);
	}
}
