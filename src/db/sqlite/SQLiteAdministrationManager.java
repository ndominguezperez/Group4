package db.sqlite;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.interfaces.AdministrationManager;
import pojos.Appointment;
import pojos.Doctor;
import pojos.Examination;
import pojos.Patient;
import pojos.Treatment;
import pojos.users.Role;
import pojos.users.User;
import ui.Menu;

public class SQLiteAdministrationManager implements AdministrationManager {
	private Connection c;

	public SQLiteAdministrationManager(Connection c) {
		this.c = c;
	}

	@Override
	public void modifyTreatment(Treatment treatment) {
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

	@Override
	public void modifyAppointment(Appointment appointment) {
		try {
			String sql = "UPDATE appointments SET type=?, date=?, speciality=?, time=?, doctorId=? WHERE id=?";
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
		List<Appointment> appointmentsList = new ArrayList<Appointment>();
		try {
			String sql = "SELECT * FROM appointments ";
			PreparedStatement prep = c.prepareStatement(sql);
			ResultSet rs = prep.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String type = rs.getString("type");
				String speciality = rs.getString("speciality");
				Date date = rs.getDate("date");
				float time = rs.getFloat("time");
				int doctorId = rs.getInt("doctorId");
				int patientId = rs.getInt("patientId");
				Appointment newAppointment = new Appointment(id, type, speciality, date, time, doctorId, patientId);
				appointmentsList.add(newAppointment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return appointmentsList;
	}

	@Override
	public Appointment getAppointmentById(int id) {
		Appointment newAppointment = null;
		try {
			String sql = "SELECT * FROM appointments WHERE id LIKE ? ";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, id);
			ResultSet rs = prep.executeQuery();
			while (rs.next()) {
				String type = rs.getString("type");
				Date date = rs.getDate("date");
				String speciality = rs.getString("speciality");
				float time = rs.getFloat("time");
				int doctorId = rs.getInt("doctorId");
				int patientId = rs.getInt("patientId");
				Doctor doctor = Menu.doctorManager.getDoctorById(doctorId);
				Patient patient = Menu.patientManager.getPatient(patientId);
				newAppointment = new Appointment(id, type, date, time, speciality, doctor, patient);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newAppointment;
	}

	@Override
	public List<Appointment> searchAppointmentByDate(Date date) {
		List<Appointment> appointmentsList = new ArrayList<Appointment>();
		try {
			String sql = "SELECT * FROM appointments WHERE date LIKE ? ";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setDate(1, date);
			ResultSet rs = prep.executeQuery();
			while (rs.next()) {

				int id = rs.getInt("id");
				String type = rs.getString("type");
				String speciality = rs.getString("speciality");
				float time = rs.getFloat("time");
				int doctorId = rs.getInt("doctorId");
				int patientId = rs.getInt("patientId");
				Doctor doctor = Menu.doctorManager.getDoctorById(doctorId);
				Patient patient = Menu.patientManager.getPatientById(patientId);
				Appointment newAppointment = new Appointment(id, type, date, time, speciality, doctor, patient);
				appointmentsList.add(newAppointment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return appointmentsList;
	}

	@Override
	public void addNewExamination(Examination examination) {
		try {

			String sql = "INSERT INTO examinations (temperature, breathingRate, heartRate , bloodPressure, oxygenSaturations, observations, patientId, doctorId) "
					+ "VALUES (?,?,?,?,?,?,?,?);";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setFloat(1, examination.getTemperature());
			prep.setInt(2, examination.getBreathing_rate());
			prep.setInt(3, examination.getHeart_rate());
			prep.setFloat(4, examination.getBlood_pressure());
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

	public List<Appointment> viewPatientSchedule(int patientId) {
		List<Appointment> appointmentList = new ArrayList<Appointment>();
		Patient newPatient = null;
		try {
			String sql = "SELECT * FROM patients AS p JOIN appointments AS a ON p.id = a.patientId "
					+ " JOIN doctors AS d on a.doctorId = d.id" + " WHERE p.id = ?";
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

				int appointmentId = rs.getInt(8);
				String type = rs.getString(9);
				String apSpeciality = rs.getString(10);
				Date date = rs.getDate(11);
				Float time = rs.getFloat(12);
				int doctorId = rs.getInt(13);
				Doctor newDoctor2 = new Doctor();
				newDoctor2 = ui.utilities.Utilities.getDoctortByIdPassingInt(doctorId);
				newAppointment = new Appointment(appointmentId, type, apSpeciality, date, time, newDoctor2);
				appointmentList.add(newAppointment);

			}
			newPatient.setSchedule(appointmentList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return appointmentList;
	}

	public List<Appointment> viewDoctorSchedule(int doctorId) {
		List<Appointment> appointmentList = new ArrayList<Appointment>();
		Doctor newDoctor = null;
		try {
			String sql = "SELECT * FROM doctors AS d JOIN appointments AS a ON d.id = a.doctorId"
					+ " JOIN patients AS p on a.patientId = p.id" + " WHERE d.id = ?";
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
					newDoctor = new Doctor(pId, name, salary, dob, speciality, startDate);
					doctorCreated = true;
				}

				int appointmentId = rs.getInt(8);
				String type = rs.getString(9);
				String apSpeciality = rs.getString(10);
				Date date = rs.getDate(11);
				Float time = rs.getFloat(12);
				
				int patientId = rs.getInt(15);
				String patientName = rs.getString(16);
				String patientSurname = rs.getString(17);
				Date patientDob = rs.getDate(18);
				String patientMedicalChart = rs.getString(19);
				String gender = rs.getString(20);

				newAppointment = new Appointment(appointmentId, type, apSpeciality, date, time, newDoctor);
				newPatient = new Patient(patientId, patientName, patientSurname, patientDob, patientMedicalChart,
						gender);
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
		List<Examination> examinationList = new ArrayList<Examination>();

		try {
			String sql = "SELECT * FROM patients AS p JOIN examinations AS e ON p.id = e.patientId "
					+ " JOIN doctors AS d ON e.doctorId = d.id " + " WHERE p.id = ? ";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, patientId);
			ResultSet rs = prep.executeQuery();
			boolean examinationCreated = false;
			boolean patientCreated = false;
			Patient newPatient = new Patient();
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
				int examinationId = rs.getInt(8);
				String observations = rs.getString(9);
				Float temperature = rs.getFloat(10);
				int breathingRate = rs.getInt(11);
				int heartRate = rs.getInt(12);
				Float bloodPressure = rs.getFloat(13);
				Float oxygenSaturations = rs.getFloat(14);

				int doctorId = rs.getInt(17);
				String doctorName = rs.getString(18);
				String speciality = rs.getString(19);
				Doctor doctor = new Doctor(doctorId, doctorName, speciality);
				Examination newExamination = new Examination(examinationId, observations, temperature, breathingRate,
						heartRate, bloodPressure, oxygenSaturations, doctor, newPatient);
				if (!examinationCreated) {
					examinationList.add(newExamination);
				}
			}

		} catch (SQLException e) {
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

	@Override
	public Treatment getTreatmentById(int id) {
		Treatment treatment = null;
		try {
			String sql = "SELECT * FROM treatments WHERE id LIKE ? ";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, id);
			ResultSet rs = prep.executeQuery();
			while (rs.next()) {
				String disease = rs.getString("disease");
				String drug = rs.getString("drug");
				Date finishDate = rs.getDate("finishDate");
				int doctorId = rs.getInt("doctorId");
				int patientId = rs.getInt("patientId");
				Doctor doctor = Menu.doctorManager.getDoctorById(doctorId);
				Patient patient = Menu.patientManager.getPatient(patientId);
				treatment = new Treatment(id, disease, drug, finishDate, patient, doctor);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return treatment;
	}

	public List<Treatment> viewTreatment(int patientId) {
		List<Treatment> treatmentList = new ArrayList<Treatment>();
		try {

			String sql = "SELECT * FROM patients AS p JOIN treatments AS t ON p.id = t.patientId "
					+ " JOIN doctors AS d ON t.doctorId = d.id " + " WHERE p.id = ? ";

			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, patientId);
			ResultSet rs = prep.executeQuery();
			boolean treatmentCreated = false;
			boolean patientCreated = false;
			Patient newPatient = null;

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

				int treatmentId = rs.getInt(8);
				String disease = rs.getString(9);
				String drug = rs.getString(10);
				Date finishDate = rs.getDate(11);

				int doctorId = rs.getInt(14);
				String doctorName = rs.getString(15);
				String speciality = rs.getString(16);
				Doctor doctor = new Doctor(doctorId, doctorName, speciality);

				Treatment newTreatment = new Treatment(treatmentId, disease, drug, finishDate, newPatient, doctor);
				if (!treatmentCreated) {
					treatmentList.add(newTreatment);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return treatmentList;
	}

	@Override
	public void deleteTreatment(Treatment treatment) {
		try {
			String sql = "DELETE FROM treatments WHERE id = ?";
			PreparedStatement prep = c.prepareStatement(sql);
			System.out.println(treatment.getId());
			prep.setInt(1, treatment.getId());
			prep.executeUpdate();
			prep.close();
			System.out.println("Deleted success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAppointment(Appointment appointment) {
		try {
			String sql = "DELETE FROM appointments WHERE id = ?";
			PreparedStatement prep = c.prepareStatement(sql);
			System.out.println(appointment.getId());
			prep.setInt(1, appointment.getId());
			prep.executeUpdate();
			prep.close();
			System.out.println("Deleted success");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Role getRoleById(int id) {
		Role role = new Role();
		try {
			String sql = "SELECT * FROM roles WHERE id LIKE ? ";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, id);
			ResultSet rs = prep.executeQuery();
			while (rs.next()) {
				String roleName = rs.getString("role");
				role = new Role(id, roleName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return role;
	}

	@Override
	public User getUserbyId(int userId) {
		User user = new User();
		try {
			String sql = "SELECT * FROM users "
					+ "WHERE id LIKE ? ";
			PreparedStatement prep = c.prepareStatement(sql);
			prep.setInt(1, userId);
			ResultSet rs = prep.executeQuery();
			while (rs.next()) {
				String username = rs.getString("username");
				byte[] password = rs.getBytes("password");
				user = new User(username,password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
