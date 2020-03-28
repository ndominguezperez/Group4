package pojos;

public class Treatment {
	
	int id;
	String disease;
	
	public Treatment(int id, String disease) {
		super();
		this.id = id;
		this.disease = disease;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disease == null) ? 0 : disease.hashCode());
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
		if (disease == null) {
			if (other.disease != null)
				return false;
		} else if (!disease.equals(other.disease))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Treatment [id=" + id + ", disease=" + disease + "]";
	}
	
}
