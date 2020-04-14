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
	private AdministrationManager admin;

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
			// Create PatientManager
			patient = new SQLitePatientManager(c);
			// Create AdminManager
			admin  = new SQLiteAdministrationManager(c);
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
		
		try {
			Statement stmt1;
			stmt1 = c.createStatement();
			String sql1 = "CREATE TABLE doctors " + "(id     INTEGER  PRIMARY KEY AUTOINCREMENT,"
					+ " name   TEXT   NOT NULL, " + " speciality  TEXT   NOT NULL, " + " salary FLOAT  NOT NULL, "
					+ "dob DATE NOT NULL, " + " startDate DATE   NOT NULL)";
			stmt1.executeUpdate(sql1);
			stmt1.close();
			
			Statement stmt2;
			stmt2 = c.createStatement();
			String sql2 = "CREATE TABLE patients " + "(id     INTEGER  PRIMARY KEY,"
					+ " name   TEXT   NOT NULL," + " surname  TEXT   NOT NULL, " + "dob DATE NOT NULL, " 
					+ "medicalChart TEXT NOT NULL, " + " gender TEXT   NOT NULL )";
			stmt2.executeUpdate(sql2);
			stmt2.close();
			
			Statement stmt3;
			stmt3 = c.createStatement();
			String sql3 = "CREATE TABLE appointments " + "(id     INTEGER  PRIMARY KEY AUTOINCREMENT,"
					+ "type TEXT   NOT NULL," + " speciality  TEXT   NOT NULL, " 
					+ "date DATE NOT NULL," + "time FLOAT NOT NULL," 
					+ "doctorId INTEGER REFERENCES doctors(id)ON UPDATE CASCADE ON DELETE SET NULL,"
					+ "patientId INTEGER REFERENCES patients(id)ON UPDATE CASCADE ON DELETE SET NULL)";
					
					
			//+ "doctorId INTEGER ,"
			//+ "patientId INTEGER, "
			//+ "FOREIGN KEY (doctorId) REFERENCES doctors(id), " 
			//+ "FOREIGN KEY (patientId) REFERENCES patients(id))";
			
			//+ "doctorId INTEGER REFERENCES doctors(id)ON UPDATE CASCADE ON DELETE SET NULL,"
			//+ "patientId INTEGER REFERENCES patients(id)ON UPDATE CASCADE ON DELETE SET NULL)";
			
			//+ "doctor_id INTEGER FOREIGN KEY(doctor_id) REFERENCES doctors(id),"
			//+ "patient_id INTEGER FOREIGN KEY(patient_id) REFERENCES patients(id))";
			stmt3.executeUpdate(sql3);
			stmt3.close();
			
			Statement stmt4;
			stmt4 = c.createStatement();
			String sql4 =  "CREATE TABLE examinations " + "(id     INTEGER  PRIMARY KEY AUTOINCREMENT,"
					+ "observations   TEXT   NOT NULL,"+ "temperature FLOAT NOT NULL," 
					+ "breathingRate INTEGER NOT NULL," + "heartRate INTEGER NOT NULL,"
					+ "bloodPressure FLOAT NOT NULL," + "oxygenSaturations FLOAT NOT NULL," 
					+ "doctorId INTEGER REFERENCES doctors(id)ON UPDATE CASCADE ON DELETE SET NULL,"
					+ "patientId INTEGER REFERENCES patients(id)ON UPDATE CASCADE ON DELETE SET NULL )";

			//+ "doctor_id INTEGER FOREIGN KEY(doctor_id) REFERENCES doctors(id),"
			//+ "patient_id INTEGER FOREIGN KEY(patient_id) REFERENCES patients(id))";
			stmt4.executeUpdate(sql4);
			stmt4.close();
			
			Statement stmt5;
			stmt5 = c.createStatement();
			String sql5=  "CREATE TABLE results " + "(id     INTEGER  PRIMARY KEY AUTOINCREMENT,"
					+ "type   TEXT   NOT NULL,"+ "date DATE NOT NULL," 
					+ "doctorId INTEGER REFERENCES doctors(id)ON UPDATE CASCADE ON DELETE SET NULL,"
					+ "patientId INTEGER REFERENCES patients(id)ON UPDATE CASCADE ON DELETE SET NULL)";
			
			//+ "doctor_id INTEGER FOREIGN KEY(doctor_id) REFERENCES doctors(id),"
			//+ "patient_id INTEGER FOREIGN KEY(patient_id) REFERENCES patients(id))";
			stmt5.executeUpdate(sql5);
			stmt5.close();
		
			Statement stmt6;
			stmt6 = c.createStatement();
			String sql6=  "CREATE TABLE treatments " + "(id     INTEGER  PRIMARY KEY AUTOINCREMENT,"
					+ "disease   TEXT   NOT NULL,"+ "drug TEXT NOT NULL," 
					+ "finishDate DATE NOT NULL," 
					+ "doctorId INTEGER REFERENCES doctors(id)ON UPDATE CASCADE ON DELETE SET NULL,"
					+ "patientId INTEGER REFERENCES patients(id)ON UPDATE CASCADE ON DELETE SET NULL)";
			
			//+ "doctor_id INTEGER FOREIGN KEY(doctor_id) REFERENCES doctors(id),"
			//+ "patient_id INTEGER FOREIGN KEY(patient_id) REFERENCES patients(id))";
			stmt6.executeUpdate(sql6);
			stmt6.close();
			
			Statement stmt7;
			stmt7= c.createStatement();//many to many relation between doctor and patient 
			String sql7 = "CREATE TABLE doctorsPatients " + "(doctorId     INTEGER  REFERENCES doctors(id), "
					+ "patientId  INTEGER  REFERENCES patients(id), " + "PRIMARY KEY(doctorId,patientId))";
			stmt7.executeUpdate(sql7);
			stmt7.close();
			
			
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

	@Override
	public AdministrationManager getAdministrationManager() {
		return admin;
	}
}
 