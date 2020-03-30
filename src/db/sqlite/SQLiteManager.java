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
			String sql1 = "CREATE TABLE dogs " + "(id     INTEGER  PRIMARY KEY AUTOINCREMENT,"
					+ " name   TEXT   NOT NULL, " + " breed  TEXT   NOT NULL, " + " weight FLOAT  NOT NULL, "
					+ " admissionDate DATE   NOT NULL, " + " releaseDate DATE)";
			stmt1.executeUpdate(sql1);
			stmt1 = c.createStatement();
			String sql2 = "CREATE TABLE medicines " + "(id     INTEGER  PRIMARY KEY AUTOINCREMENT,"
					+ " name   TEXT   NOT NULL)";
			stmt1.executeUpdate(sql2);
			stmt1 = c.createStatement(); // Many to many dog-medicines table
			String sql3 = "CREATE TABLE dogsMedicines " + "(dogId     INTEGER  REFERENCES dogs(id), "
					+ "medicineId     INTEGER  REFERENCES medicines(id), " + "PRIMARY KEY(dogid,medicineId))";
			stmt1.executeUpdate(sql3);
			// Insert some medicines
			stmt1 = c.createStatement();
			String sqlMed1 = "INSERT INTO medicines (name) VALUES ('Dalsi')";
			stmt1.executeUpdate(sqlMed1);
			stmt1 = c.createStatement();
			String sqlMed2 = "INSERT INTO medicines (name) VALUES ('Dogmotril')";
			stmt1.executeUpdate(sqlMed2);
			stmt1 = c.createStatement();
			String sqlMed3 = "INSERT INTO medicines (name) VALUES ('Antiparasitics')";
			stmt1.executeUpdate(sqlMed3);
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
 