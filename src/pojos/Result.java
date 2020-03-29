package pojos;

import java.util.List;

public class Result {
	
	int id;
	String type;
	
	List<Doctor> doctors;
	List<Nurse> nurses;
	List<Machine> machines;
	
	int patient_id;
	
	
	public Result(int id, String type, List<Doctor> doctors, List<Nurse> nurses, List<Machine> machines,
			int patient_id) {
		super();
		this.id = id;
		this.type = type;
		this.doctors = doctors;
		this.nurses = nurses;
		this.machines = machines;
		this.patient_id = patient_id;
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
	public List<Nurse> getNurses() {
		return nurses;
	}
	public void setNurses(List<Nurse> nurses) {
		this.nurses = nurses;
	}
	public List<Machine> getMachines() {
		return machines;
	}
	public void setMachines(List<Machine> machines) {
		this.machines = machines;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
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
		return "Result [id=" + id + ", type=" + type + ", doctors=" + doctors + ", nurses=" + nurses + ", machines="
				+ machines + ", patient_id=" + patient_id + "]";
	}
	
}
