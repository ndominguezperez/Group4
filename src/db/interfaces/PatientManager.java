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
}
