package db.interfaces;

	public interface DBManager {

		public void connect();
		public void disconnect();
		public void createTables();
		
		public DoctorManager getDoctorManager();
		public NurseManager getNurseManager();
		public PatientManager getPatientManager();
		public Admin_staffManager getAdmin_staffManager();
	
		
		public int getLastId();
		
	}