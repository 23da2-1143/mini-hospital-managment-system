public class Patient {
    private int id;
    private String name;
    private int age;
    private String contactNumber;
    private String medicalCondition;
    private VisitHistory visitHistory;

    public Patient(int id, String name, int age, String contactNumber, String medicalCondition) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.medicalCondition = medicalCondition;
        this.visitHistory = new VisitHistory();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public void setMedicalCondition(String medicalCondition) {
        this.medicalCondition = medicalCondition;
    }

    public VisitHistory getVisitHistory() {
        return visitHistory;
    }

    public void setVisitHistory(VisitHistory visitHistory) {
        this.visitHistory = visitHistory;
    }

    @Override
    public String toString() {
        return "Patient ID: " + id + ", Name: " + name + ", Age: " + age + ", Contact: " + contactNumber + ", Condition: " + medicalCondition;
    }
}
