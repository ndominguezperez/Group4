package db.interfaces;

import java.util.List;


import pojos.*;

public interface DoctorManager {
	public void addNewDoctor(Doctor doctor);
	public Doctor getDoctorById(int id);
	public List<Doctor> listAllDoctors();	
	public Doctor getDoctorByUsername(String username);
	public List<Patient> listAllPatientsOfDoctor(int id);
	
}
