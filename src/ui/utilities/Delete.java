package ui.utilities;

import java.util.List;

import pojos.Appointment;
import pojos.Doctor;
import pojos.Patient;
import pojos.Treatment;
import ui.Menu;

public class Delete {
	 
    public static void deleteTreatment(Patient patient, Doctor doctor) {
          List<Treatment> treatments=Utilities.viewTreatments(patient);
          if (treatments!=null) {
                 System.out.println("Which treatmet do you want to delete?: \n");
                 Treatment treatment = Exceptions.checkTreatment();
                 if (treatment != null) {
                        boolean sure = Exceptions.reconfirmation();
                        if(sure) {
                        Menu.administrationManager.deleteTreatment(treatment);
                        }
                  }
          }
    }

    public static void deleteAppointment(Patient patient) {
          List<Appointment> appointmentList = null;
          try {
                 appointmentList = Menu.administrationManager.viewPatientSchedule(patient.getId());
          } catch (NullPointerException e) {
                 appointmentList = null;
          }
          if (appointmentList != null) {
                 System.out.println("\nWhich appointment do you want to delete?:");
                 Appointment appointment = null;
                 for (Appointment a : appointmentList) {
                	 System.out.println(a);
				}
                 appointment = Exceptions.checkAppointment();
                 if (appointment != null) {
                        boolean sure = Exceptions.reconfirmation();
                        if(sure) {
                        Menu.administrationManager.deleteAppointment(appointment);
                        }
                 }
          } else {
                 System.out.println("\n\nThere's no appointments");
          }
    }

    public static boolean deletePatient(Patient patient) {
          boolean sure = Exceptions.reconfirmation();
          boolean deleted=false;
          if(sure) {
          Menu.patientManager.deletePatient(patient);
          deleted=true;
          }
          return deleted;
    }

}

