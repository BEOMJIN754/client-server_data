import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Data extends UnicastRemoteObject implements DataIF{
	
	protected static StudentList studentList;
	protected static CourseList courseList;
	private static final long serialVersionUID = 1L;
	protected Data() throws RemoteException   {
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
		}
		catch (Exception e) {
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
	public boolean addStudent(String studentInfo) throws RemoteException {
		if(studentList.addStudentRecords(studentInfo))return true;
		return false;
	}
	@Override
	public boolean deleteStudent(String studentId) throws RemoteException {
		if(studentList.deleteStudentRecords(studentId))return true;
		return false;
	}
	@Override
	public boolean addCourse(String courseInfo) throws RemoteException {
		if(courseList.addCourseRecords(courseInfo))return true;
		return false;
	}
	@Override
	public boolean deleteCourse(String courseId) throws RemoteException {
		if(courseList.deleteCourseRecords(courseId))return true;
		return false;
	}
}
