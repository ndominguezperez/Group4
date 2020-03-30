package db.interfaces;

import java.sql.Date;
import java.util.List;

import pojos.*;

public interface DoctorManager {
	public List<Patient> listAllPatients();
	public boolean createTreatmen(int id);
	public Treatment viewTreatment(int id);
	public boolean modifyTreatment(int id); 
	public void addNewDoctor(Doctor doctor);
	public List<Appointment> viewSchedule();
	public boolean setUpAppointment (Appointment appointment);
	public boolean modifyAppointment (Appointment appointment);
	public Appointment getAppointmentById(int id);
	public List<Appointment> searchAppoitmentByDate(Date date);
	public Examination viewExamination(int id);
	public boolean modifyExamination(int id); 
	public List <Result> viewResults();


}
