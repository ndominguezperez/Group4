package pojos;

import java.sql.Date;
import java.util.List;


public class Patient {

	Integer id;
	String name;
	String surname;
	Date dob;
	String medical_chart;
	Sexo Hombre,Mujer;
	List<Appointment> schedule;
	List<Result> results;

	public Patient(Integer id, String name, String surname, Date dob, String medical_chart, List<Appointment> schedule,
			List<Result> results) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.dob = dob;
		this.medical_chart = medical_chart;
		this.schedule = schedule;
		this.results = results;
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public List<Appointment> getSchedule() {
		return schedule;
	}
	public void setSchedule(List<Appointment> schedule) {
		this.schedule = schedule;
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
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((medical_chart == null) ? 0 : medical_chart.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((results == null) ? 0 : results.hashCode());
		result = prime * result + ((schedule == null) ? 0 : schedule.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (medical_chart == null) {
			if (other.medical_chart != null)
				return false;
		} else if (!medical_chart.equals(other.medical_chart))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (results == null) {
			if (other.results != null)
				return false;
		} else if (!results.equals(other.results))
			return false;
		if (schedule == null) {
			if (other.schedule != null)
				return false;
		} else if (!schedule.equals(other.schedule))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", surname=" + surname + ", dob=" + dob + ", medical_chart="
				+ medical_chart + ", schedule=" + schedule + ", results=" + results + "]";
	}
	

}
