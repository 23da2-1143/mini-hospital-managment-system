public class EmergencyQueue {
    private QueueNode front;
    private QueueNode rear;

    // FIFO queue: the first patient added is the first patient treated.
    public EmergencyQueue() {
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(Patient patient) {
        if (patient == null) {
            System.out.println("Cannot add a null patient to the emergency queue.");
            return;
        }

        QueueNode newNode = new QueueNode(patient);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }

        System.out.println("Patient added to emergency queue: " + patient.getName() + " (ID: " + patient.getId() + ")");
    }

    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("Emergency queue is empty. No patient available for treatment.");
            return null;
        }

        Patient removedPatient = front.getPatient();

        if (front == rear) {
            front = null;
            rear = null;
        } else {
            front = front.getNext();
        }

        System.out.println("Dequeued patient: " + removedPatient.getName() + " (ID: " + removedPatient.getId() + ")");
        return removedPatient;
    }

    public Patient peek() {
        if (isEmpty()) {
            return null;
        }
        return front.getPatient();
    }

    public void displayAllPatients() {
        if (isEmpty()) {
            System.out.println("Emergency queue is empty.");
            return;
        }

        System.out.println("\n--- Emergency Queue (FIFO Order) ---");
        QueueNode current = front;
        int position = 1;

        while (current != null) {
            Patient patient = current.getPatient();
            System.out.println(position + ". " + patient.getName() + " (ID: " + patient.getId() + ", Condition: " + patient.getMedicalCondition() + ")");
            current = current.getNext();
            position++;
        }
    }
}
