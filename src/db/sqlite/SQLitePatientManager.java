package db.sqlite;
import java.sql.PreparedStatement;
import pojos.Patient;
import java.sql.Connection;



public class SQLitePatientManager {
	private Connection c;
 
	public SQLitePatientManager(Connection c) {
		this.c = c;
	}
	public void addNewPatient(Patient patient) {
		
		try {  
			String sql = "INSERT INTO patients (name, surname , date of birth , gender, medical chart) "
					+ "VALUES (?,?,?,?,?);";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setString(1, patient.getName());
			prep.setString(2, patient.getSurname());
			prep.setDate(3, patient.getDob());
			prep.setString(4, patient.getGender());
			prep.setString(5, patient.getMedical_chart());
			prep.executeUpdate();
			prep.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

