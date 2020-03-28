package pojos;

public class Examination {
	
	int id;
	String observations;
	
	public Examination(int id, String observations) {
		super();
		this.id = id;
		this.observations = observations;
	}
	
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
		result = prime * result + ((observations == null) ? 0 : observations.hashCode());
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
		if (observations == null) {
			if (other.observations != null)
				return false;
		} else if (!observations.equals(other.observations))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Examination [id=" + id + ", observations=" + observations + "]";
	}
	
	
}
