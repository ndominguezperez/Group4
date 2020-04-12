package pojos;

import java.io.Serializable;
import java.sql.Date;

public class Treatment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4194636208392461949L;
	/**
	 * 
	 */
	
	int id;
	String disease; 
	String drug;
	Date finishDate;
	Patient patient;
	Doctor doctor;
	
	


	public Treatment(int id, String disease, String drug, Date finishDate, Patient patient, Doctor doctor) {
		super();
		this.id = id;
		this.disease = disease;
		this.drug = drug;
		this.finishDate = finishDate;
		this.patient = patient;
		this.doctor = doctor;
	}
	
	public Treatment(String disease, String drug, Date finishDate, Patient patient, Doctor doctor) {
		super();
		this.disease = disease;
		this.drug = drug;
		this.finishDate = finishDate;
		this.patient = patient;
		this.doctor = doctor;
	}


	public Treatment() {
		super();
	}


	public Treatment(String disease2, String drug2, Date finishDate) {
		super();
		this.id = 0;
		this.disease = disease2;
		this.drug = drug2;
		this.finishDate = finishDate;
		this.patient = null;
		this.doctor = null;
		
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


	public Date getFinishDate() {
		return finishDate;
	}


	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}


	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}


	public Doctor getDoctor() {
		return doctor;
	}


	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
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
		return "Treatment [id=" + id + ", disease=" + disease + ", drug=" + drug + ", finishDate=" + finishDate
				+ ", patient=" + patient + ", doctor=" + doctor + "]";
	}


	
	
	
	

}