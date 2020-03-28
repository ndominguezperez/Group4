package pojos;

import java.sql.Date;



public class Admin_staff {
	
	int id;
	String name;
	Date star_date;
	float salary;
	
	public Admin_staff(int id, String name, Date star_date, float salary) {
		super();
		this.id = id;
		this.name = name;
		this.star_date = star_date;
		this.salary = salary;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(salary);
		result = prime * result + ((star_date == null) ? 0 : star_date.hashCode());
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(salary) != Float.floatToIntBits(other.salary))
			return false;
		if (star_date == null) {
			if (other.star_date != null)
				return false;
		} else if (!star_date.equals(other.star_date))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Admin_staff [id=" + id + ", name=" + name + ", star_date=" + star_date + ", salary=" + salary + "]";
	}

	
}


