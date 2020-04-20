package db.sqlite;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.interfaces.DoctorManager;
import pojos.Doctor;

import pojos.Patient;
import pojos.Treatment;

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
		Doctor newDoctor=null;
		try {
		String sql = "SELECT * FROM doctors WHERE id LIKE ?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setString(1, "%" + id + "%");
		ResultSet rs = prep.executeQuery();
		while(rs.next()) {
			int doctorId = rs.getInt("id");
			String doctorName = rs.getString("name");
			String speciality = rs.getString("speciality");
			 newDoctor= new Doctor(id,doctorName,speciality);
			
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newDoctor;
		
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
	
	public List<Treatment> viewTreatment(int patientId) {
		List <Treatment> treatmentList = new ArrayList<Treatment>();
		try {
	  
		String sql = "SELECT * FROM patients AS p JOIN treatments AS t ON p.id = t.patientId "
				 + " JOIN doctors AS d ON t.doctorId = d.id "
				 + " WHERE p.id = ? ";
				

		PreparedStatement prep = c.prepareStatement(sql);
		prep.setInt(1, patientId);
		ResultSet rs = prep.executeQuery();
		boolean treatmentCreated= false;
		boolean patientCreated= false;
		Patient newPatient= new Patient();
		
		boolean doctorCreated=false;
		while (rs.next()) {
			if (!patientCreated) {
			int pId = rs.getInt(1);
			String name = rs.getString(2);
			String surname = rs.getString(3);
			Date dob = rs.getDate(4);
			String medicalChart = rs.getString(5);
			String gender = rs.getString(6);
			newPatient = new Patient(pId, name, surname, dob, medicalChart, gender);
			patientCreated = true;}
		
			int treatmentId = rs.getInt(7);
			String disease =rs.getString(8);
			String drug =rs.getString(9);
			Date finishDate =rs.getDate(10);
			
			int doctorId= rs.getInt(13);
			String doctorName = rs.getString(14);
			String speciality =rs.getString(15);
			Doctor doctor= new Doctor(doctorId,doctorName, speciality );
			
			Treatment newTreatment = new Treatment(treatmentId,disease,drug,finishDate,newPatient,doctor);
			System.out.println(newTreatment);
		
			if(!treatmentCreated) {
				treatmentList.add(newTreatment);
			}
				}
		
		 }catch (SQLException e) {
			e.printStackTrace();
		}
	 
		
		
		
		return treatmentList;
		
	
	
	}
	

}