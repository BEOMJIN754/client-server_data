import java.util.ArrayList;

public class UserList {
	protected ArrayList<User> vUser;
	
	public UserList() {
		this.vUser = new ArrayList<User>();
	}
	
	public ArrayList<User> getAllUserRecords()throws NullDataException{
		return this.vUser;
	}
	public boolean addUserRecords(String userInfo) {
		if(this.vUser.add(new User(userInfo))) return true;
		else return false;
	}
	
	public boolean deleteUserRecords(String courseId) {
		for (int i = 0; i < this.vUser.size(); i++) {
			User user = (User) this.vUser.get(i);
			if (user.match(courseId)) {
				if(this.vUser.remove(user))return true;
				else return false;
			}
		}
		return false;
	}
}
