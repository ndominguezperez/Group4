package db.interfaces;

import java.sql.Date;
import java.util.List;

import pojos.Appointment;
import pojos.Examination;
import pojos.Patient;
import pojos.Result;
import pojos.Treatment;

public interface AdministrationManager {
	//Treatment
	public boolean createTreatmen(int id);
	public Treatment viewTreatment(int id);
	public boolean modifyTreatment(int id); 
	//Appointment
	public List<Appointment> viewSchedule(int id);
	public boolean setUpAppointment (Appointment appointment);
	public boolean modifyAppointment (Appointment appointment);
	public Appointment getAppointmentById(int id);
	public List<Appointment> searchAppoitmentByDate(Date date);
	//Examination
	public Examination viewExamination(int id);
	public boolean modifyExamination(int id); 
	public List <Result> viewResults();
}
