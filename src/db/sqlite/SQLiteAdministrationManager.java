package db.sqlite;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import db.interfaces.AdministrationManager;
import pojos.Appointment;
import pojos.Doctor;
import pojos.Examination;
import pojos.Patient;
import pojos.Treatment;
import ui.Menu;

public class SQLiteAdministrationManager implements AdministrationManager {
	private Connection c;
	
	public SQLiteAdministrationManager(Connection c) {
		this.c = c;
	}

	


	@Override
	public Treatment viewTreatment(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyTreatment(Treatment treatment) {

		{
			try {

				String sql = "UPDATE treatments SET disease=?, drug=?, finishDate=?  WHERE id=?";
				PreparedStatement s = c.prepareStatement(sql);
				s.setString(1, treatment.getDisease());
				s.setString(2, treatment.getDrug());
				s.setDate(3, treatment.getFinishDate());
				
				s.setInt(4, treatment.getId());
				s.executeUpdate();
				s.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}




	@Override
	public void modifyAppointment(Appointment appointment) {
		try {
			// Update every aspect of a particular appointment
			String sql = "UPDATE appointments SET type=?, date=?, speciality=?, time=?, doctorId=?, WHERE id=?";
			PreparedStatement s = c.prepareStatement(sql);
			s.setString(1, appointment.getType());
			s.setDate(2, appointment.getDate());
			s.setString(3, appointment.getSpeciality());
			s.setFloat(4, appointment.getTime());
			s.setInt(5, appointment.getDoctor().getId());
			s.setInt(6, appointment.getId());
			s.executeUpdate();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Appointment> listAllAppointments() {
		List <Appointment> appointmentsList= new ArrayList <Appointment>();
		try {
		String sql = "SELECT * FROM appointments ";
		PreparedStatement prep = c.prepareStatement(sql);
		ResultSet rs = prep.executeQuery();
		while(rs.next()) {	
			int id = rs.getInt("id");
			String type = rs.getString("type");
			String speciality = rs.getString("speciality");
			Date date = rs.getDate("date");
			float time = rs.getFloat("time");
			int doctorId = rs.getInt("doctorId");
			int patientId = rs.getInt("patientId");
			Appointment newAppointment= new Appointment(id,type,speciality,date,time,doctorId,patientId);
			appointmentsList.add(newAppointment);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return appointmentsList;
	}
	
	@Override
	public Appointment getAppointmentById(int id) {
		Appointment appointmentsList= new Appointment();
		try {
		String sql = "SELECT * FROM appointments WHERE id LIKE ? ";
		PreparedStatement prep = c.prepareStatement(sql);
		//prep.setString(1, "%" + date + "%");
		prep.setInt(1, id);
		ResultSet rs = prep.executeQuery();
		while(rs.next()) {
			String type = rs.getString("type");
			Date date = rs.getDate("date");
			String speciality = rs.getString("speciality");
			float time = rs.getFloat("time");
			int doctorId = rs.getInt("doctorId");
			int patientId = rs.getInt("patientId");
			Doctor doctor = Menu.doctorManager.getDoctorById(doctorId);
			Patient patient = Menu.patientManager.getPatient(patientId);
			Appointment newAppointment= new Appointment(id,type,date,time,speciality,doctor,patient);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return appointmentsList;
	}

	@Override
	public List<Appointment> searchAppointmentByDate(Date date) {
		List <Appointment> appointmentsList= new ArrayList <Appointment>();
		try {
		String sql = "SELECT * FROM appointments WHERE date LIKE ? ";
		PreparedStatement prep = c.prepareStatement(sql);
		//prep.setString(1, "%" + date + "%");
		prep.setDate(1, date);
		//prep.setString(2, "%" + patient.getId() + "%");
		//prep.setInt(2, patient.getId() );
		ResultSet rs = prep.executeQuery();
		while(rs.next()) {
			
			int id = rs.getInt("id");
			String type = rs.getString("type");
			String speciality = rs.getString("speciality");
			float time = rs.getFloat("time");
			int doctorId = rs.getInt("doctorId");
			int patientId = rs.getInt("patientId");
			Doctor doctor = Menu.doctorManager.getDoctorById(doctorId);
			Patient patient = Menu.patientManager.getPatientById(patientId);
			Appointment newAppointment= new Appointment(id,type,date,time,speciality,doctor,patient);
			appointmentsList.add(newAppointment);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return appointmentsList;
	}

	@Override
	public void addNewExamination(Examination examination) {
		// TODO Auto-generated method stub
			try { 
				
				String sql = "INSERT INTO examinations (temperature, breathingRate, heartRate , bloodPresure, oxygenSaturation, observations, patientId, doctorId) "
						+ "VALUES (?,?,?,?,?,?,?,?);";
				PreparedStatement prep = c.prepareStatement(sql);
				prep.setFloat(1, examination.getTemperature());
				prep.setInt(2, examination.getBreathing_rate());
				prep.setInt(3, examination.getHeart_rate());
				prep.setFloat(4,examination.getBlood_pressure());
		        prep.setFloat(5, examination.getOxygen_saturations());
				prep.setString(6, examination.getObservations()); 
				prep.setInt(7, examination.getPatient().getId());
				prep.setInt(8, examination.getDoctor().getId());
				prep.executeUpdate();
				prep.close();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}

	public List<Appointment> viewPatientSchedule (int patientId) {
		List<Appointment> appointmentList = new ArrayList<Appointment>();
		Patient newPatient = null;
		try {
			String sql = "SELECT * FROM patients AS p JOIN appointments AS a ON p.id = a.patientId"
					+"JOIN doctors AS d on a.doctorId = d.id"
					+ " WHERE p.id = ?"; 
			Appointment newAppointment = null;
			PreparedStatement p = c.prepareStatement(sql);
			p.setInt(1, patientId);
			ResultSet rs = p.executeQuery();
			
			boolean patientCreated = false;
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
					
				int appointmentId = rs.getInt(7);
				String type =rs.getString(8);
				String apSpeciality =rs.getString(9);
				Date date =rs.getDate(10);
				Float time =rs.getFloat(11);
				int doctorId = rs.getInt(12);
				Doctor newDoctor2 = new Doctor();
				newDoctor2 = ui.utilities.Utilities.getDoctortByIdPassingInt(doctorId) ;
				newAppointment = new Appointment(appointmentId, type, apSpeciality, date, time,newDoctor2);
				appointmentList.add(newAppointment);			
				
			}
			newPatient.setSchedule(appointmentList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return appointmentList;
		}
	
	
	public List<Appointment> viewDoctorSchedule (int doctorId) {
		List<Appointment> appointmentList = new ArrayList<Appointment>();
		Doctor newDoctor = null;
		try {
			String sql = "SELECT * FROM doctors AS d JOIN appointments AS a ON d.id = a.patientId"
					+"JOIN patients AS p on a.patientId = p.id"
					+ " WHERE p.id = ?"; 
			Appointment newAppointment = null;
			Patient newPatient = null;
			PreparedStatement p = c.prepareStatement(sql);
			p.setInt(1, doctorId);
			ResultSet rs = p.executeQuery();
			
			boolean doctorCreated = false;
			while (rs.next()) {
				if (!doctorCreated) {
					int pId = rs.getInt(1);
					String name = rs.getString(2);
					String speciality = rs.getString(3);
					float salary = rs.getFloat(4);
					Date dob = rs.getDate(5);
					Date startDate = rs.getDate(6);				
					newDoctor = new Doctor(pId, name,salary, dob,speciality, startDate);
					doctorCreated = true;
				}
					
				int appointmentId = rs.getInt(7);
				String type =rs.getString(8);
				String apSpeciality =rs.getString(9);
				Date date =rs.getDate(10);
				Float time =rs.getFloat(11);
				int patientId = rs.getInt(13);
				
				String patientName =rs.getString("name");
				String patientSurname =rs.getString("surname");
				Date patientDob =rs.getDate("dob");
				String patientMedicalChart =rs.getString("medicalChart");
				String gender = rs.getString("gender");
				
				
				//newPatient = ui.utilities.Utilities.se
				
				newAppointment = new Appointment(appointmentId, type, apSpeciality, date, time,newDoctor);
				newPatient = new Patient(patientId, patientName, patientSurname, patientDob, patientMedicalChart, gender);
				appointmentList.add(newAppointment);			
				
			}
			newPatient.setSchedule(appointmentList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return appointmentList;
		}
	
	@Override
	public List<Examination> viewExamination(int patientId) { 
		List <Examination> examinationList= new ArrayList<Examination>();

		try {
			String sql= "SELECT * FROM patients AS p JOIN examinations AS e ON p.id = e.patientId "
					 + " JOIN doctors AS d ON e.doctorId = d.id "
					 + " WHERE p.id = ? ";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, patientId);
			ResultSet rs = prep.executeQuery();
			boolean examinationCreated= false;
			boolean patientCreated= false;
			Patient newPatient= new Patient();
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
                int examinationId = rs.getInt(7);	
				String observations= rs.getString(8);
				Float temperature = rs.getFloat(9);
				int breathingRate= rs.getInt(10);
				int heartRate= rs.getInt(11);
				Float bloodPressure= rs.getFloat(12);
				Float oxygenSaturations= rs.getFloat(13);
                
				int doctorId= rs.getInt(16);
				String doctorName = rs.getString(17);
				String speciality =rs.getString(18);
				Doctor doctor= new Doctor(doctorId,doctorName, speciality );
		    Examination newExamination = new Examination (examinationId, observations, temperature, breathingRate, heartRate, bloodPressure, oxygenSaturations, doctor, newPatient);
		    System.out.println(newExamination);
			if(!examinationCreated) {
				examinationList.add(newExamination);
			}
				}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return examinationList;
	}


	public void addNewTreatment(Treatment treatment) {
		try {  
			String sql = "INSERT INTO treatments (disease, drug , finishDate, doctorId, patientId) "
					+ "VALUES (?,?,?,?,?);";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1, treatment.getDisease());
			prep.setString(2, treatment.getDrug());
			prep.setDate(3, treatment.getFinishDate());
			prep.setInt(4, treatment.getDoctor().getId());
			prep.setInt(5, treatment.getPatient().getId());
			
			prep.executeUpdate();
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void addNewAppointment(Appointment appointment) {
	try { 
		String sql = "INSERT INTO appointments (type ,speciality ,date ,time ,doctorId ,patientId) "
				+ "VALUES (?,?,?,?,?,?);";
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setString(1, appointment.getType());
		prep.setString(2, appointment.getSpeciality());
		prep.setDate(3, appointment.getDate());
		prep.setFloat(4, appointment.getTime());
		prep.setObject(5, appointment.getDoctor().getId());
		prep.setObject(6, appointment.getPatient().getId());
		
		prep.executeUpdate();
		prep.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

}	
