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
			String sql = "INSERT INTO patients (id, name, surname , dob, medical_chart, gender) "
					+ "VALUES (?,?,?,?,?,?);";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, patient.getId());
			prep.setString(2, patient.getName());
			prep.setString(3, patient.getSurname());
			prep.setDate(4,patient.getDob());
	        prep.setString(5, patient.getMedical_chart());
			prep.setString(6, patient.getGender()); 
			prep.executeUpdate();
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}


	@Override
	public List<Patient> listAllPatients() {
		// Create an empty list of patients
				List<Patient> patientsList = new ArrayList<Patient>();
				// Search for all patients
				try {
					String sql = "SELECT * FROM patients";
					PreparedStatement prep = c.prepareStatement(sql);
					ResultSet rs = prep.executeQuery();
					// For each result...
					while (rs.next()) {
						int id = rs.getInt("id");
						String patientName = rs.getString("name");
						String patientSurname = rs.getString("surname");
						Date patientDob = rs.getDate("dob");
						String patientMedical_chart = rs.getString("medical_chart");
						String patientGender = rs.getString("gender");
						// Create a new dog and...
						Patient newPatient = new Patient (id, patientName, patientSurname, patientDob, patientMedical_chart, patientGender);
						// Add it to the list
						patientsList.add(newPatient);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				// Return the list
				return patientsList;
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

	
	

	public Patient getPatient (int patientId) {return null;}/*
		// Get Patients
		Patient newPatient = null;
		try {
			String sql = "SELECT * FROM patients AS d JOIN dogsMedicines AS dm ON d.id = dm.dogId"
					+ " JOIN medicines AS m ON dm.medicineId = m.id" + " WHERE d.id = ?";
			// Get the joining of three tables
			// id, name, breed, weight, admissionDate, releaseDate, dogId, medicineId, id,
			// name
			// EXAMPLE
			// 1, Lassie, Collie, 10, 2020-06-01, 2020-08-01, 1, 1, 1, Dalsi
			// 1, Lassie, Collie, 10, 2020-06-01, 2020-08-01, 1, 2, 2, Dogmotril
			PreparedStatement p = c.prepareStatement(sql);
			p.setInt(1, dogId);
			ResultSet rs = p.executeQuery();
			List<Medicine> medicinesList = new ArrayList<Medicine>();
			// WHEN YOU DO A JOIN WITH SQLITE YOU CANNOT USE COLUMN NAMES
			// YOU MUST USE NUMBERS INSTEAD
			// THIS IS BECAUSE SQLITE DOESN'T SUPPORT JOINS WITH ALIASES
			// To avoid creating the dog several times
			boolean dogCreated = false;
			while (rs.next()) {
				// If the dog has not been created
				if (!dogCreated) {
					// Get the dog information
					int newDogId = rs.getInt(1);
					String dogName = rs.getString(2);
					String breed = rs.getString(3);
					float weight = rs.getFloat(4);
					Date admissionDate = rs.getDate(5);
					Date releaseDate = rs.getDate(6);
					// Create a new dog
					newDog = new Dog(newDogId, dogName, breed, weight, admissionDate, releaseDate);
					dogCreated = true;
				}
				// Get the medicine information
				int medicineId = rs.getInt(9);
				String medicineName = rs.getString(10);
				Medicine newMedicine = new Medicine(medicineId, medicineName);
				medicinesList.add(newMedicine);
			}
			newDog.setMedicines(medicinesList);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newDog;
	}*/
}

