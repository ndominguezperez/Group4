package pojos;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import pojos.users.User;

@XmlAccessorType(XmlAccessType.FIELD)
public class Patient implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5376639357396620040L;  
	/**
	 * 
	 */
	@XmlAttribute
	Integer id;
	@XmlAttribute
	String name;  
	@XmlAttribute
	String surname;
	Date dob;
	String medical_chart;
	String gender;
	User user;
	List<Treatment>treatments;
	List<Doctor> doctors;
	List<Appointment> schedule;
	List<Examination> examinations;
	
	

	

	public Patient(int id, String name, String surname, Date dob, String medical_chart, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.dob = dob;
		this.medical_chart = medical_chart;
		this.gender = gender;
		this.treatments = new ArrayList<Treatment>();
		this.doctors = new ArrayList<Doctor>();
		this.schedule = new ArrayList<Appointment>();
		this.examinations = new ArrayList<Examination>();
		this.user=null;
			
	}
	
	
	
    public Patient(Integer id, String name, String surname, Date dob, String medical_chart, String gender, User user) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.dob = dob;
		this.medical_chart = medical_chart;
		this.gender = gender;
		this.user = user;
	}



	public Patient(int id, String name, String surname, Date dob, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.dob = dob;
		this.gender = gender;
	}

	public Patient(int id, String name, String surname, Date dob) {
    	super();
    	this.id= id;
    	this.name= name;
    	this.surname=surname;
    	this.dob = dob;
    }
     

	public Patient(Integer id, String name, String surname, Date dob, String medical_chart, String gender,
			List <Treatment>treatments, List<Doctor> doctors, List<Appointment> schedule
			, List<Examination> examinations) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.dob = dob;
		this.medical_chart = medical_chart;
		this.gender = gender;
		this.treatments = treatments;
		this.doctors = doctors;
		this.schedule = schedule;
		this.examinations = examinations;
	}
	

	public Patient() {
		super();
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMedical_chart() {
		return medical_chart;
	}

	public void setMedical_chart(String medical_chart) {
		this.medical_chart = medical_chart;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	

	public List<Treatment> getTreatments() {
		return treatments;
	}


	public void setTreatments(List<Treatment> treatments) {
		this.treatments = treatments;
	}


	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}


	public List<Appointment> getSchedule() {
		return schedule;
	}

	public void setSchedule(List<Appointment> schedule) {
		this.schedule = schedule;
	}


	public List<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(List<Examination> examinations) {
		this.examinations = examinations;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Patient other = (Patient) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", surname=" + surname + ", dob=" + dob + ", medical_chart="
				+ medical_chart + ", gender=" + gender + ", user=" + user + ", treatments=" + treatments + ", doctors="
				+ doctors + ", schedule=" + schedule + ", examinations=" + examinations + "]";
	}



}
