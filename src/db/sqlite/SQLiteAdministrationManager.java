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
	public void addNewTreatment(Treatment treatment) {
		// TODO Auto-generated method stub
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
	public void addNewUpAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		
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
			String sql = "INSERT INTO results (type, date) "
					+ "VALUES (?,?);";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1, result.getType());
			prep.setDate(2, result.getDate());
			
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
	

}
