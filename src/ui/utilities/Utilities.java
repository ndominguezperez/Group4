package ui.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import db.interfaces.*;
import db.sqlite.SQLiteDoctorManager;
import pojos.*;
import ui.Menu;

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

    public static int askForId() {
          int id;
          System.out.println("Which is the id?");
          id = Exceptions.checkInt();
          return id;
    }

    public static void listAllPatiens() {
          List<Patient> patientsList = Menu.patientManager.listAllPatients();
          if (patientsList != null) {
                 for (Patient patient : patientsList) {
                        System.out.println(patient);
                 }
          } else {
                 System.out.print("There are no patients already\n");
          }
    }

    public static void listAllDoctors() {
          List<Doctor> doctorsList = Menu.doctorManager.listAllDoctors();
          if (doctorsList != null) {
                 for (Doctor doctor : doctorsList) {
                        System.out.println(doctor);
                 }
          } else {
                 System.out.print("There are no patients already\n");
          }
    }

    public static Doctor getDoctortByIdPassingInt(int doctorId) {
          Doctor doctor;
          doctor = Menu.doctorManager.getDoctorById(doctorId);
          return doctor;
    }

    public static boolean searchPatientByName() {
    	String name = null;
    	System.out.println("Type the name: ");
    	name = read();
    	List<Patient> patients = Menu.patientManager.searchByName(name);
    	boolean yes = false;
        if(patients.size()>0) {
        for (Patient patient : patients) {
                 System.out.println(patient);
          }
        yes=true;
        }else {
        	System.out.println("You don't have any patients called "+name);
        	yes=false;
        }
        return yes;
    }

    public static boolean searchPatientBySurname() {
    	String surname = null;
    	System.out.println("Type the surname: ");
    	surname = read();
    	List<Patient> patients = Menu.patientManager.searchBySurname(surname);
    	boolean yes = false;
        if(patients.size()>0) {
        for (Patient patient : patients) {
                 System.out.println(patient);
          }
        yes=true;
        }else {
        	System.out.println("You don't have any patients which surname is "+surname);
        	yes=false;
        }
        return yes;
    }

    public static void getPatientSchedule(int a) {
          try {
                 List<Appointment> schedule = Menu.administrationManager.viewPatientSchedule(a);
                 for (Appointment appointment : schedule) {
                        System.out.println(appointment);
                 }
          } catch (NullPointerException e) {
        	  System.out.println("There are no appointments");
          }
    }

    public static void getDoctorSchedule(int id) {
          try {
                 List<Appointment> schedule = Menu.administrationManager.viewDoctorSchedule(id);
                 for (Appointment appointment : schedule) {
                        System.out.println(appointment);
                 }
          } catch (NullPointerException e) {
                 System.out.println("There are no appointments");
          }
    }

    public static void listAllPatientsOfDoctor(Doctor doctor) {
    	List<Patient> patientsList = Menu.doctorManager.listAllPatientsOfDoctor(doctor.getId());
          for (Patient patient : patientsList) {
                 System.out.println(patient);
          }if(patientsList.size()<1) {
        	  System.out.println("You don't have any patients yet");
          }
    }

    public static void searchAppointmentByDate() {
          Date date = null;
          System.out.println("What is the date of the appointment you are looking for?");
          date = Exceptions.checkDate();
          List<Appointment> appointmentsList = Menu.administrationManager.searchAppointmentByDate(date);
          for (Appointment appointment : appointmentsList) {
                 System.out.println(appointment);
          }
    }

}
	