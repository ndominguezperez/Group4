package db.interfaces;

import java.sql.Date;

import java.util.List;

import pojos.Appointment;
import pojos.Examination;
import pojos.Treatment;
import pojos.users.Role;
import pojos.users.User;

public interface AdministrationManager {
	//Treatment
	public void addNewTreatment(Treatment treatment);
	public void modifyTreatment(Treatment treatment); 
	public Treatment getTreatmentById(int id);
	public List<Treatment> viewTreatment (int id);
	public void deleteTreatment(Treatment treatment);
	
	//Appointment
	public void addNewAppointment (Appointment appointment);
	public List<Appointment> viewPatientSchedule(int id);
	public List<Appointment> viewDoctorSchedule(int id);
	public void modifyAppointment (Appointment appointment);
	public Appointment getAppointmentById(int id);
	public List<Appointment> searchAppointmentByDate(Date date);
	public List<Appointment> listAllAppointments();
	public void deleteAppointment(Appointment appointment);
	//Examination
	public void addNewExamination(Examination examination);
	public List<Examination> viewExamination(int patientId);
	//Log in
	public Role getRoleById(int roleId);
	public User getUserbyId(int userId);
	

	
}
