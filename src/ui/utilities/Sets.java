package ui.utilities;

import java.sql.Date;

import java.util.List;

import pojos.Appointment;
import pojos.Doctor;
import pojos.Patient;
import pojos.Treatment;
import ui.Menu;

public class Sets {
	 
    public static void modifyTreatment(Patient patient, Doctor doctor) {
        List<Treatment> treatments=Utilities.viewTreatments(patient);
        if (treatments.size()>=1) {
                 boolean question;
                 Treatment treatment = Exceptions.checkTreatment();
                 if (treatment != null) {
                	 int option;
                	 int id = treatment.getId();
                	 String disease = treatment.getDisease();
                	 String drug = treatment.getDrug();
                	 Date finishDate = treatment.getFinishDate();
                	 do {	
                		System.out.println("What do you want to change");
                	 	System.out.println("1. Disease");
                	 	System.out.println("2. Drug");
                	 	System.out.println("3. Finish date");
                	 	System.out.println("4. I have already finished with modifications");
                	 	option = Integer.parseInt(Utilities.read());
                	 	
                	 	switch (option) {
                	 		case 1: 
                	 			id = treatment.getId();
		                        System.out.println("\tDo you want to change the disease: ");
		                        System.out.println("The disease is " + treatment.getDisease());
		                  
		                        question = Exceptions.checkConfirmation();
		                        if (question) {
		                               System.out.print("Introduce the new disease: ");
		                               disease = Utilities.read();
		                        } else {
		                               disease = treatment.getDisease();
		                        }
		                        break;
                	 		case 2:
		                        System.out.print("\tDo you want to change the drug: ");
		                        
		                        System.out.println("The drug is " + treatment.getDrug());
		                        question = Exceptions.checkConfirmation();
		                        if (question) {
		                               System.out.print("Introduce the new drug: ");
		                               drug = Utilities.read();
		                        } else {
		                               drug = treatment.getDrug();
		                        }
		                        break;
                	 		case 3:
		                        System.out.print("Do you want to change the finish date: ");
		                       
		                        System.out.println("The date is " + treatment.getFinishDate());
		                        question = Exceptions.checkConfirmation();
		                        if (question) {
		                               System.out.print("Introduce the new finish date(yyyy-MM-dd):  ");
		                               finishDate = Exceptions.checkDate();
		                        } else {
		                               finishDate = treatment.getFinishDate();
		                        }
		                        break;
                	 		
                        
                	 	}
                	 	
                	 Treatment treatment1 = new Treatment(id, disease, drug, finishDate, patient, doctor);
                     System.out.print(treatment1);
                     Menu.administrationManager.modifyTreatment(treatment1);
                	 }while (option !=4);
                 }
          } else {
                 System.out.println("Do you want to introduce a new one??");
                 boolean question = Exceptions.checkConfirmation();
                 if (question) {
                        Adds.addTreatment(patient, doctor);

                 }
          }
    }

    public static void modifyAppointment(Patient patient) {
          
    		
          List<Appointment> appointments=Utilities.getPatientScheduleList(patient.getId());
          Appointment appointment;
          if (appointments.size()>=1) {
        	  	   
                   boolean question;
                 do {
                        appointment = Exceptions.checkAppointment();
                        if(appointment!=null) {
                        System.out.println("The appointment is:" + appointment);
                        }
                 } while (appointment == null);
                 int id = appointment.getId();
                 String type = appointment.getType();
                 Float time = appointment.getTime();
                 Date day = appointment.getDate();
                 Doctor doctor = appointment.getDoctor();
                 Appointment appointment1 = appointment;
                 int option = 0;
                 do {	
             		System.out.println("\nWhat do you want to change");
             	 	System.out.println("1. Type");
             	 	System.out.println("2. Date");
             	 	System.out.println("3. Time");
             	 	System.out.println("4. Doctor");
             	 	System.out.println("5. I have already finished with modifications");
             	 	option = Integer.parseInt(Utilities.read());
             	 	
             	 	switch (option) {
             	 	case 1:
		                 System.out.println("Do you want to change the type: ");
		                 
		                 
		                 System.out.println("The type is " + appointment.getType());
		                 question = Exceptions.checkConfirmation();
		                 if (question) {
		                        System.out.print("Introduce the new type: ");
		                        type = Utilities.read();
		                  } else {
		                        type = appointment.getType();
		                 }
		                 break;
             	 	case 2:
		                 System.out.println("Do you want to change the day: ");
		                 
		                 System.out.println("The day is " + appointment.getDate());
		                 question = Exceptions.checkConfirmation();
		                 if (question) {
		                        System.out.print("Introduce the new  date(yyyy-MM-dd):: ");
		                        day = Exceptions.checkDate();
		                 } else {
		                        day = appointment.getDate();
		                 }
		                 break;
             	 	case 3:
		                 System.out.println("Do you want to change the time: ");
		                 
		                 System.out.println("The time is " + appointment.getTime());
		                 question = Exceptions.checkConfirmation();
		                 if (question) {
		                        System.out.print("Introduce the new time: ");
		                        time = Exceptions.checkFloat();
		                 } else {
		                        time = appointment.getTime();
		                 }
		                 break;
             	 	case 4:
		                 System.out.println("Do you want to change the doctor: ");
		                 System.out.println("The docor is:" + appointment.getDoctor());
		                 question = Exceptions.checkConfirmation();
		                 
		                 if (question) {
		                        System.out.print("Introduce the new doctor id: ");
		                        Utilities.listAllDoctors();
		                        System.out.print("Id: ");
		                        do {
		                               doctor = Exceptions.checkDoctor();
		                        } while (doctor == null);
		                 } else {
		                        doctor = appointment.getDoctor();
		                 }
		                 break;
             	 	}
             	 	 String speciality = doctor.getSpeciality();
                      appointment1 = new Appointment(id, type, day, time, speciality, doctor, patient);
                     System.out.println(appointment1);
                     
                 }while (option != 5);
                 	Menu.administrationManager.modifyAppointment(appointment1);
          }
    }

}


