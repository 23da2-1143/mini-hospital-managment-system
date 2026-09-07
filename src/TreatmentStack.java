public class TreatmentStack {
    private StackNode top;

    // LIFO stack: the most recent treatment is displayed and removed first.
    public TreatmentStack() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(TreatmentRecord treatmentRecord) {
        if (treatmentRecord == null) {
            System.out.println("Cannot push a null treatment record.");
            return;
        }

        StackNode newNode = new StackNode(treatmentRecord);
        newNode.setNext(top);
        top = newNode;
        System.out.println("Treatment record pushed: " + treatmentRecord.getTreatmentId());
    }

    public TreatmentRecord pop() {
        if (isEmpty()) {
            System.out.println("Treatment history is empty. No treatment records available.");
            return null;
        }

        TreatmentRecord poppedRecord = top.getRecord();
        top = top.getNext();
        System.out.println("Popped treatment: " + poppedRecord.getTreatmentId());
        return poppedRecord;
    }

    public TreatmentRecord peek() {
        if (isEmpty()) {
            return null;
        }
        return top.getRecord();
    }

    public void displayAllTreatments() {
        if (isEmpty()) {
            System.out.println("Treatment history is empty.");
            return;
        }

        System.out.println("\n--- Treatment History (LIFO Order) ---");
        StackNode current = top;
        while (current != null) {
            System.out.println(current.getRecord());
            current = current.getNext();
        }
    }
}
