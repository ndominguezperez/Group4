package db.interfaces;

import java.sql.Date;
import java.util.List;

import pojos.*;

public interface PatientManager {
	public List<Patient> listAllPatients();
	public void addNewPatient(Patient patient);
	public Patient getPatient(int patientId);
	public List<Patient> searchByName(String name);
	public List<Patient> searchBySurname(String surname);
	public boolean setUpMachine(int id, Date date);
	public List<Appointment> viewSchedule();
	public boolean setUpAppointment (Appointment appointment);
	public boolean modifyAppointment (Appointment appointment);
	public Appointment getAppointmentById(int id);
	public List<Appointment> searchAppoitmentByDate(Date date);
	public List <Result> viewResults();
	public Examination viewExamination(int id);
	public boolean modifyExamination(int id); 
	public Treatment viewTreatment(int id);
	public boolean modifyTreatment(int id); 
}
