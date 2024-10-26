import java.util.ArrayList;
import java.util.StringTokenizer;

public class RegistrationList {
    protected ArrayList<Registration> vRegistration;
    
    public RegistrationList() {
        this.vRegistration = new ArrayList<Registration>();
    }
    
    public ArrayList<Registration> getAllRegistrationList() {
        return this.vRegistration;
    }
    public boolean addRegistrationRecords(String studentId, String courseId) {
        Registration registration = findRegistrationByStudentId(studentId);
        if (registration == null) {
            registration = new Registration(studentId); // 새 등록 생성
            vRegistration.add(registration);
        }

        registration.addCourseId(courseId); // 코스 ID 추가
        return true;
    }
    
    public boolean deleteRegistration(String studentId, String courseId) {
        Registration registration = findRegistrationByStudentId(studentId);
        if (registration != null) {
            boolean removed = registration.removeCourseId(courseId);
            if (registration.isEmpty()) {
                vRegistration.remove(registration);
            }
            return removed;
        }
        return false;
    }
    
    public Registration findRegistrationByStudentId(String studentId) {
        for (Registration reg : vRegistration) {
            if (reg.getStudentId().equals(studentId)) {
                return reg;
            }
        }
        return null;
    }
}
