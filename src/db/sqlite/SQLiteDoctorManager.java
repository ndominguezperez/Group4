package db.sqlite;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
			String sql = "INSERT INTO doctors (name, salary , speciality, dob, startDate) "
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

	@Override
	public List<Doctor> listAllDoctors() {
		// Create an empty list of doctors
				List<Doctor> doctorsList = new ArrayList<Doctor>();
				// Search for all doctors
				try {
					String sql = "SELECT * FROM doctors";
					PreparedStatement prep = c.prepareStatement(sql);
					ResultSet rs = prep.executeQuery();
					// For each result...
					while (rs.next()) {
						int id = rs.getInt("id");
						String doctorName = rs.getString("name");
						Float doctorSalary = rs.getFloat("salary");
						String doctorSpeciality = rs.getString("speciality");
						Date doctorStartDate = rs.getDate("startDate");
						Date doctorDob = rs.getDate("dob");
						// Create a new dog and...
						Doctor newDoctor = new Doctor (id, doctorName, doctorSalary, doctorDob, doctorSpeciality, doctorStartDate);
						// Add it to the list
						doctorsList.add(newDoctor);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				// Return the list
				return doctorsList;
	}
	
	
	
	
}
