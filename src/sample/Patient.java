package sample;

public class Patient {
	Integer id;
	String name;
	Fecha dob;
	String medical_chart;
	Integer treatment_id;
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
	public Fecha getDob() {
		return dob;
	}
	public void setDob(Fecha dob) {
		this.dob = dob;
	}
	public String getMedical_chart() {
		return medical_chart;
	}
	public void setMedical_chart(String medical_chart) {
		this.medical_chart = medical_chart;
	}
	public Integer getTreatment_id() {
		return treatment_id;
	}
	public void setTreatment_id(Integer treatment_id) {
		this.treatment_id = treatment_id;
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
		return "Patient [id=" + id + ", name=" + name + ", dob=" + dob + ", medical_chart=" + medical_chart
				+ ", treatment_id=" + treatment_id + "]";
	}

	
}
