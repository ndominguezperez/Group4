package db.interfaces;

import java.util.List;

import pojos.*;

public interface PatientManager {
	public List<Appointment> viewSchedule();
	public List <Result> viewResults();
}
