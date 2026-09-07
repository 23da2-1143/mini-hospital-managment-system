import java.time.LocalDate;

public class TreatmentRecord {
    private int treatmentId;
    private int patientId;
    private String patientName;
    private String doctorName;
    private String treatment;
    private LocalDate date;

    public TreatmentRecord(int treatmentId, int patientId, String patientName, String doctorName, String treatment, LocalDate date) {
        this.treatmentId = treatmentId;
        this.patientId = patientId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.treatment = treatment;
        this.date = date;
    }

    public int getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(int treatmentId) {
        this.treatmentId = treatmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Treatment ID: " + treatmentId + ", Patient ID: " + patientId + ", Patient: " + patientName + ", Doctor: " + doctorName + ", Diagnosis: " + treatment + ", Date: " + date;
    }
}
