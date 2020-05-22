package ui.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import pojos.*;
import ui.Menu;
import xml.utils.CustomErrorHandler;

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
    
    public static List<Appointment> getDoctorScheduleList(int id) {
    	List<Appointment> schedule= null;
        try {
               schedule = Menu.administrationManager.viewDoctorSchedule(id);
               for (Appointment appointment : schedule) {
                      System.out.println(appointment);
               }
        } catch (NullPointerException e) {
               System.out.println("There are no appointments");
        }
        return schedule;
  }
    
    
    public static List<Appointment> getPatientScheduleList(int id) {
    	List<Appointment> schedule= null;
        try {
               schedule = Menu.administrationManager.viewPatientSchedule(id);
               for (Appointment appointment : schedule) {
                      System.out.println(appointment);
               }
        } catch (NullPointerException e) {
               System.out.println("There are no appointments");
        }
        return schedule;
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
    public static List<Examination> viewExaminations(Patient patient) {
    	List<Examination> examinationList = Menu.administrationManager.viewExamination(patient.getId());
    	if(examinationList==null) {
			System.out.println("You don't have examinations yet");
		}else{
		for(Examination examination: examinationList) {
			System.out.println(examination);
		}
		}
    	return examinationList;
    }
    public static List<Treatment> viewTreatments(Patient patient) {
    	List<Treatment> treatmentList = Menu.administrationManager.viewTreatment(patient.getId());
    	int j=0;
    	for(Treatment treatment: treatmentList) {
			j++;
		}
    	if(j<1) {
			System.out.println("You don't have treatments yet");
		}else{
		for(Treatment treatment: treatmentList) {
			System.out.println(treatment);
		}
		}
    	return treatmentList;
    }
	public static void setUpAppointmentByXML() throws Exception {
		// Create a JAXBContext
		JAXBContext context = JAXBContext.newInstance(Appointment.class);
		// Get the unmarshaller
		Unmarshaller unmarshal = context.createUnmarshaller();
		// Open the file
		File file = null;
		boolean incorrectAppointment = false;
		do {
			System.out.println("Type the filename for the XML document (expected in the xmls folder):");
			String fileName = Utilities.read();
			file = new File("./xmls/" + fileName);
			try {
				// Create a DocumentBuilderFactory
				DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
				// Set it up so it validates XML documents
				dBF.setValidating(true);
				// Create a DocumentBuilder and an ErrorHandler (to check validity)
				DocumentBuilder builder = dBF.newDocumentBuilder();
				CustomErrorHandler customErrorHandler = new xml.utils.CustomErrorHandler();
				builder.setErrorHandler(customErrorHandler);
				// Parse the XML file and print out the result
				Document doc = builder.parse(file);
				if (!customErrorHandler.isValid()) {
					incorrectAppointment = true;
				}
			} catch (ParserConfigurationException ex) {
				System.out.println(file + " error while parsing!");
				incorrectAppointment = true;
			} catch (SAXException ex) {
				System.out.println(file + " was not well-formed!");
				incorrectAppointment = true;
			} catch (IOException ex) {
				System.out.println(file + " was not accesible!");
				incorrectAppointment = true;
			}
			
		} while (incorrectAppointment);
		// Unmarshall the dog from a file
		Appointment appointment = (Appointment) unmarshal.unmarshal(file);
		// Print the dog
		System.out.println("Added to the database: " + appointment);
		Menu.administrationManager.addNewAppointment(appointment);
		
	}

	public static void generateXML(int appId) throws Exception {
		Appointment appointment = Menu.administrationManager.getAppointmentById(appId);
		// Create a JAXBContext
		JAXBContext context = JAXBContext.newInstance(Appointment.class);
		// Get the marshaller
		Marshaller marshal = context.createMarshaller();
		// Pretty formatting
		marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		// Marshall the app to a file
		File file = new File("./xmls/Output-Appointment.xml");
		marshal.marshal(appointment, file);
		// Marshall the app to the screen
		marshal.marshal(appointment, System.out);
	}

}
	