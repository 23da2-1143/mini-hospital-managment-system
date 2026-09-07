import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PatientBST patientBST = new PatientBST();
    private static final EmergencyQueue emergencyQueue = new EmergencyQueue();
    private static final TreatmentStack treatmentStack = new TreatmentStack();
    private static int nextTreatmentId = 1;

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM");
        System.out.println("========================================");

        sampleData();

        int choice;
        do {
            displayMenu();
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    registerPatient();
                    break;
                case 2:
                    searchPatient();
                    break;
                case 3:
                    deletePatient();
                    break;
                case 4:
                    displayAllPatients();
                    break;
                case 5:
                    addPatientToEmergencyQueue();
                    break;
                case 6:
                    viewEmergencyQueue();
                    break;
                case 7:
                    callNextPatient();
                    break;
                case 8:
                    completeTreatment();
                    break;
                case 9:
                    viewTreatmentHistory();
                    break;
                case 10:
                    addPatientVisit();
                    break;
                case 11:
                    removePatientVisit();
                    break;
                case 12:
                    searchPatientVisit();
                    break;
                case 13:
                    displayPatientVisitHistory();
                    break;
                case 14:
                    System.out.println("Exiting the hospital management system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid menu choice. Please choose a number from 1 to 14.");
                    break;
            }

            System.out.println();
        } while (choice != 14);
    }

    private static void displayMenu() {
        System.out.println("\n1. Register New Patient");
        System.out.println("2. Search Patient");
        System.out.println("3. Delete Patient");
        System.out.println("4. Display All Patients");
        System.out.println("5. Add Patient to Emergency Queue");
        System.out.println("6. View Emergency Queue");
        System.out.println("7. Call Next Patient for Treatment");
        System.out.println("8. Complete Treatment");
        System.out.println("9. View Treatment History");
        System.out.println("10. Add Patient Visit");
        System.out.println("11. Remove Patient Visit");
        System.out.println("12. Search Patient Visit");
        System.out.println("13. Display Patient Visit History");
        System.out.println("14. Exit");
    }

    private static void sampleData() {
        System.out.println("\n--- Loading Sample Data ---");

        registerSamplePatient(101, "Alice Johnson", 29, "0712345678", "Fever");
        registerSamplePatient(105, "Brian Smith", 52, "0723456789", "Chest Pain");
        registerSamplePatient(102, "Catherine Lee", 35, "0734567890", "Fractured Arm");
        registerSamplePatient(110, "David Brown", 46, "0745678901", "Allergic Reaction");
        registerSamplePatient(108, "Eva Wilson", 24, "0756789012", "Severe Headache");

        emergencyQueue.enqueue(patientBST.search(105));
        emergencyQueue.enqueue(patientBST.search(110));

        Patient patient = patientBST.search(101);
        if (patient != null) {
            patient.getVisitHistory().addVisit(new Visit(1, LocalDate.of(2026, 1, 10), "Dr. Patel", "Flu", "Rest and medication"));
            patient.getVisitHistory().addVisit(new Visit(2, LocalDate.of(2026, 2, 14), "Dr. Ahmed", "Migraine", "Pain relief"));
        }

        Patient patient2 = patientBST.search(102);
        if (patient2 != null) {
            patient2.getVisitHistory().addVisit(new Visit(3, LocalDate.of(2026, 3, 5), "Dr. Khan", "Wrist sprain", "Bandage and rest"));
        }

        System.out.println("Sample data loaded successfully.");
    }

    private static void registerSamplePatient(int id, String name, int age, String contact, String condition) {
        Patient patient = new Patient(id, name, age, contact, condition);
        if (patientBST.insert(patient)) {
            System.out.println("Sample patient registered: " + patient.getName() + " (ID: " + patient.getId() + ")");
        }
    }

    private static void registerPatient() {
        System.out.println("\n--- Register New Patient ---");

        int id = readInt("Enter Patient ID: ");
        String name = readNonEmptyString("Enter Patient Name: ");
        int age = readAge();
        String contact = readNonEmptyString("Enter Contact Number: ");
        String condition = readNonEmptyString("Enter Medical Condition: ");

        Patient patient = new Patient(id, name, age, contact, condition);
        if (patientBST.insert(patient)) {
            System.out.println("Patient successfully registered.");
        }
    }

    private static void searchPatient() {
        System.out.println("\n--- Search Patient ---");
        int id = readInt("Enter Patient ID to search: ");
        Patient patient = patientBST.search(id);

        if (patient == null) {
            System.out.println("Patient not found with ID " + id + ".");
        } else {
            System.out.println("Patient found: " + patient);
        }
    }

    private static void deletePatient() {
        System.out.println("\n--- Delete Patient ---");
        int id = readInt("Enter Patient ID to delete: ");
        patientBST.delete(id);
    }

    private static void displayAllPatients() {
        patientBST.displayAllPatients();
    }

    private static void addPatientToEmergencyQueue() {
        System.out.println("\n--- Add Patient to Emergency Queue ---");
        int id = readInt("Enter Patient ID: ");
        Patient patient = patientBST.search(id);

        if (patient == null) {
            System.out.println("Patient not found. Please register the patient first.");
            return;
        }

        emergencyQueue.enqueue(patient);
    }

    private static void viewEmergencyQueue() {
        emergencyQueue.displayAllPatients();
    }

    private static void callNextPatient() {
        System.out.println("\n--- Call Next Patient for Treatment ---");
        Patient nextPatient = emergencyQueue.dequeue();
        if (nextPatient != null) {
            System.out.println("Now treating: " + nextPatient.getName() + " (ID: " + nextPatient.getId() + ")");
        }
    }

    private static void completeTreatment() {
        System.out.println("\n--- Complete Treatment ---");

        int patientId = readInt("Enter Patient ID: ");
        Patient patient = patientBST.search(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        String doctorName = readNonEmptyString("Enter Doctor Name: ");
        String treatment = readNonEmptyString("Enter Treatment/Diagnosis: ");
        String dateText = readNonEmptyString("Enter date (yyyy-MM-dd): ");
        LocalDate date;

        try {
            date = LocalDate.parse(dateText);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            return;
        }

        TreatmentRecord record = new TreatmentRecord(nextTreatmentId++, patientId, patient.getName(), doctorName, treatment, date);
        treatmentStack.push(record);
    }

    private static void viewTreatmentHistory() {
        treatmentStack.displayAllTreatments();
    }

    private static void addPatientVisit() {
        System.out.println("\n--- Add Patient Visit ---");
        int patientId = readInt("Enter Patient ID: ");
        Patient patient = patientBST.search(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        int visitId = readInt("Enter Visit ID: ");
        String dateText = readNonEmptyString("Enter Visit Date (yyyy-MM-dd): ");
        String doctorName = readNonEmptyString("Enter Doctor Name: ");
        String diagnosis = readNonEmptyString("Enter Diagnosis: ");
        String treatment = readNonEmptyString("Enter Treatment: ");

        try {
            LocalDate date = LocalDate.parse(dateText);
            patient.getVisitHistory().addVisit(new Visit(visitId, date, doctorName, diagnosis, treatment));
            System.out.println("Visit added successfully.");
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
        }
    }

    private static void removePatientVisit() {
        System.out.println("\n--- Remove Patient Visit ---");
        int patientId = readInt("Enter Patient ID: ");
        Patient patient = patientBST.search(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        int visitId = readInt("Enter Visit ID: ");
        if (patient.getVisitHistory().removeVisit(visitId)) {
            System.out.println("Visit removed successfully.");
        }
    }

    private static void searchPatientVisit() {
        System.out.println("\n--- Search Patient Visit ---");
        int patientId = readInt("Enter Patient ID: ");
        Patient patient = patientBST.search(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        int visitId = readInt("Enter Visit ID: ");
        Visit visit = patient.getVisitHistory().searchVisit(visitId);
        if (visit == null) {
            System.out.println("Visit ID " + visitId + " not found in patient history.");
        } else {
            System.out.println("Visit found: " + visit);
        }
    }

    private static void displayPatientVisitHistory() {
        System.out.println("\n--- Display Patient Visit History ---");
        int patientId = readInt("Enter Patient ID: ");
        Patient patient = patientBST.search(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        patient.getVisitHistory().displayVisits();
    }

    private static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
            }
        }
    }

    private static int readAge() {
        while (true) {
            int age = readInt("Enter Age: ");
            if (age > 0 && age < 150) {
                return age;
            }
            System.out.println("Invalid age. Please enter a number between 1 and 149.");
        }
    }

    private static String readNonEmptyString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("This field cannot be empty. Please try again.");
        }
    }
}
