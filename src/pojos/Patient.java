package pojos;

import java.sql.Date;
import java.util.List;


public class Patient {
	
	Integer id;
	String name; 
	String surname;
	Date dob;
	String medical_chart;
	String gender;
	List<Treatment>treatments;
	List<Doctor> doctors;
	List<Result> results;
	List<Appointment> schedule;
	List<Machine> machines;
	List<Examination> examinations;
	
	

	

	public Patient(Integer id, String name, String surname, Date dob, String medical_chart, String gender,
			List <Treatment>treatments, List<Doctor> doctors, List<Result> results, List<Appointment> schedule,
			List<Machine> machines, List<Examination> examinations) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.dob = dob;
		this.medical_chart = medical_chart;
		this.gender = gender;
		this.treatments = treatments;
		this.doctors = doctors;
		this.results = results;
		this.schedule = schedule;
		this.machines = machines;
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

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public List<Appointment> getSchedule() {
		return schedule;
	}

	public void setSchedule(List<Appointment> schedule) {
		this.schedule = schedule;
	}

	public List<Machine> getMachines() {
		return machines;
	}

	public void setMachines(List<Machine> machines) {
		this.machines = machines;
	}

	public List<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(List<Examination> examinations) {
		this.examinations = examinations;
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
				+ medical_chart + ", gender=" + gender + ", treatment=" + treatments + ", doctors=" + doctors
				+ ", results=" + results + ", schedule=" + schedule + ", machines=" + machines + ", examinations="
				+ examinations + "]";
	}






}
