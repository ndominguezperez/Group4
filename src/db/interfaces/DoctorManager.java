package db.interfaces;

import java.sql.Date;
import java.util.List;

import pojos.*;

public interface DoctorManager {
	public List<Patient> listAllPatientsOfDoctor();
	public void addNewDoctor(Doctor doctor);
	//Hayq ue hacerla public Doctor getDoctorById(int id);	
}
