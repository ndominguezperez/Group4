package pojos;

import java.sql.Date;
import java.util.List;



public class Admin_staff {
	
	int id;
	String name;
	Date star_date;
	float salary;
	
	List<Patient> patients;
	List<Appointment> schedule;
	
	
	public Admin_staff(int id, String name, Date star_date, float salary, List<Patient> patients,
			List<Appointment> schedule) {
		super();
		this.id = id;
		this.name = name;
		this.star_date = star_date;
		this.salary = salary;
		this.patients = patients;
		this.schedule = schedule;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStar_date() {
		return star_date;
	}
	public void setStar_date(Date star_date) {
		this.star_date = star_date;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public List<Patient> getPatients() {
		return patients;
	}
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	public List<Appointment> getSchedule() {
		return schedule;
	}
	public void setSchedule(List<Appointment> schedule) {
		this.schedule = schedule;
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
		Admin_staff other = (Admin_staff) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Admin_staff [id=" + id + ", name=" + name + ", star_date=" + star_date + ", salary=" + salary
				+ ", patients=" + patients + ", schedule=" + schedule + "]";
	}
	
}


