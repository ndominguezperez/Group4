package ui.utilities;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import pojos.Appointment;
import pojos.Doctor;
import pojos.Patient;
import pojos.users.User;
import ui.Menu;
import xml.utils.CustomErrorHandler;

public class Action {
	public static void doctorSubMenu(Doctor doctor) throws Exception {
		int option;
		do {
			System.out.println("Select what you want to do");
			System.out.println("\n\t1.See Your schedule");
			System.out.println("\n\t2.List all your patients");
			System.out.println("\n\t3.Patient");
			System.out.println("\n\t4.Settings");
			System.out.println("\n\t0.Back");
			option = Exceptions.checkInt();
			switch (option) {
			case 1: // View schedule
				Utilities.getDoctorSchedule(doctor.getId());
				break;
			case 2:
				Utilities.listAllPatientsOfDoctor(doctor);
				break;
			case 3: // Patient
				Patient patient = searchPatientMenu();
				if(patient!=null) {
					doctorPatientMenu(patient, doctor);
				}
				break;
			case 4: 
				String username=doctor.getUser().getUsername();
				User user=Menu.userManager.getUser(username);
				settingsMenu(user);
				break;
			case 0:
			     return;

			}

		} while (option != 0);

	}

	private static void doctorPatientMenu(Patient patient, Doctor doctor) throws Exception {
		int option;
		do {
		System.out.println("Select what you want to do");
		System.out.println("\n\t1.Create Examinations");
		System.out.println("\n\t2.View Examinations");
		System.out.println("\n\t3.Create Treatment");
		System.out.println("\n\t4.Modify Treatment");
		System.out.println("\n\t5.Delete Treatment");
		System.out.println("\n\t6.View Treatment");
		System.out.println("\n\t0.Back");
			option = Exceptions.checkInt();
			switch (option) {
			case 1:
				Adds.addExamination(patient, doctor);
				break;
			case 2:
				Utilities.viewExaminations(patient);
				break;
			case 3:
				Adds.addTreatment(patient, doctor);
				break;
			case 4:
				Sets.modifyTreatment(patient, doctor);
				break;
			case 5:
				Delete.deleteTreatment(patient, doctor);
				break;
			case 6:
				Utilities.viewTreatments(patient);
				break;
			case 0:
				return;
			}
		} while (option != 0);

	}

	public static void patientSubMenu(Patient patient) throws Exception {
		int option;
		do {
			System.out.println("Select what you want to do");
			System.out.println("\n\t1.Schedule");
			System.out.println("\n\t2.See examinations");
			System.out.println("\n\t3.Settings");
			System.out.println("\n\t0.Back");
			option = Exceptions.checkInt();
			switch (option) {
			case 1:
				Utilities.getPatientSchedule(patient.getId());
				break;
			case 2:
				Utilities.viewExaminations(patient);
				break;
			case 3:
				String username=patient.getUser().getUsername();
				User user=Menu.userManager.getUser(username);
				settingsMenu(user);
				break;
			case 0:
				return;
			}
		} while (option != 0);
	}

	private static Patient searchPatientMenu() {
		System.out.println("\n\t1.To search by id number");
		System.out.println("\n\t2.To search by name");
		System.out.println("\n\t3.To search by surname");
		int option = Exceptions.checkInt();
		Patient p = null;
		boolean yes=false;
		switch (option) {
		case 1:
			p = Exceptions.checkPatient();
			if(p==null) {
				System.out.println("This patient doesn't exist");
			}
			break;
		case 2:
			yes = Utilities.searchPatientByName();
			if(yes) {
				p = Exceptions.checkPatient();
			}
			break;
		case 3:
			yes = Utilities.searchPatientBySurname();
			if(yes) {
				p = Exceptions.checkPatient();
			}
			break;
		case 0:
			return  p ;
		}
		return p;
	}

