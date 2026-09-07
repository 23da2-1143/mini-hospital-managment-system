public class PatientBST {
    private PatientNode root;

    // BST property: left subtree contains smaller Patient IDs,
    // right subtree contains larger Patient IDs.
    public PatientBST() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean insert(Patient patient) {
        if (patient == null) {
            return false;
        }

        if (search(patient.getId()) != null) {
            System.out.println("Duplicate Patient ID detected. Patient ID " + patient.getId() + " already exists.");
            return false;
        }

        root = insertRec(root, patient);
        return true;
    }

    private PatientNode insertRec(PatientNode current, Patient patient) {
        if (current == null) {
            return new PatientNode(patient);
        }

        if (patient.getId() < current.getPatient().getId()) {
            current.setLeft(insertRec(current.getLeft(), patient));
        } else if (patient.getId() > current.getPatient().getId()) {
            current.setRight(insertRec(current.getRight(), patient));
        }

        return current;
    }

    public Patient search(int patientId) {
        return searchRec(root, patientId);
    }

    private Patient searchRec(PatientNode current, int patientId) {
        if (current == null) {
            return null;
        }

        if (patientId == current.getPatient().getId()) {
            return current.getPatient();
        }

        if (patientId < current.getPatient().getId()) {
            return searchRec(current.getLeft(), patientId);
        }

        return searchRec(current.getRight(), patientId);
    }

    public boolean delete(int patientId) {
        if (search(patientId) == null) {
            System.out.println("Patient with ID " + patientId + " not found.");
            return false;
        }

        root = deleteRec(root, patientId);
        System.out.println("Patient ID " + patientId + " deleted successfully.");
        return true;
    }

    private PatientNode deleteRec(PatientNode current, int patientId) {
        if (current == null) {
            return null;
        }

        if (patientId < current.getPatient().getId()) {
            current.setLeft(deleteRec(current.getLeft(), patientId));
            return current;
        }

        if (patientId > current.getPatient().getId()) {
            current.setRight(deleteRec(current.getRight(), patientId));
            return current;
        }

        // Node with no children
        if (current.getLeft() == null && current.getRight() == null) {
            return null;
        }

        // Node with one child
        if (current.getLeft() == null) {
            return current.getRight();
        }

        if (current.getRight() == null) {
            return current.getLeft();
        }

        // Node with two children: replace with inorder successor
        PatientNode successor = findMinNode(current.getRight());
        current.setPatient(successor.getPatient());
        current.setRight(deleteRec(current.getRight(), successor.getPatient().getId()));
        return current;
    }

    private PatientNode findMinNode(PatientNode current) {
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    public void displayAllPatients() {
        if (isEmpty()) {
            System.out.println("No patients registered yet.");
            return;
        }

        System.out.println("\n--- Patient Records in Ascending Patient ID Order ---");
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(PatientNode current) {
        if (current == null) {
            return;
        }

        inOrderTraversal(current.getLeft());
        System.out.println(current.getPatient());
        inOrderTraversal(current.getRight());
    }

    public PatientNode getRoot() {
        return root;
    }
}
