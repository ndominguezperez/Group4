package pojos;

import java.io.Serializable;
import java.sql.Date;


public class Appointment implements Serializable{
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 2382859282871358054L;
	int id;
	String type;
	Date date;
	Float time; 
	Doctor doctor;  
	Patient patient;
	String speciality;
	


	public Appointment(int id, String type, Date date, Float time, String speciality,Doctor doctor, Patient patient) {
		super(); 
		this.id = id;
		this.type = type;
		this.date = date;
		this.time = time;
		this.doctor = doctor;
		this.patient = patient;
		this.speciality = speciality;
	}
	

	public Appointment(String type, String speciality,Date date, Float time) {
		super();
		this.type = type;
		this.date = date;
		this.time = time;
		this.speciality = speciality;
		this.id=0;
		this.doctor=null;
		this.patient=null;
	}


	public String getSpeciality() {
		return speciality;
	}


	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}


	public Appointment() {
		super();
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Float getTime() {
		return time;
	}

	public void setTime(Float time) {
		this.time = time;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Appointment [id=" + id + ", type=" + type + ", date=" + date + ", time=" + time + ", doctor=" + doctor
				+ ", patient=" + patient + ", speciality=" + speciality + "]";
	}
	

	
}
