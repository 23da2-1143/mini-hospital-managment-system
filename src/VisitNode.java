public class VisitNode {
    private Visit visit;
    private VisitNode next;

    public VisitNode(Visit visit) {
        this.visit = visit;
        this.next = null;
    }

    public Visit getVisit() {
        return visit;
    }

    public void setVisit(Visit visit) {
        this.visit = visit;
    }

    public VisitNode getNext() {
        return next;
    }

    public void setNext(VisitNode next) {
        this.next = next;
    }
}
