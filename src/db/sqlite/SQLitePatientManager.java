package db.sqlite;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.interfaces.PatientManager;
import pojos.Appointment;
import pojos.Doctor;
import pojos.Patient;
import pojos.users.Role;
import pojos.users.User;
import ui.Menu;
import ui.utilities.Utilities;

import java.sql.Connection;
import java.sql.Date;



public class SQLitePatientManager implements PatientManager{
	private Connection c;
 
	public SQLitePatientManager(Connection c) {
		this.c = c;
	}
	public void addNewPatient(Patient patient, Doctor doctor) {
		try {  
			String sql = "INSERT INTO patients (id, name, surname , dob, medicalChart, gender, userId) "
					+ "VALUES (?,?,?,?,?,?,?);";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, patient.getId());
			prep.setString(2, patient.getName());
			prep.setString(3, patient.getSurname());
			prep.setDate(4,patient.getDob());
	        prep.setString(5, patient.getMedical_chart());
			prep.setString(6, patient.getGender()); 
			prep.setInt(7, patient.getUser().getId());
			prep.executeUpdate();
			prep.close();
		    assign(doctor.getId(), patient.getId());

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
						String patientMedical_chart = rs.getString("medicalChart");
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
		List <Patient> patientList= new ArrayList <Patient>();
		try {
		String sql = "SELECT * FROM patients WHERE name LIKE ?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setString(1, "%" + name + "%");
		ResultSet rs = prep.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			String patientName = rs.getString("name");
			String patientSurname = rs.getString("surname");
			Date dob = rs.getDate("dob");
			Patient newPatient= new Patient(id,patientName,patientSurname,dob);
			patientList.add(newPatient);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return patientList;
	}
	
	@Override
	public List<Patient> searchBySurname(String surname) {
		List <Patient> patientList= new ArrayList <Patient>();
		try {
		String sql = "SELECT * FROM patients WHERE surname LIKE ?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setString(1, "%" + surname + "%");
		ResultSet rs = prep.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("id");
			String patientName = rs.getString("name");
			String patientSurname = rs.getString("surname");
			Date dob = rs.getDate("dob");
			Patient newPatient= new Patient(id,patientName,patientSurname,dob);
			patientList.add(newPatient);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return patientList;

	}
	
	public Patient getPatient (int patientId) {
		Patient newPatient = null;
		try {
			String sql = "SELECT * FROM patients AS p JOIN doctorsPatients AS dp ON p.id = dp.patientId"
					+ " JOIN doctors AS d ON dp.doctorId = d.id" 
			       // + " JOIN  appointments AS a ON p.id=a.patientId"
					//+ " JOIN  treatments AS t ON p.id=t.patientId"
			        
					+ " WHERE p.id = ?"; //AND a.doctor_id = d.id";
		
			PreparedStatement p = c.prepareStatement(sql);
			p.setInt(1, patientId);
			ResultSet rs = p.executeQuery();
			List<Doctor> doctorList = new ArrayList<Doctor>();
			List<Appointment> appointmentList = new ArrayList<Appointment>();
			boolean patientCreated = false;
			boolean doctorCreated = false;
			while (rs.next()) {
				if (!patientCreated) {
					int pId = rs.getInt(1);
					String name = rs.getString(2);
					String surname = rs.getString(3);
					Date dob = rs.getDate(4);
					String medicalChart = rs.getString(5);
					String gender = rs.getString(6);
					newPatient = new Patient(pId, name, surname, dob, medicalChart, gender);
					patientCreated = true;
				}
				int docId = rs.getInt(9);
				String docName = rs.getString(10);
				String speciality =rs.getString(11);
				
				Doctor newDoctor = new Doctor(docId, docName, speciality);
				if (!doctorList.contains(newDoctor)) { 
					doctorList.add(newDoctor); 
				}
				
				
				/*int appointmentId = rs.getInt(15);
				String type =rs.getString(16);
				String apSpeciality =rs.getString(17);
				Date date =rs.getDate(18);
				Float time =rs.getFloat(19);
				int doctorId = rs.getInt(20);
				Doctor newDoctor2 = new Doctor();
				newDoctor2 = ui.utilities.Utilities.getDoctortByIdPassingInt(doctorId) ;
				Appointment newAppointment = new Appointment(appointmentId, type, apSpeciality, date, time,newDoctor2);
				appointmentList.add(newAppointment);*/
				
			}

			try{
				newPatient.setDoctors(doctorList);
			}catch(NullPointerException n) {
			}
			/*try {
				newPatient.setSchedule(appointmentList);
			}catch(NullPointerException n){
				System.out.println("This patient doesn't have any appointments");
			}*/
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newPatient;
		}
	
	public Patient getPatientById (int patientId) {
		Patient newPatient=null;
		try {
		String sql = "SELECT * FROM patients WHERE id LIKE ?";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setString(1, "%" + patientId + "%");
		ResultSet rs = prep.executeQuery();
		while(rs.next()) {
			String patientName = rs.getString("name");
			String patientSurname = rs.getString("surname");
			Date patientDob = rs.getDate("dob");
			String gender = rs.getString("gender");
			newPatient= new Patient(patientId,patientName,patientSurname,patientDob,gender);
			
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newPatient;
		
	}
	
	public void assign(int doctorId, int patientId) {
		try {
			String sql = "INSERT INTO doctorsPatients (doctorId, patientId) "
					+ "VALUES (?,?);";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, doctorId);
			prep.setInt(2, patientId);
			prep.executeUpdate();
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void modifyPatient(Patient patient) {
		
	}
	
	@Override
	public void deletePatient(Patient patient) {
		try {
			System.out.println(patient);
			String sql = "DELETE FROM patients WHERE id = ?";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, patient.getId());
			prep.executeUpdate();
			prep.close();
			System.out.println("Deleted success");
		}catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	@Override
	public Patient getPatientByUsername(String username) {
		Patient patient = null;
		try {
			  
			String sql = "SELECT * FROM users AS u JOIN patients AS p ON u.id = p.userId  "
					 + " WHERE u.username = ? ";
			
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1, username);
			ResultSet rs = prep.executeQuery();
			User newUser = null;
			boolean patientCreated=false;
			while (rs.next()) {
				if (!patientCreated) {
				int userId = rs.getInt(1);
				byte[] password = rs.getBytes(3);
				int roleId = rs.getInt(4);
				Role role = Menu.administrationManager.getRoleById(roleId);
				newUser = new User(userId, username, password, role);
				}
				int patientId= rs.getInt(5);
				String patientName = rs.getString(6);
				String patientSurname = rs.getString(7);
				Date dob = rs.getDate(8);
				String medicalChart =rs.getString(9);
				String gender =rs.getString(10);
				
				patient= new Patient(patientId,patientName,patientSurname,dob,medicalChart,gender,newUser);
				}
			
			 }catch (SQLException e) {
				e.printStackTrace();
			}

		return patient;
	}
	
}

