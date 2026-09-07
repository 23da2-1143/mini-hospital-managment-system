public class QueueNode {
    private Patient patient;
    private QueueNode next;

    public QueueNode(Patient patient) {
        this.patient = patient;
        this.next = null;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public QueueNode getNext() {
        return next;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }
}
