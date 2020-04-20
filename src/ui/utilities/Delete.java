package ui.utilities;

import java.sql.Date;

import pojos.Appointment;
import pojos.Doctor;
import pojos.Patient;
import pojos.Treatment;
import ui.Menu;

public class Delete {
	
	public static void deleteTreatment(Patient patient, Doctor doctor) {

		System.out.println("Which treatmet do you want to delete?: \n");
		Menu.administrationManager.viewTreatment(patient.getId());
		int id = Utilities.askForId();
		Treatment treatment = Menu.administrationManager.getTreatmentById(id);
		System.out.println(treatment);
		Menu.administrationManager.deleteTreatment(treatment);
		
	}
	
	public static void deleteAppointment(Patient patient) {

	System.out.println("Which appointment do you want to delete?: \n");
	Menu.administrationManager.viewPatientSchedule(patient.getId());
	int id = Utilities.askForId();
	Appointment appointment = Menu.administrationManager.getAppointmentById(id);
	Menu.administrationManager.deleteAppointment(appointment);
	}
	

	public static void deletePatient(Patient patient) {
	Menu.patientManager.deletePatient(patient);
	}
	
}
