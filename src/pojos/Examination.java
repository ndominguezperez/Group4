package pojos;

public class Examination {
	
	int id;
	String observations;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
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
		Examination other = (Examination) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
