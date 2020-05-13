package pojos;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import pojos.users.User;
import xml.utils.SQLDateAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType()
public class Doctor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6886212082478015698L;
	
	@XmlAttribute
	int id; 
	@XmlAttribute
	String name;
	@XmlTransient
	float salary;
	@XmlTransient
	String speciality;
	@XmlTransient
	Date dob; 
	@XmlTransient
	Date start_date;
	@XmlTransient
	List <Treatment>treatments;
	@XmlTransient
	List <Patient> patients;
	@XmlTransient
	List<Examination> examinations;
	@XmlTransient
	List<Appointment> schedule;
	@XmlTransient
	User user;
	
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
		this.treatments = new ArrayList<Treatment>();
		this.schedule = new ArrayList<Appointment>();
		this.examinations = new ArrayList<Examination>();
		this.patients = new ArrayList<Patient>();
	}
	
	public Doctor(String name, float salary, String speciality, Date dob, Date start_date, User user) {
		super();
		this.name = name;
		this.salary = salary;
		this.speciality = speciality;
		this.dob = dob;
		this.start_date = start_date;
		this.user = user;
	}
	
	

	public Doctor(int id, String name, float salary, String speciality, Date dob, Date start_date, User user) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.speciality = speciality;
		this.dob = dob;
		this.start_date = start_date;
		this.user = user;
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
	public Doctor(int pId, String name2, String speciality2, float salary2, Date dob2, Date startDate) {
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
	

	public Doctor(int id, String name, float salary, String speciality, Date dob, Date start_date) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.speciality = speciality;
		this.dob = dob;
		this.start_date = start_date;
	}

	public Doctor() {
		super();
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
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
				+ dob + ", start_date=" + start_date + ", treatments=" + treatments + ", patients=" + patients
				+ ", examinations=" + examinations + ", schedule=" + schedule + ", user=" + user + "]";
	}


}