	public static void adminMenu(User user) throws Exception {
		int option;
		do{
			System.out.println("\nSelect what you want to do");
			System.out.println("\n\t1.List all patients");
			System.out.println("\n\t2.View a patient");
			System.out.println("\n\t3.Delete a patient");
			System.out.println("\n\t4.Appointments");
			System.out.println("\n\t5.Set up appointment with XML");
			System.out.println("\n\t6.Generate XML");
			System.out.println("\n\t7.Settings");
			System.out.println("\n\t0.Back");
			option= Exceptions.checkInt();
			switch (option) {
			case 1:
				Utilities.listAllPatiens();
				break;
			case 2:
				Patient p1=searchPatientMenu();
				if(p1!=null) {
				System.out.println(p1);
				}
				break;
			case 3:
				Patient p2=searchPatientMenu();
				if(p2!=null) {
					Delete.deletePatient(p2);
				}else {
					System.out.println("This patient doesn't exist");
				}
				break;
			case 4:
				appointmentMenu(user);
				break;
			case 5:
				setUpAppointmentByXML();
				break;
			case 6:
				boolean doc= ui.utilities.Exceptions.chooseDocOPat();
				int id;
				if (doc) {
					ui.utilities.Utilities.listAllDoctors();
					Doctor doctor =ui.utilities.Exceptions.checkDoctor();
					ui.utilities.Utilities.getDoctorSchedule(doctor.getId());
					id=ui.utilities.Utilities.askForId();
				}else {
					Patient patient=searchPatientMenu();
					ui.utilities.Utilities.getDoctorSchedule(patient.getId());
					id=ui.utilities.Utilities.askForId();
				}
				generateXML(id);
				break;
			case 7:
				settingsMenu(user);
				break;
			case 0:
				return;

			}
		}while (option!=0);
		
	}

	private static void appointmentMenu(User user) throws Exception {
		int option ;
		do {
		System.out.println("Select what you want to do");
		System.out.println("\n\t1.Set Up a new one");
		System.out.println("\n\t2.Modify appointment");
		System.out.println("\n\t3.Search appointment by date");
		System.out.println("\n\t4.Delete appointment ");
		System.out.println("\n\t0.Back");
		 option = Exceptions.checkInt();
		Patient p ;
		switch (option) {
		case 1:
			System.out.println("Patient: ");
			p = searchPatientMenu();
			if(p!=null) {
				Adds.addAppointment(p);
			}else {
				System.out.println("This patient doesn't exist");
			}
			break;
		case 2:
			System.out.println("From what patient do you want to modify the appointment: ");
			p = searchPatientMenu();
			if(p!=null) {
				Sets.modifyAppointment(p);
			}else {
				System.out.println("This patient doesn't exist");
			}
			break;
		case 3:
			Utilities.searchAppointmentByDate();
			break;
		case 4:
			System.out.println("From what patient do you want to delete the appointment: ");
			p = searchPatientMenu();
			if(p!=null) {
				Delete.deleteAppointment(p);
			}else {
				System.out.println("This patient doesn't exist");
			}
			break;
		case 0:
			return;

		}
		}while(option!=0);
	}
	
	private static void settingsMenu(User user) {
		int option ;
		do {
		System.out.println("\n\t1.Delete user");
		System.out.println("\n\t2.Modify password");
		System.out.println("\n\t0.Back");
	   option = Exceptions.checkInt();
		switch (option) {
		case 1:
				String username=null;
				int n =user.getRole().getId();
				boolean sure=false;
				switch(n) {
					case 1:
						System.out.println("A doctor can not be deleted");
						break;
					case 2: 
						username=user.getUsername();
						Patient patient = Menu.patientManager.getPatientByUsername(username);
						sure=Delete.deletePatient(patient);
						if(sure) {
						Menu.userManager.deleteUser(user);
						System.out.println("\nDeleted succed");
						try {
							Menu.Menu();
						} catch (Exception e) {
							System.out.println("Something went wrong");
							e.printStackTrace();
						}
						break;
						}else {
							break;
						}
					case 3:
						sure=Exceptions.reconfirmation();
						if(sure) {
						Menu.userManager.deleteUser(user);
						System.out.println("\nDeleted succed");
						try {
							Menu.Menu();
						} catch (Exception e) {
							System.out.println("Something went wrong");
							e.printStackTrace();
						}
						break;
						}else {
					    	break;
						}
				}
				break;
		case 2:
			Menu.userManager.modifyPassword(user);
			break;
		case 0:
			return;

		}
		}while(option!=0);
	}
	
	private static void setUpAppointmentByXML() throws Exception {
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

	private static void generateXML(int appId) throws Exception {
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
