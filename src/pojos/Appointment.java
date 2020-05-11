package pojos;

import java.io.Serializable;
import java.sql.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import xml.utils.SQLDateAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "appointment")
@XmlType(propOrder = { "date", "time", "speciality","doctorId", "patientId"})

public class Appointment implements Serializable{
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 2382859282871358054L;
	int id;
	@XmlAttribute
	String type;
	@XmlJavaTypeAdapter(SQLDateAdapter.class)
	Date date;
	@XmlElement
	Float time; 
	@XmlElement
	String speciality;
	@XmlElement(name = "doctorId")
	Doctor doctor; 
	@XmlElement(name = "patientId")
	Patient patient;
	
	


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
	public Appointment(int id, String type, String speciality, Date date, Float time) {
		super(); 
		this.id = id;
		this.type = type;
		this.date = date;
		this.time = time;
		this.speciality = speciality;
	}

	public Appointment(String type, String speciality,Date date, Float time) {
		super();
		this.type = type;
		this.date = date;
		this.time = time;
		this.speciality = speciality;
		this.doctor= new Doctor();
		this.patient=new Patient();
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


	public Appointment(String type, Date date, Float time, String speciality, Doctor doctor, Patient patient) {
		this.type=type;
		this.date=date;
		this.time=time;
		this.speciality=speciality;
		this.doctor=doctor;
		this.patient=patient;
	}


	public Appointment(int appointmentId, String type2, String apSpeciality, Date date2, Float time2,
			Doctor newDoctor2) {
		this.id = appointmentId;
		this.type=type2;
		this.date=date2;
		this.time=time2;
		this.speciality=apSpeciality;
		this.doctor=newDoctor2;
		//this.patient=patient;
	}
	public Appointment(int id2, String type2, String speciality2, Date date2, float time2, int doctorId,
			int patientId) {
		super();
		this.id = id2;
		this.type = type2;
		this.date = date2;
		this.time = time2;
		this.speciality = speciality2;
		this.doctor.id= doctorId;
		this.patient.id = patientId;
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
	
	public String toStringDoctorName(Doctor doctor) {
		return "Appointment [id=" + id + ", type=" + type + ", date=" + date + ", time=" + time + ", doctor=" + doctor
				+ ", patient=" + patient + ", speciality=" + speciality + "], Doctor = " + doctor.getName();
	}
	
}
