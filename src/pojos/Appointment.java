package pojos;

import java.sql.Date;
import java.util.List;

public class Appointment {
	
	int id;
	String type;
	Date date;
	Float time;
	
	int doctor_id;
	int patient_id;
	int nurse_id;
	List <Admin_staff> admin_staffs;

	public Appointment(int id, String type, Date date, Float time, int doctor_id, int patient_id, int nurse_id,
			List<Admin_staff> admin_staffs) {
		super();
		this.id = id;
		this.type = type;
		this.date = date;
		this.time = time;
		this.doctor_id = doctor_id;
		this.patient_id = patient_id;
		this.nurse_id = nurse_id;
		this.admin_staffs = admin_staffs;
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
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public int getNurse_id() {
		return nurse_id;
	}
	public void setNurse_id(int nurse_id) {
		this.nurse_id = nurse_id;
	}
	public List<Admin_staff> getAdmin_staffs() {
		return admin_staffs;
	}
	public void setAdmin_staffs(List<Admin_staff> admin_staffs) {
		this.admin_staffs = admin_staffs;
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
	

	
}
