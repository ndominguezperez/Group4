package ui.utilities;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.persistence.NoResultException;

import pojos.Appointment;
import pojos.Doctor;
import pojos.Patient;
import pojos.Treatment;
import pojos.users.User;
import ui.Menu;

public class Exceptions {
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static int checkInt() {
		int whole = 0;
		boolean comprobation = true;
		String read;
		do {
			read = Utilities.read();
			comprobation = true;
			try {
				whole = Integer.parseInt(read);
			} catch (NumberFormatException ex) {
				System.out.println("\n\tIntroduce whole number");
				comprobation = false;
			}
		} while (comprobation == false);
		return whole;

	}

	public static float checkFloat() {
		float f = 0;
		boolean comprobation = true;
		String read;
		do {
			read = Utilities.read();
			comprobation = true;
			try {
				f = Float.parseFloat(read);
			} catch (NumberFormatException ex) {
				System.out.println("\n\tIntroduce a whole real");
				comprobation = false;
			}
		} while (comprobation == false);
		return f;

	}

	public static Date checkDate() {
		int i = 0;
		Date date = null;
		while (i == 0) {
			try {
				String day = Utilities.read();
				LocalDate admissionDate = LocalDate.parse(day, formatter);
				date = Date.valueOf(admissionDate);
				i = 1;
			} catch (DateTimeParseException e) {
				System.out.println("You should put a valid day in the right format");
				System.out.println("Date:");
			}
		}
		return date;
	}

	public static boolean checkConfirmation() {
		int i = 0;
		boolean yes = false;
		while (i == 0) {
			System.out.println("\n\tYes or No (Y/N)");
			String confirm = Utilities.read();
			if (confirm.equalsIgnoreCase("Y")) {
				i = 1;
				yes = true;
			}
			if (confirm.equalsIgnoreCase("N")) {
				i = 1;
				yes = false;
			}
		}
		return yes;
	}

	public static boolean reconfirmation() {
		int i = 0;
		boolean yes = false;
		while (i == 0) {
			System.out.println("\n\n\tAre you sure? (Y/N)");
			String confirm = Utilities.read();
			if (confirm.equalsIgnoreCase("Y")) {
				i = 1;
				yes = true;
			}
			if (confirm.equalsIgnoreCase("N")) {
				i = 1;
				yes = false;
			}
		}
		return yes;
	}
	
	public static boolean chooseDocOPat() {
		int i = 0;
		boolean yes = false;
		while (i == 0) {
			System.out.println("\nFrom doctor o patient? (D/P)");
			String confirm = Utilities.read();
			if (confirm.equalsIgnoreCase("D")) {
				i = 1;
				yes = true;
			}
			if (confirm.equalsIgnoreCase("P")) {
				i = 1;
				yes = false;
			}
		}
		return yes;
	}

	public static Patient checkPatient() {
		Patient patient = null;
		int id;
		id = Utilities.askForId();
		try {
			patient = Menu.patientManager.getPatient(id);
		} catch (NullPointerException e) {
			System.out.println("\n\n\tID not founded");
			patient = null;
		}
		return patient;
	}

	public static Doctor checkDoctor() {
		int id;
		id = Utilities.askForId();
		Doctor doctor = null;
		try {
			doctor = Menu.doctorManager.getDoctorById(id);
			//System.out.print(doctor);
		} catch (NullPointerException e) {
			System.out.println("\n\n\tID not founded");
			doctor = null;
		}
		return doctor;
	}

	public static Appointment checkAppointment() {
		Appointment appointment = null;
		int id;
		id = Utilities.askForId();
		try {
			appointment = Menu.administrationManager.getAppointmentById(id);
		} catch (NullPointerException e) {
			System.out.println("\n\n\t ID not founded");
			appointment = null;
		}
		return appointment;
	}

	public static Treatment checkTreatment() {
		Treatment treatment = null;
		int id;
		id = Utilities.askForId();
		try {
			treatment = Menu.administrationManager.getTreatmentById(id);
		} catch (NullPointerException e) {
			System.out.println("\n\n\t ID not founded");
			treatment = null;
		}
		return treatment;
	}
	public static boolean checkUsername(String username) {
		boolean exist;
		try {
		User user= Menu.userManager.getUser(username);
		exist=true;
		}catch(NoResultException e) {
			exist=false;
		}
		return exist;
	}
}
