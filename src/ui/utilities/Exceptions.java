package ui.utilities;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import pojos.Appointment;
import pojos.Doctor;
import pojos.Patient;
import pojos.Treatment;
import ui.Menu;

public class Exceptions {
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static int validateDay() {
		boolean comprobation = true;
		int day = 0;
		do {
			day = checkInt();
			comprobation = true; 
			try {
				if (day < 0) {
					throw new RuntimeException("NEGATIVE NUMBERS DO NOT EXIT");
				}
				if (day > 31) {
					throw new RuntimeException("NUMBERS BIGGER THAN 31 DO NOT EXIT IN A MONTH");
				}
			} catch (RuntimeException ex) {
				System.out.println("Introduce a valid number");
				comprobation = false;
			}
		} while (comprobation == false);
		return day;
	}

	public static int validateMonth(int day) {
		boolean comprobation = true;
		int month = 0;
		do {
			month = checkInt();
			comprobation = true;
			try {
				if (month > 0) {
					if (month < 13) {
						if (day > 28) {
							if (day == 29 || day == 30) {
								if (month == 2) {
									throw new RuntimeException("THIS DAY DO NOT EXIT");
								}
							}
							if (day == 31) {
								if (month == 2 || month == 4 || month == 6 || month == 9 || month == 11) {
									throw new RuntimeException("THIS DAY DO NOT EXIT");
								}
							}
						}
					} else {
						throw new RuntimeException("THIS MONTH DO NOT EXIT");
					}
				} else {
					throw new RuntimeException("NEGATIVE MONTHS DO NOT EXITS");
				}
			} catch (RuntimeException ex) {
				System.out.println("Introduce a valid month");
				comprobation = false;
			}
		} while (comprobation == false);
		return month;
	}

	public static int validateYear() {
		boolean comprobation = true;
		int year = 0;
		do {
			year = checkInt();
			comprobation = true;
			try {
				if (year < 0) {
					throw new RuntimeException("NEGATIVE YEARS DO NOT EXITS");
				}
				if (year > 2020) {
					throw new RuntimeException("WE ARE IN 2020");
				}
			} catch (RuntimeException ex) {
				System.out.println("\n\tIntroduce a valid year");
				comprobation = false;
			}
		} while (comprobation == false);
		return year;
	}

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
}
