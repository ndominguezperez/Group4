package pojos;

import java.io.Serializable;
import java.util.List;

public class Result implements Serializable{ 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 408496146159668583L;
	int id;
	String type;
	
	List<Doctor> doctors;
	List<Machine> machines;
	Patient patient;
	
	

	public Result(int id, String type, List<Doctor> doctors, List<Machine> machines, Patient patient) {
		super();
		this.id = id;
		this.type = type;
		this.doctors = doctors;
		this.machines = machines;
		this.patient = patient;
	}

	public Result() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	public List<Machine> getMachines() {
		return machines;
	}

	public void setMachines(List<Machine> machines) {
		this.machines = machines;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
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
		Result other = (Result) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Result [id=" + id + ", type=" + type + ", doctors=" + doctors +  ", machines="
				+ machines + ", patient=" + patient + "]";
	}
	
}
