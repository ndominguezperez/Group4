package db.sqlite;

import java.sql.Date;
import java.util.List;

import db.interfaces.AdministrationManager;
import pojos.Appointment;
import pojos.Examination;
import pojos.Result;
import pojos.Treatment;

public class SQLiteAdministrationManager implements AdministrationManager {

	@Override
	public boolean createTreatment(int id) {
		// TODO Auto-generated method stub
		return false;
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
	public boolean setUpAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return false;
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
	public List<Result> viewResults() {
		// TODO Auto-generated method stub
		return null;
	}

}
