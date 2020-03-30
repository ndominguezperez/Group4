package db.sqlite;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.interfaces.PatientManager;
import pojos.Patient;
import java.sql.Connection;
import java.sql.Date;



public class SQLitePatientManager implements PatientManager{
	private Connection c;
 
	public SQLitePatientManager(Connection c) {
		this.c = c;
	}
	public void addNewPatient(Patient patient) {
		
		try {  
			String sql = "INSERT INTO patients (id, name, surname , date of birth , gender, medical chart) "
					+ "VALUES (?,?,?,?,?);";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, patient.getId());
			prep.setString(2, patient.getName());
			prep.setString(3, patient.getSurname());
			prep.setDate(4,patient.getDob());
			prep.setString(5, patient.getGender());
			prep.setString(6, patient.getMedical_chart());
			prep.executeUpdate();
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public List<Patient> listAllPatients() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Patient> searchByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Patient> searchBySurname(String surname) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Patient getPatient(int patientId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

