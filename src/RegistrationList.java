import java.util.ArrayList;

public class RegistrationList {
    protected ArrayList<Registration> vRegistration;
    
    public RegistrationList() {
        this.vRegistration = new ArrayList<Registration>();
    }
    
    public ArrayList<Registration> getAllRegistrationList() {
        return this.vRegistration;
    }
    public boolean addRegistrationRecords(String studentId, String courseId) {
        Registration nRegistration = new Registration();
        nRegistration.setStudentId(studentId);
        nRegistration.setCourseId(courseId);
        return this.vRegistration.add(nRegistration);
    }
}
