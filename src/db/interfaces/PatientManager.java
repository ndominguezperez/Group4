package db.interfaces;

import java.sql.Date;
import java.util.List;

import pojos.*;

public interface PatientManager {
	public List<Patient> listAllPatients();
	public void addNewPatient(Patient patient, Doctor doctor);
	public Patient getPatient(int patientId);
	public Patient getPatientById(int patientId);
	public List<Patient> searchByName(String name);
	public List<Patient> searchBySurname(String surname);
	public void assign (int doctorId,int patientId);
	public void modifyPatient(Patient patient);
	public void deletePatient(Patient patient);
	public Patient getPatientByUsername(String username);
}
