package pojos;

import java.sql.Date;
import java.util.List;


public class Patient {

	Integer id;
	String name;
	String surname;
	Date dob;
	String medical_chart;
	String gender;
	int admin_staff_id;
	int treatment_id;
	int examination_id;
	
	List<Doctor> doctors;
	List<Nurse> nurses;
	List<Result> results;
	List<Appointment> schedule;
	List<Machine> machines;
	List<Admin_staff> Admin_staffs;
	
	public Patient(Integer id, String name, String surname, Date dob, String medical_chart, String gender,
			int admin_staff_id, int treatment_id, int examination_id, List<Doctor> doctors, List<Nurse> nurses,
			List<Result> results, List<Appointment> schedule, List<Machine> machines, List<Admin_staff> admin_staffs) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.dob = dob;
		this.medical_chart = medical_chart;
		this.gender = gender;
		this.admin_staff_id = admin_staff_id;
		this.treatment_id = treatment_id;
		this.examination_id = examination_id;
		this.doctors = doctors;
		this.nurses = nurses;
		this.results = results;
		this.schedule = schedule;
		this.machines = machines;
		Admin_staffs = admin_staffs;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getMedical_chart() {
		return medical_chart;
	}
	public void setMedical_chart(String medical_chart) {
		this.medical_chart = medical_chart;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAdmin_staff_id() {
		return admin_staff_id;
	}
	public void setAdmin_staff_id(int admin_staff_id) {
		this.admin_staff_id = admin_staff_id;
	}
	public int getTreatment_id() {
		return treatment_id;
	}
	public void setTreatment_id(int treatment_id) {
		this.treatment_id = treatment_id;
	}
	public int getExamination_id() {
		return examination_id;
	}
	public void setExamination_id(int examination_id) {
		this.examination_id = examination_id;
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
	public List<Result> getResults() {
		return results;
	}
	public void setResults(List<Result> results) {
		this.results = results;
	}
	public List<Appointment> getSchedule() {
		return schedule;
	}
	public void setSchedule(List<Appointment> schedule) {
		this.schedule = schedule;
	}
	public List<Machine> getMachines() {
		return machines;
	}
	public void setMachines(List<Machine> machines) {
		this.machines = machines;
	}
	public List<Admin_staff> getAdmin_staffs() {
		return Admin_staffs;
	}
	public void setAdmin_staffs(List<Admin_staff> admin_staffs) {
		Admin_staffs = admin_staffs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Patient other = (Patient) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", surname=" + surname + ", dob=" + dob + ", medical_chart="
				+ medical_chart + ", gender=" + gender + ", admin_staff_id=" + admin_staff_id + ", treatment_id="
				+ treatment_id + ", examination_id=" + examination_id + ", doctors=" + doctors + ", nurses=" + nurses
				+ ", results=" + results + ", schedule=" + schedule + ", machines=" + machines + ", Admin_staffs="
				+ Admin_staffs + "]";
	}
	

}
