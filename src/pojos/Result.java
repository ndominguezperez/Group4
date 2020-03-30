package pojos;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Result implements Serializable{ 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 408496146159668583L;
	int id;
	String type;
	Date date;
	List<Doctor> doctors;

	Patient patient;
	
	

	public Result(int id, String type, List<Doctor> doctors, Patient patient,Date date) {
		super();
		this.id = id;
		this.type = type;
		this.doctors = doctors;
		this.date=date;
		this.patient = patient;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Result() {
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

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
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
		Result other = (Result) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Result [id=" + id + ", type=" + type + ", doctors=" + doctors +   ", patient=" + patient + " , date=" + date+" ]";
	}
	
}
