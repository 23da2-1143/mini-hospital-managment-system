public class VisitHistory {
    private VisitNode head;

    // Singly linked list of patient visits.
    public VisitHistory() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addVisit(Visit visit) {
        if (visit == null) {
            System.out.println("Cannot add a null visit.");
            return;
        }

        VisitNode newNode = new VisitNode(visit);
        if (head == null) {
            head = newNode;
            return;
        }

        VisitNode current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
    }

    public boolean removeVisit(int visitId) {
        if (head == null) {
            System.out.println("Visit history is empty.");
            return false;
        }

        if (head.getVisit().getVisitId() == visitId) {
            head = head.getNext();
            return true;
        }

        VisitNode current = head;
        while (current.getNext() != null) {
            if (current.getNext().getVisit().getVisitId() == visitId) {
                current.setNext(current.getNext().getNext());
                return true;
            }
            current = current.getNext();
        }

        System.out.println("Visit with ID " + visitId + " not found.");
        return false;
    }

    public Visit searchVisit(int visitId) {
        VisitNode current = head;
        while (current != null) {
            if (current.getVisit().getVisitId() == visitId) {
                return current.getVisit();
            }
            current = current.getNext();
        }
        return null;
    }

    public void displayVisits() {
        if (head == null) {
            System.out.println("No visit history available for this patient.");
            return;
        }

        System.out.println("\n--- Patient Visit History ---");
        VisitNode current = head;
        while (current != null) {
            System.out.println(current.getVisit());
            current = current.getNext();
        }
    }

    public VisitNode getHead() {
        return head;
    }
}
