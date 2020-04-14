package db.sqlite;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

import db.interfaces.AdministrationManager;
import pojos.Appointment;
import pojos.Examination;
import pojos.Result;
import pojos.Treatment;

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
	public boolean modifyTreatment(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	

	
	@Override
	public List<Appointment> viewSchedule(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean modifyAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Appointment getAppointmentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Appointment> searchAppoitmentByDate(Date date) {
		// TODO Auto-generated method stub
		return null;
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

	
	@Override
	public Examination viewExamination(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifyExamination(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addNewResult(Result result) {
		try {  
			String sql = "INSERT INTO results (type, date, doctorId, patientId) "
					+ "VALUES (?,?,?,?);";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1, result.getType());
			prep.setDate(2, result.getDate());
			prep.setInt(3, result.getDoctor().getId());
			prep.setInt(4, result.getPatient().getId());
			
			prep.executeUpdate();
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Result> viewResults() {
		// TODO Auto-generated method stub
		return null;
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
