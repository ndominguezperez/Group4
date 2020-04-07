package db.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import db.interfaces.DoctorManager;
import pojos.Doctor;
import pojos.Patient;

public class SQLiteDoctorManager implements DoctorManager {
	private Connection c;

	public SQLiteDoctorManager(Connection c) {
		this.c = c;
	}
	public void addNewDoctor(Doctor doctor) {
		
		try {  
			String sql = "INSERT INTO patients (name, salary , specialty, date of birth, start date) "
					+ "VALUES (?,?,?,?,?);";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1, doctor.getName());
			prep.setFloat(2, doctor.getSalary());
			prep.setString(3, doctor.getSpeciality());
			prep.setDate(4, doctor.getDob());
			prep.setDate(5, doctor.getStart_date());
			
			prep.executeUpdate();
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Patient> listAllPatientsOfDoctor() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Doctor getDoctorById(int id) {
		return null;
		
	}

	
	
	
	
	
}
