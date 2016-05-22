package top.jjust.bean.user;

public class UserBean extends BaseUserBean{
	private String phone = "";
	private String studentID = "";
	private String realName = "";
	private long registTime = 0;
	private long banTime = 0;
	private String email = "";
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getRegistTime() {
		return registTime;
	}
	public void setRegistTime(long registTime) {
		this.registTime = registTime;
	}
	public long getBanTime() {
		return banTime;
	}
	public void setBanTime(long banTime) {
		this.banTime = banTime;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.getName()+super.getPassword()+super.getFlag();
	}
}
