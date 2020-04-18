package ui.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import db.interfaces.*;
import db.sqlite.SQLiteDoctorManager;
import pojos.*;
import ui.Menu;

public class Utilities {


	public static String read() {
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		String read = "ERROR";
		try {
			read = console.readLine();
		} catch (IOException ex) {
			System.out.println("DETETCTED A ERROR");
		}
		return read;
	}

	public static int askForId() {
		int id;
		System.out.println("Which is the id?");
		id = Exceptions.checkInt();
		return id;
	}
	
	
	public static void listAllPatiens() {
		List<Patient> patientsList = Menu.patientManager.listAllPatients();
		if (patientsList != null) {
			for (Patient patient : patientsList) {
				System.out.println(patient);
			}
		} else {
			System.out.print("There are no patients already\n");
		}
	}
	public static void listAllDoctors() {
		List<Doctor> doctorsList = Menu.doctorManager.listAllDoctors();
		if (doctorsList != null) {
			for (Doctor doctor : doctorsList) {
				System.out.println(doctor);
			}
		} else {
			System.out.print("There are no patients already\n");
		}
	}

	public static Patient getPatientById() {
		int patientId = askForId();
		Patient patient = Menu.patientManager.getPatient(patientId);
		return patient;
	}
	
	public static Doctor getDoctortById() {
		int doctorId = askForId();
		Doctor doctor ;
		doctor = Menu.doctorManager.getDoctorById(doctorId);
		return doctor;
	}
	public static Doctor getDoctortByIdPassingInt(int doctorId) {
		//int doctorId = askForId();
		Doctor doctor ;
		doctor = Menu.doctorManager.getDoctorById(doctorId);
		return doctor;
	}
	
	public static void searchPatientByName() {
		String name = null;
		System.out.println("What is the name of the patient your looking for?");
		name = read();
		List<Patient> patients = Menu.patientManager.searchByName(name);
		for (Patient patient : patients) {
			System.out.println(patient);
		}
	}

	public static void searchPatientBySurname() {
		String name = null;
		System.out.println("What is the name of the patient you are looking for?");
		name = read();
		List<Patient> patients = Menu.patientManager.searchBySurname(name);
		for (Patient patient : patients) {
			System.out.println(patient);
		}
	}

	public static void getPatientSchedule(int a) {
		List<Appointment> schedule = Menu.administrationManager.viewPatientSchedule(a);
		for (Appointment appointment : schedule) {
			System.out.println(appointment);
		}
	}

	public static void getDoctorSchedule(int a) {
		List<Appointment> schedule = Menu.administrationManager.viewDoctorSchedule(a);
		for (Appointment appointment : schedule) {
			System.out.println(appointment);
		}
	}


	public static void listAllPatientsOfDoctor(int docId) {
		List<Patient> patientsList = Menu.doctorManager.listAllPatientsOfDoctor();
		for (Patient patient : patientsList) {
			System.out.println(patient);
		}
	}

	public static void setUpAppointment(Patient p) {
		p.getSchedule();
		//esto es jodido
	}

	public static void modifyAppointment(Patient p) {
		p.getSchedule();
	}
	
	public static void searchAppointmentByDate() {
		Date date = null;
		System.out.println("What is the date of the appointment you are looking for?");
		date = Exceptions.checkDate();
		List<Appointment> appointmentsList = Menu.administrationManager.searchAppointmentByDate(date);
		for (Appointment appointment : appointmentsList) {
			System.out.println(appointment);
		}
	}
	

}