package pojos;



public class Examination {
	
	int id;
	String observations;
	Float temperature;
	int breathing_rate;
	int heart_rate;
	Float blood_pressure;
	Float oxigen_saturations;
	int doctor_id;
	int patient_id;
	
	public Examination(int id, String observations, Float temperature, int breathing_rate, int heart_rate,
			Float blood_pressure, Float oxigen_saturations, int doctor_id, int patient_id) {
		super();
		this.id = id;
		this.observations = observations;
		this.temperature = temperature;
		this.breathing_rate = breathing_rate;
		this.heart_rate = heart_rate;
		this.blood_pressure = blood_pressure;
		this.oxigen_saturations = oxigen_saturations;
		this.doctor_id = doctor_id;
		this.patient_id = patient_id;
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
	public Float getTemperature() {
		return temperature;
	}
	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}
	public int getBreathing_rate() {
		return breathing_rate;
	}
	public void setBreathing_rate(int breathing_rate) {
		this.breathing_rate = breathing_rate;
	}
	public int getHeart_rate() {
		return heart_rate;
	}
	public void setHeart_rate(int heart_rate) {
		this.heart_rate = heart_rate;
	}
	public Float getBlood_pressure() {
		return blood_pressure;
	}
	public void setBlood_pressure(Float blood_pressure) {
		this.blood_pressure = blood_pressure;
	}
	public Float getOxigen_saturations() {
		return oxigen_saturations;
	}
	public void setOxigen_saturations(Float oxigen_saturations) {
		this.oxigen_saturations = oxigen_saturations;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
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
		Examination other = (Examination) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Examination [id=" + id + ", observations=" + observations + ", temperature=" + temperature
				+ ", breathing_rate=" + breathing_rate + ", heart_rate=" + heart_rate + ", blood_pressure="
				+ blood_pressure + ", oxigen_saturations=" + oxigen_saturations + ", doctor_id=" + doctor_id
				+ ", patient_id=" + patient_id + "]";
	}
	
	

}