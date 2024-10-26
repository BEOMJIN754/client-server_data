import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Registration implements Serializable {
	private static final long serialVersionUID = 1L;
	protected String studentId;
	protected ArrayList<String> courseIds;

	public Registration(String inputString) {
		StringTokenizer stringTokenizer = new StringTokenizer(inputString);
		this.studentId = stringTokenizer.nextToken();
		this.courseIds = new ArrayList<String>();
		
		while(stringTokenizer.hasMoreTokens()) {
			this.courseIds.add(stringTokenizer.nextToken());
		}
	}
	public String getStudentId() {
		return studentId;
	}
	public ArrayList<String> getCourseId() {
		return courseIds;
	}
	public void addCourseId(String courseId) { 
        if (!courseIds.contains(courseId)) {
            courseIds.add(courseId);
        }
    }
	 public boolean removeCourseId(String courseId) {
	        return courseIds.remove(courseId); // courseId 삭제
	    }
	 public boolean isEmpty() {
	        return courseIds.isEmpty();
	    }
	@Override
    public String toString() {
        return "Student ID: " + studentId + ", Course ID: " + courseIds;
    }
}
