package pojos;

import java.io.Serializable;

public class Examination implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -500401169261401858L;
	int id; 
	String observations;
	Float temperature;
	int breathing_rate;
	int heart_rate;
	Float blood_pressure;
	Float oxygen_saturations;
	Doctor doctor;
	Patient patient;
	
	

	public Examination(int id, String observations, Float temperature, int breathing_rate, int heart_rate,
			Float blood_pressure, Float oxygen_saturations, Doctor doctor, Patient patient) {
		super();
		this.id = id;
		this.observations = observations;
		this.temperature = temperature;
		this.breathing_rate = breathing_rate;
		this.heart_rate = heart_rate;
		this.blood_pressure = blood_pressure;
		this.oxygen_saturations = oxygen_saturations;
		this.doctor = doctor;
		this.patient = patient;
	}

	public Examination() {
		super();
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

	public Float getOxygen_saturations() {
		return oxygen_saturations;
	}

	public void setOxygen_saturations(Float oxygen_saturations) {
		this.oxygen_saturations = oxygen_saturations;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
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
		Examination other = (Examination) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Examination [id=" + id + ", observations=" + observations + ", temperature=" + temperature
				+ ", breathing_rate=" + breathing_rate + ", heart_rate=" + heart_rate + ", blood_pressure="
				+ blood_pressure + ", oxygen_saturations=" + oxygen_saturations + ", doctor=" + doctor + ", patient="
				+ patient + "]";
	}

	
	
	

}