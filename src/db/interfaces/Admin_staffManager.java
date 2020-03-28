package db.interfaces;

import java.sql.Date;
import java.util.List;

import pojos.*;

public interface Admin_staffManager {
	public boolean addPatient(Patient patient);
	public Patient getPatientById(int id);
	public List<Patient> searchPatientByName(String name);
	public List<Patient> searchPatientBySurname(String surname);
	public List<Patient> listAllPatients();
	public boolean setUpAppointment (int nurse_id, int doctor_id, int patient_id, Date date);
	public boolean modifyAppointment (Appointment appointment);
	public Appointment getAppointmentById(int id);
	public List<Appointment> searchAppointmentByPatient_id(int id);
	public List<Appointment> searchAppointmentByDate(Date date);
	public boolean removeAppointmentById(int id);
}
