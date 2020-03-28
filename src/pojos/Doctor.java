package pojos;

import java.sql.Date;
import java.util.List;


public class Doctor {

	int id;
	String name;
	float salary;
	String speciality;
	Date dob;
	Date start_date;
	List<Appointment> schedule;

	public Doctor(int id, String name, float salary, String speciality, Date dob, Date start_date,
			List<Appointment> schedule) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.speciality = speciality;
		this.dob = dob;
		this.start_date = start_date;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dob == null) ? 0 : dob.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(salary);
		result = prime * result + ((schedule == null) ? 0 : schedule.hashCode());
		result = prime * result + ((speciality == null) ? 0 : speciality.hashCode());
		result = prime * result + ((start_date == null) ? 0 : start_date.hashCode());
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
		if (dob == null) {
			if (other.dob != null)
				return false;
		} else if (!dob.equals(other.dob))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(salary) != Float.floatToIntBits(other.salary))
			return false;
		if (schedule == null) {
			if (other.schedule != null)
				return false;
		} else if (!schedule.equals(other.schedule))
			return false;
		if (speciality == null) {
			if (other.speciality != null)
				return false;
		} else if (!speciality.equals(other.speciality))
			return false;
		if (start_date == null) {
			if (other.start_date != null)
				return false;
		} else if (!start_date.equals(other.start_date))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", salary=" + salary + ", speciality=" + speciality + ", dob="
				+ dob + ", start_date=" + start_date + ", schedule=" + schedule + "]";
	}
		
}
