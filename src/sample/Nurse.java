package sample;

public class Nurse {
	int id;
	String name;
	float salary;
	String speciality;
	Fecha dob;
	Fecha start_date;
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
				+ dob + ", start_date=" + start_date + "]";
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
	public Fecha getDob() {
		return dob;
	}
	public void setDob(Fecha dob) {
		this.dob = dob;
	}
	public Fecha getStart_date() {
		return start_date;
	}
	public void setStart_date(Fecha start_date) {
		this.start_date = start_date;
	}
	
}
