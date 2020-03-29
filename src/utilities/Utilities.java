package utilities;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utilities {
    public static String read() {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String read = "ERROR";
        try {
            read = console.readLine();
        } catch (IOException ex) {
            System.out.println("DETETCTED A ERROR");
        }
        return read;
    }
    public static int askId() {
        String leido = null;
        System.out.println(" Which is the patient id?");
        leido = read();
        int code= Integer.parseInt(leido);
        return code;
    }
    /* hay qu añadir en PatientMager todoo
     private static void getPatientByName() throws Exception {
	System.out.println("Type!");
	System.out.print("Name: ");
	String name = read();
	List<Patient> patients = PatientManager.searchByName(name);
	for (Patient patient : patients) {
		System.out.println(patient);
	}
}
private static Patient getPatientById() throws Exception {
	int id=askId();
	Patient a=null;
	List<Patient> patients = PatientManager.searchById(id);
	for (Patient patient : patients) {
		System.out.println(patient);
		a=patient;
	}
	return a;
	}
	private static void getPatientBySurname() throws Exception {
	System.out.println("Type!");
	System.out.print("Surname: ");
	String surname = read();
	List<Patient> patients = PatientManager.searchByName(surname);
	for (Patient patient : patients) {
		System.out.println(patient);
	}
}
  private static void listAllPatients() throws Exception {
    List <Patient> patients = PatientManager.getAll();
    Patient a= null;
	for (i=0;i<patients.length();i++) {
	    a= patients(i);
		System.out.println(patient);
	}
}
private static void seeSchedule(Patient p) throws Exception {
	int i;
	Patient b=null;
	Appointment a= null;
   List <Patient> patients = PatientManager.getAll();
	for (t=0;t<patients.length();t++) {
      b=patients.get(i);
      if(p.equals(patients)){
		System.out.println(patient);
	for (i=0;i<b.getSchedule.length();i++) {
	    a= b.getSchedule.get(i);
		System.out.println(a);
}
}
}
*/

	}
