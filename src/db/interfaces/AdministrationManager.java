package db.interfaces;

import java.sql.Date;
import java.util.List;

import pojos.Appointment;
import pojos.Examination;
import pojos.Patient;
import pojos.Treatment;

public interface AdministrationManager {
	//Treatment
	public void addNewTreatment(Treatment treatment);
	public Treatment viewTreatment(int id);
	public boolean modifyTreatment(int id); 
	//Appointment
	public void addNewAppointment (Appointment appointment);
	public List<Appointment> viewPatientSchedule(int id);
	public List<Appointment> viewDoctorSchedule(int id);
	public boolean modifyAppointment (Appointment appointment);
	public Appointment getAppointmentById(int id);
	public List<Appointment> searchAppointmentByDate(Date date);
	//Examination
	public void addNewExamination(Examination examination);
	public Examination viewExamination(int id);
	public boolean modifyExamination(int id); 

	
}
