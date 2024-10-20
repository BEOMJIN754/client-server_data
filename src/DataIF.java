import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface DataIF extends Remote{
	// 리모트를 위한 인터페이스이다!!! 리모트가 들어가야 외부에서 사용 가능한 스켈레톤 이 된다.
	ArrayList<Student> getAllStudentData () throws RemoteException, NullDataException;
	ArrayList<Course> getAllCourseData () throws RemoteException, NullDataException;
	boolean addStudent(String studentInfo) throws RemoteException;
	boolean deleteStudent(String studentId) throws RemoteException;
	boolean addCourse(String courseInfo) throws RemoteException;
	boolean deleteCourse(String courseId) throws RemoteException;
	
}
