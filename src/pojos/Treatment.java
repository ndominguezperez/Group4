package pojos;

import java.sql.Date;

public class Treatment {
	
	int id;
	String disease;
	String drug;
	Date finish_date;
	int patient_id;
	int doctor_id;
	
	
	public Treatment(int id, String disease, String drug, Date finish_date, int patient_id, int doctor_id) {
		super();
		this.id = id;
		this.disease = disease;
		this.drug = drug;
		this.finish_date = finish_date;
		this.patient_id = patient_id;
		this.doctor_id = doctor_id;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getDrug() {
		return drug;
	}
	public void setDrug(String drug) {
		this.drug = drug;
	}
	public Date getFinish_date() {
		return finish_date;
	}
	public void setFinish_date(Date finish_date) {
		this.finish_date = finish_date;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
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
		Treatment other = (Treatment) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Treatment [id=" + id + ", disease=" + disease + ", drug=" + drug + ", finish_date=" + finish_date
				+ ", patient_id=" + patient_id + ", doctor_id=" + doctor_id + "]";
	}
	
	
	

}