package db.interfaces;

	public interface DBManager {

		public void connect();
		public void disconnect(); 
		public void createTables();
		
		public DoctorManager getDoctorManager();
		
		public PatientManager getPatientManager();
	
		public int getLastId();
		
	}