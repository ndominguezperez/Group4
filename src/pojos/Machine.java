package pojos;

import java.io.Serializable;
import java.util.List;

public class Machine implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7827998889210822174L;
	int id;
	String type;
	 
	List<Result> results;
	Patient patient;
	
	
	
	public Machine(int id, String type, List<Result> results, Patient patient) {
		super();
		this.id = id;
		this.type = type;
		this.results = results;
		this.patient = patient;
	}

	public Machine() {
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

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
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
		Machine other = (Machine) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Machine [id=" + id + ", type=" + type + ", results=" + results + ", patient=" + patient + "]";
	}
	
	
	
	
	
}