package pojos;

import java.sql.Date;
import java.util.List;



public class Nurse {

	int id;
	String name;
	float salary;
	String speciality;
	Date dob;
	Date start_date;
	
	List <Patient> patients;
	List <Result> results;
	List <Appointment> schedule;
	
	
	public Nurse(int id, String name, float salary, String speciality, Date dob, Date start_date,
			List<Patient> patients, List<Result> results, List<Appointment> schedule) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.speciality = speciality;
		this.dob = dob;
		this.start_date = start_date;
		this.patients = patients;
		this.results = results;
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
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public List<Appointment> getSchedule() {
		return schedule;
	}
	public void setSchedule(List<Appointment> schedule) {
		this.schedule = schedule;
	}
	public List<Patient> getPatients() {
		return patients;
	}
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	public List<Result> getResults() {
		return results;
	}
	public void setResults(List<Result> results) {
		this.results = results;
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
		Nurse other = (Nurse) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Nurse [id=" + id + ", name=" + name + ", salary=" + salary + ", speciality=" + speciality + ", dob="
				+ dob + ", start_date=" + start_date + ", patients=" + patients + ", results=" + results + ", schedule="
				+ schedule + "]";
	}

	
	
}
