package db.interfaces;

import java.sql.Date;
import java.util.List;

import pojos.*;

public interface DoctorManager {
	public List<Patient> listAllPatientsofDoctor();
	public void addNewDoctor(Doctor doctor);
	
}
