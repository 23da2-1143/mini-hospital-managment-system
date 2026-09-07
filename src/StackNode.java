public class StackNode {
    private TreatmentRecord record;
    private StackNode next;

    public StackNode(TreatmentRecord record) {
        this.record = record;
        this.next = null;
    }

    public TreatmentRecord getRecord() {
        return record;
    }

    public void setRecord(TreatmentRecord record) {
        this.record = record;
    }

    public StackNode getNext() {
        return next;
    }

    public void setNext(StackNode next) {
        this.next = next;
    }
}
