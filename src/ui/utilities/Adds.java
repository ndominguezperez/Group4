package ui.utilities;

import java.sql.Date;
import java.util.List;

import pojos.Appointment;
import pojos.Doctor;
import pojos.Examination;
import pojos.Patient;
import pojos.Treatment;
import ui.Menu;

public class Adds {
	
	public static void addExamination(Patient patient, Doctor doctor) {
		
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
		Examination examination = new Examination(observations, temperature,breathingRate,heartRate, bloodPreasure, oxygenSaturation, doctor, patient );
		System.out.println(examination);
		Menu.administrationManager.addNewExamination(examination);
	}
	
	public static void addTreatment(Patient patient, Doctor doctor) {
		System.out.print("Disease: ");
		String disease = Utilities.read();
		System.out.print("Drug: ");
		String drug = Utilities.read();
		System.out.print("Finish date(yyyy-MM-dd): ");
		Date finishDate = Exceptions.checkDate();
		Treatment treatment = new Treatment(disease, drug, finishDate, patient, doctor);
		Menu.administrationManager.addNewTreatment(treatment);
	}


	
	public static void addAppointment(Patient patient) {
		
		System.out.print("Introduce the type: ");
		String type = Utilities.read();
		System.out.print("Date (yyyy-MM-dd): ");
		Date date = Exceptions.checkDate();
		System.out.print("Time: ");
		Float time = Exceptions.checkFloat();
		Utilities.listAllDoctors();
		System.out.print("Id: ");
		Doctor doctor= Utilities.getDoctortById();
		String speciality = doctor.getSpeciality();
		Appointment appointment1 = new Appointment(type,date,time,speciality,doctor,patient);
		System.out.println(appointment1);
		Menu.administrationManager.addNewAppointment(appointment1);
	}
	
	public static void addPatient() {
		boolean p=true; 
		int id=0;
		System.out.print("ID Number: ");
		do {
			p=true;
			id = Exceptions.checkInt();
			List<Patient> patientsList = Menu.patientManager.listAllPatients();
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
		String name = Utilities.read();
		System.out.print("Surname: ");
		String surname = Utilities.read();
		System.out.print("Date of birth(yyyy-MM-dd): ");
		Date date = Exceptions.checkDate();
		System.out.print("Gender: ");
		String gender = Utilities.read();
		System.out.print("Medical Chart: ");
		String medicalChart = Utilities.read();
		Utilities.listAllDoctors();
		System.out.print("Choose a doctor: ");
		Doctor doctor= Utilities.getDoctortById();
		Patient patient = new Patient(id, name, surname, date, medicalChart,gender);
		System.out.println(patient);
		Menu.patientManager.addNewPatient(patient, doctor);
		}
	
	public static void addDoctor() {
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
		Menu.doctorManager.addNewDoctor(doctor);
	}
}
