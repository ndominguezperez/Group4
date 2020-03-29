package db.interfaces;

import java.sql.Date;
import java.util.List;

import pojos.*;

public interface NurseManager {
	public Patient getPatientById(int id);
	public List<Patient> listAllPatients();
	public List<Patient> searchPatientByName(String name);
	public List<Patient> searchPatientBySurname(String surname);
	public List<Appointment> viewSchedule();
	public boolean modifyAppointment(int id);
	public Examination viewExamination(int id);
	public boolean modifyExamination(int id);
	public Treatment viewTreatment(int id);
	public boolean setUpMachine(int id, Date date);
}