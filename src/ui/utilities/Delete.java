package ui.utilities;

import java.sql.Date;
import java.util.List;

import pojos.Appointment;
import pojos.Doctor;
import pojos.Patient;
import pojos.Treatment;
import ui.Menu;

public class Delete {
	 
    public static void deleteTreatment(Patient patient, Doctor doctor) {
          List<Treatment> treatmentList = Menu.administrationManager.viewTreatment(patient.getId());
          int i, j = 0;
          for (i = 0; i < treatmentList.size(); i++) {
                 j++;
          }
          if (j > 0) {
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
                 System.out.println("Which appointment do you want to delete?: \n");
                 Appointment appointment = null;
                 appointment = Exceptions.checkAppointment();
                 if (appointment != null) {
                        boolean sure = Exceptions.reconfirmation();
                        if(sure) {
                        Menu.administrationManager.deleteAppointment(appointment);
                        }
                 }
          } else {
                 System.out.println("\n\nThere's no appointements");
          }
    }

    public static void deletePatient(Patient patient) {
          boolean sure = Exceptions.reconfirmation();
          if(sure) {
          Menu.patientManager.deletePatient(patient);
          }
    }

}

