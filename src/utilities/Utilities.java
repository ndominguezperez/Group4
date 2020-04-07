package utilities;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import db.interfaces.*;
import pojos.*;

public class Utilities {
	private static PatientManager patientManager;
	private static DoctorManager doctorManager;
	private static AdministrationManager adminManager;
	
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
         id= Exceptions.checkInt();
         return id;    
    }
    //Funiciones sobre patient
    public static Patient getPatientById() {
        int patientId= askForId();
        Patient patient= patientManager.getPatient(patientId);
        return patient;
    }
    
    public static void searchPatientByName() {
    	String name = null;
    	int i;
    	System.out.println("What is the name of the patient your looking for?");
    	name = read();
    	List<Patient> patients = patientManager.searchByName(name);
		for (Patient patient: patients) {
			System.out.println(patient);
		}
    }
    public static void searchPatientBySurname() {
    	String name = null;
    	int i;
    	System.out.println("What is the name of the patient your looking for?");
    	name = read();
    	List<Patient> patients = patientManager.searchBySurname(name);
		for (Patient patient: patients) {
			System.out.println(patient);
		}
    }
   
	public static void listAllPatiens() {
		List<Patient> patientsList = patientManager.listAllPatients();
		for (Patient patient: patientsList) {
			System.out.println(patient);
		}
	}
	
	public static void getPatientSchedule(int a) {
		List<Appointment> schedule = adminManager.viewSchedule(a);
		for (Appointment appointment: schedule) {
			System.out.println(appointment);
		}
	}
	public static void getDoctorSchedule(int a) {
		List<Appointment> schedule = adminManager.viewSchedule(a);
		for (Appointment appointment: schedule) {
			System.out.println(appointment);
		}
	}
	public static void addPatient() {
		System.out.print("ID Number: ");
		int id = Exceptions.checkInt();
		System.out.print("Name: ");
		String name = read();
		System.out.print("Surname: ");
		String surname = read();
		System.out.print("Date of birth(yyyy-MM-dd): ");
		Date date = Exceptions.checkDate();
		System.out.print("Gender: ");
		String gender = read();
		System.out.print("Medical Chart: ");
		String medicalChart = read();
		//Patient patient = new Patient(name,surname ,date, gender, medicalChart);
		//patientManager.addNewPatient(patient);	
	}
//Sobre el doc
	 public static Doctor getDoctortById() {
	        int doctorId= askForId();
	        Doctor doctor= doctorManager.getDoctorById(doctorId);
	        return doctor;
	    }
	public static void addDoctor() {
		//name, salary , specialty, date of birth, start date
		System.out.print("Hole Name: ");
		String name = read();
		System.out.print("Surname: ");
		Float salary = Exceptions.checkFloat();
		System.out.print("Date of birth(yyyy-MM-dd): ");
		Date dob = Exceptions.checkDate();
		System.out.print("Date of birth(yyyy-MM-dd): ");
		Date startdate = Exceptions.checkDate();
		//Doctor doctor = new Doctor(name, salary , specialty, date of birth, start date);
		//doctorManager.addNewDoctor(doctor);	
	}
	public static void listAllPatientsOfDoctor(int docId) {
		List<Patient> patientsList = doctorManager.listAllPatientsOfDoctor();
		for (Patient patient: patientsList) {
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
	}
