import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Data extends UnicastRemoteObject implements DataIF {

	protected static StudentList studentList;
	protected static CourseList courseList;
	protected static RegistrationList registrationList;
	protected static UserList userList;
	private static final long serialVersionUID = 1L;

	protected Data() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try {
			Data data = new Data();
			// 브로커 등록
			Naming.rebind("Data", data);
			System.out.println("Data is ready!!");

			studentList = new StudentList("Students.txt");
			courseList = new CourseList("Courses.txt");
			registrationList = new RegistrationList();
			userList = new UserList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Student> getAllStudentData() throws RemoteException, NullDataException {

		return studentList.getAllStudentRecords();
	}

	@Override
	public ArrayList<Course> getAllCourseData() throws RemoteException, NullDataException {
		// TODO Auto-generated method stub
		return courseList.getAllCourseRecords();
	}

	@Override
	public ArrayList<Registration> getAllRegistrationData() throws RemoteException, NullDataException {
		// TODO Auto-generated method stub
		return registrationList.getAllRegistrationList();
	}

	@Override
	public boolean addStudent(String studentInfo) throws RemoteException {
		if (studentList.addStudentRecords(studentInfo))
			return true;
		return false;
	}

	@Override
	public boolean deleteStudent(String studentId) throws RemoteException {
		if (studentList.deleteStudentRecords(studentId))
			return true;
		return false;
	}

	@Override
	public boolean addCourse(String courseInfo) throws RemoteException {
		if (courseList.addCourseRecords(courseInfo))
			return true;
		return false;
	}

	@Override
	public boolean deleteCourse(String courseId) throws RemoteException {
		if (courseList.deleteCourseRecords(courseId))
			return true;
		return false;
	}
	@Override
	public boolean registerCourse(String studentId,String courseId) throws RemoteException {
	 
	    Student student = studentList.findStudentById(studentId);
	    if (student != null) {
	        student.registerCourse(courseId); // Student 객체에 courseId 추가
	        return registrationList.addRegistrationRecords(studentId,courseId); // registrationList에 등록 추가
	    }
	    return false;
	}
	@Override
	public Student getStudentById(String studentId) throws RemoteException, NullDataException {
		return studentList.findStudentById(studentId);
	}

	@Override
	public Course getCourseById(String courseId) throws RemoteException, NullDataException {
		for (Course course : courseList.getAllCourseRecords()) {
			if (course.match(courseId)) {
				return course;
			}
		}
		return null;
	}

	@Override
	public boolean addUserRecords(String usetInfo) {
		if (userList.addUserRecords(usetInfo))
			return true;
		return false;
	}

	@Override
	public boolean deleteUserRecords(String userId) {
		if (userList.deleteUserRecords(userId))
			return true;
		return false;
	}

	@Override
	public User getUserById(String userId) throws NullDataException {
		for (User user : userList.getAllUserRecords()) {
			if (user.match(userId)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public boolean deleteRegistration(String studentId, String courseId) throws RemoteException {
	    // RegistrationList에서 등록 삭제
	    boolean registrationDeleted = registrationList.deleteRegistration(studentId, courseId);
	    
	    if (registrationDeleted) {
	        // studentList를 통해 studentId로 학생 객체를 찾아 registeredCourses에서 해당 courseId 삭제
	        studentList.removeRegisteredCourse(studentId, courseId);
	        return true;
	    }
	    return false;
	}
}
