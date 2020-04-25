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
import pojos.users.Role;
import pojos.users.User;
import ui.Menu;

public class SQLiteDoctorManager implements DoctorManager {
	private Connection c;

	public SQLiteDoctorManager(Connection c) {
		this.c = c;
	}
	public void addNewDoctor(Doctor doctor) {
		
		try {  
			String sql = "INSERT INTO doctors (name, salary , speciality, dob, startDate, userId) "
					+ "VALUES (?,?,?,?,?,?);";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1, doctor.getName());
			prep.setFloat(2, doctor.getSalary());
			prep.setString(3, doctor.getSpeciality());
			prep.setDate(4, doctor.getDob());
			prep.setDate(5, doctor.getStart_date());
			prep.setInt(6,doctor.getUser().getId());
			
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
	@Override
	public Doctor getDoctorByUsername(String username) {
		Doctor doctor = null;
		try {
			  
			String sql = "SELECT * FROM users AS u JOIN doctors AS d ON u.id = d.userId  "
					 + " WHERE u.username = ? ";
			
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1, username);
			ResultSet rs = prep.executeQuery();
			User newUser = null;
			boolean doctorCreated=false;
			while (rs.next()) {
				if (!doctorCreated) {
				int userId = rs.getInt(1);
				byte[] password = rs.getBytes(3);
				int roleId = rs.getInt(4);
				Role role = Menu.administrationManager.getRoleById(roleId);
				newUser = new User(userId, username, password, role);
				}
				int doctorId= rs.getInt(5);
				String doctorName = rs.getString(6);
				String speciality =rs.getString(7);
				float salary = rs.getFloat(8);
				Date dob = rs.getDate(9);
				Date startDate =rs.getDate(10);
				doctor= new Doctor(doctorId,doctorName,salary,speciality,dob,startDate,newUser);
				}
			
			 }catch (SQLException e) {
				e.printStackTrace();
			}

		return doctor;
	}
	
	@Override
    public List<Patient> listAllPatientsOfDoctor(int docId) {
          List<Patient> patientsList = new ArrayList<Patient>();
          try {
                 String sql = " SELECT * FROM doctors AS d JOIN doctorsPatients AS dp ON d.id= dp.doctorId"
                              +" JOIN patients AS p ON dp.patientId = p.id"
                               +" WHERE d.id= ? ";

                 PreparedStatement prep = c.prepareStatement(sql);
                 prep.setInt(1, docId);
                 ResultSet rs = prep.executeQuery();
                 while (rs.next()) {
                        int id = rs.getInt(10);
                        String patientName = rs.getString(11);
                        String patientSurname = rs.getString(12);
                        Date patientDob = rs.getDate(13);
                        String patientMedicalChart = rs.getString(14);
                        String patientGender = rs.getString(15);
                        int userId=rs.getInt(16);
                        User user = Menu.administrationManager.getUserbyId(userId);
                        Patient newPatient = new Patient (id, patientName, patientSurname, patientDob, patientMedicalChart, patientGender,user);
                        patientsList.add(newPatient);
                 }
          } catch (Exception e) {
                 e.printStackTrace();
          }
          return patientsList;
    }

	

}