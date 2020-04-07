package db.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.interfaces.*;
import pojos.*;

public class SQLiteManager implements DBManager {
	
	private Connection c;
	private DoctorManager doctor;
	private PatientManager patient;

	public SQLiteManager() {
		super();
	}

	@Override
	public void connect() {
		try {
			// Open database connection
			Class.forName("org.sqlite.JDBC");
			this.c = DriverManager.getConnection("jdbc:sqlite:./db/patients.db");
			c.createStatement().execute("PRAGMA foreign_keys=ON");
			// Create DoctorManager
			doctor = new SQLiteDoctorManager(c);
			// Create MedicineManager
			patient = new SQLitePatientManager(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void disconnect() {
		try {
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void createTables() {
		
		Statement stmt1;
		try {
			stmt1 = c.createStatement();
			String sql1 = "CREATE TABLE doctors " + "(id     INTEGER  PRIMARY KEY AUTOINCREMENT,"
					+ " name   TEXT   NOT NULL, " + " speciality  TEXT   NOT NULL, " + " salary FLOAT  NOT NULL, "
					+ " startDate DATE   NOT NULL)";
			stmt1.executeUpdate(sql1);
			
			stmt1 = c.createStatement();
			String sql2 = "CREATE TABLE patients " + "(id     INTEGER  PRIMARY KEY,"
					+ " name   TEXT   NOT NULL," + " surname  TEXT   NOT NULL, " + "dateofbirth DATE NOT NULL, " + "medical_chart TEXT NOT NULL, " 
					+ " gender TEXT   NOT NULL, )";
			stmt1.executeUpdate(sql2);
			
			stmt1 = c.createStatement();
			String sql3= "CREATE TABLE appointments " + "(id     INTEGER  PRIMARY KEY,"
					+ " type   TEXT   NOT NULL," + " speciality  TEXT   NOT NULL, " 
					+ "date DATE NOT NULL" + "time FLOAT NOT NULL" 
					+ "doctor_id INTEGER, FOREIGN KEY(doctor_id) REFERENCES doctors(id)"
					+ "patient_id INTEGER, FOREIGN KEY(patient_id) REFERENCES patients(id))";
			stmt1.executeUpdate(sql3);
			
			stmt1 = c.createStatement();
			String sql4=  "CREATE TABLE examinations " + "(id     INTEGER  PRIMARY KEY,"
					+ "observations   TEXT   NOT NULL,"+ "temperature FLOAT NOT NULL" 
					+ "breathing_rate INTEGER NOT NULL" + "heart_rate INTEGER NOT NULL"
					+ "blood_pressure FLOAT NOT NULL" + "oxygen_saturations FLOAT NOT NULL" 
					+ "doctor_id INTEGER, FOREIGN KEY(doctor_id) REFERENCES doctors(id)"
					+ "patient_id INTEGER, FOREIGN KEY(patient_id) REFERENCES patients(id))";
			stmt1.executeUpdate(sql4);
			
			stmt1 = c.createStatement();
			String sql5=  "CREATE TABLE results " + "(id     INTEGER  PRIMARY KEY,"
					+ "type   TEXT   NOT NULL,"+ "date DATE NOT NULL" 
					+ "doctor_id INTEGER, FOREIGN KEY(doctor_id) REFERENCES doctors(id)"
					+ "patient_id INTEGER, FOREIGN KEY(patient_id) REFERENCES patients(id))";
			stmt1.executeUpdate(sql5);
			
			stmt1 = c.createStatement();
			String sql6=  "CREATE TABLE treatments " + "(id     INTEGER  PRIMARY KEY,"
					+ "disease   TEXT   NOT NULL,"+ "drug TEXT NOT NULL" 
					+ "finish_date DATE NOT NULL" 
					+ "doctor_id INTEGER, FOREIGN KEY(doctor_id) REFERENCES doctors(id)"
					+ "patient_id INTEGER, FOREIGN KEY(patient_id) REFERENCES patients(id))";
			stmt1.executeUpdate(sql6);
			
			stmt1= c.createStatement();//many to many relation between doctor and patient 
			String sql7 = "CREATE TABLE doctorsPatients " + "(doctorId     INTEGER  REFERENCES doctors(id), "
					+ "patientId     INTEGER  REFERENCES patients(id), " + "PRIMARY KEY(doctorId,patientId))";
			stmt1.executeUpdate(sql7);
			
			stmt1.close();
		} catch (SQLException e) {
			if (e.getMessage().contains("already exists")) {
			} else {
				e.printStackTrace();
			}

		}
		
	}

	@Override
	public DoctorManager getDoctorManager() {
		return doctor;
	}

	@Override
	public PatientManager getPatientManager() {
		return patient;
	}

	@Override
	public int getLastId() {
		int result = 0;
		try {
			String query = "SELECT last_insert_rowid() AS lastId";
			PreparedStatement p = c.prepareStatement(query);
			ResultSet rs = p.executeQuery();
			result = rs.getInt("lastId");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
 