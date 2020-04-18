package ui.utilities;

import java.sql.Date;
import java.util.List;

import pojos.Appointment;
import pojos.Doctor;
import pojos.Examination;
import pojos.Patient;
import pojos.Treatment;
import ui.Menu;

public class Sets {

	public static void modifyTreatment(Patient patient, Doctor doctor) {
		
		System.out.print("Which treatmet do you want to change?: ");
		// listar todos los treatments
		int id = Utilities.askForId();
		boolean question;
		Treatment treatment = patient.getTreatments().get(id);
		System.out.print("Do you want to change the disease: ");
		System.out.println("The disease is %s"+treatment.getDisease());
		String disease;
		question = Exceptions.checkConfirmation();
		if (question) {
			System.out.print("Introduce the new disease: ");
			disease = Utilities.read();
		} else {
			disease = treatment.getDisease();
		}
		System.out.print("Do you want to change the drug: ");
		String drug;
		System.out.println("The drug is %s"+treatment.getDrug());
		question = Exceptions.checkConfirmation();
		if (question) {
			System.out.print("Introduce the new drug: ");
			drug = Utilities.read();
		} else {
			drug = treatment.getDrug();
		}
		System.out.print("Do you want to change the finish date: ");
		Date finishDate;
		System.out.println("The date is %d"+treatment.getFinishDate());
		question = Exceptions.checkConfirmation();
		if (question) {
			System.out.print("Introduce the new finish date(yyyy-MM-dd):  ");
			finishDate = Exceptions.checkDate();
		} else {
			finishDate = treatment.getFinishDate();
		}
		Treatment treatment1 = new Treatment(disease, drug, finishDate, patient, doctor);
		
		Menu.administrationManager.modifyTreatment(treatment1);
	}

	public static void modifyAppointment(Patient patient) {
		System.out.print("Which appointment do you want to change?: ");
		// listar todos los treatments o que se haya pasado ya el appointment no se
		int id = Utilities.askForId();
		boolean question;
		Appointment appointment = patient.getSchedule().get(id);
		System.out.print("Do you want to change the type: ");
		String type;
		System.out.println("The type is %s"+appointment.getType());
		question = Exceptions.checkConfirmation();
		if (question) {
			System.out.print("Introduce the new type: ");
			type = Utilities.read();
		} else {
			type = appointment.getType();
		}

		System.out.print("Do you want to change the day: ");
		Date day;
		System.out.println("The day is %d"+appointment.getDate());
		question = Exceptions.checkConfirmation();
		if (question) {
			System.out.print("Introduce the new  date(yyyy-MM-dd):: ");
			day = Exceptions.checkDate();
		} else {
			day = appointment.getDate();
		}

		System.out.print("Do you want to change the time: ");
		Float time;
		System.out.println("The time is %f"+appointment.getTime());
		question = Exceptions.checkConfirmation();
		if (question) {
			System.out.print("Introduce the new time: ");
			time = Exceptions.checkFloat();
		} else {
			time = appointment.getTime();
		}

		System.out.print("Do you want to change the doctor: ");
		System.out.println("The docor is:"+ appointment.getDoctor());
		question = Exceptions.checkConfirmation();
		Doctor doctor;
		if (question) {
			System.out.print("Introduce the new doctor id: ");
			Utilities.listAllDoctors();
			System.out.print("Id: ");
			doctor = Utilities.getDoctortById();
		} else {
			doctor = appointment.getDoctor();
		}
		String speciality = doctor.getSpeciality();
		Appointment appointment1 = new Appointment(type, day, time, speciality, doctor, patient);
		System.out.println(appointment1);
		// Menu.administrationManager.setAppointment(appointment1);
	}

	public static void modifyPatient(Patient patient) {
		boolean question;
		System.out.print("Do you want to change the medical chart?: ");
		String medicalChart;
		question = Exceptions.checkConfirmation();
		if (question) {
			System.out.print("Introduce the new medicalChart: ");
			medicalChart = Utilities.read();
			patient.setMedical_chart(medicalChart);
		} else {
			medicalChart = patient.getMedical_chart();
		}
		Menu.patientManager.modifyPatient(patient);
	}

	public static void modifyDoctor(Doctor doctor) {
		boolean question;
		System.out.print("Do you want to change the name?: ");
		String name;
		question = Exceptions.checkConfirmation();
		if (question) {
			System.out.print("Introduce the new name: ");
			name = Utilities.read();
		} else {
			name = doctor.getName();
		}
		System.out.print("Do you want to change the salary?: ");
		Float salary;
		question = Exceptions.checkConfirmation();
		if (question) {
			System.out.print("Introduce the new salary: ");
			salary = Exceptions.checkFloat();
		} else {
			salary = doctor.getSalary();
		}
		System.out.print("Do you want to change the speciality?: ");
		String speciality;
		question = Exceptions.checkConfirmation();
		if (question) {
			System.out.print("Introduce the new speciality: ");
			speciality = Utilities.read();
		} else {
			speciality = doctor.getSpeciality();
		}
		System.out.print("Do you want to change the date of birth?: ");
		Date dob;
		question = Exceptions.checkConfirmation();
		if (question) {
			System.out.print("Introduce the new date of birth (yyyy-MM-dd):: ");
			dob = Exceptions.checkDate();
		} else {
			dob = doctor.getDob();
		}
		System.out.print("Do you want to change the start date?: ");
		Date date;
		question = Exceptions.checkConfirmation();
		if (question) {
			System.out.print("Introduce the new start date (yyyy-MM-dd):: ");
			date = Exceptions.checkDate();
		} else {
			date = doctor.getStart_date();
		}
		Doctor doctor1 = new Doctor(name, salary, speciality, dob, date);
		//Menu.doctorManager
	}
}
