package pojos;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class Doctor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6886212082478015698L;
	int id; 
	String name;
	float salary;
	String speciality;
	Date dob; 
	Date start_date;
	List <Treatment>treatments;
	List <Patient> patients;
	List<Examination> examinations;
	List<Appointment> schedule;
	

	

	public Doctor(int id, String name, float salary, String speciality, Date dob, Date start_date,
			List<Patient> patients, List<Examination> examinations, List<Appointment> schedule,
			List <Treatment>treatments) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.speciality = speciality;
		this.dob = dob;
		this.start_date = start_date;
		this.patients = patients;
		this.examinations = examinations;
		this.schedule = schedule;
		this.treatments = treatments;
	}
	
	public Doctor(String name, float salary , String speciality, Date dob, Date startDate) {
		super();
		this.name = name;
		this.salary = salary;
		this.speciality = speciality;
		this.dob = dob;
		this.start_date = startDate;
	}
	
	public Doctor(int id, String name) {
		super();
		this.id=id;
	    this.name=name;
	}
	public Doctor(int id, String name, String speciality) {
		super();
		this.id=id;
	    this.name=name;
	    this.speciality=speciality;
	}
	public Doctor() {
		super();
	}

	public Doctor(int id, String name, float salary, Date dob, String speciality, Date startDate) {
		super();
		this.id=id;
		this.name=name;
		this.salary=salary;
		this.dob=dob;
		this.speciality=speciality;
		this.start_date=startDate;
		this.treatments = new ArrayList<Treatment>();
		this.schedule = new ArrayList<Appointment>();
		this.examinations = new ArrayList<Examination>();
		this.patients = new ArrayList<Patient>();

	}

	public List<Treatment> getTreatments() {
		return treatments;
	}

	public void setTreatments(List<Treatment> treatments) {
		this.treatments = treatments;
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

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public List<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(List<Examination> examinations) {
		this.examinations = examinations;
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
		Doctor other = (Doctor) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", salary=" + salary + ", speciality=" + speciality + ", dob="
				+ dob + ", start_date=" + start_date + ", patients=" + patients + ", examinations=" + examinations 
				+ ", schedule=" + schedule + ", treatments" + treatments + "]";
	}
		
}
