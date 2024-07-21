package myPackageUsers;

public class User {
	private int uid;
	private String fullname;
	private String email;
	private String phone;
	private String loginName;
	private String loginPassword;
	private String userRole;

	public User() {
		this.uid = 0;
		this.fullname = "";
		this.email = "";
		this.phone = "";
		this.loginName = "";
		this.loginPassword = "";
		this.userRole = "";
	}

	public User(int uid, String fullname, String email, String phone, String loginName, String loginPassword,
			String userRole) {
		this.uid = uid;
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.loginName = loginName;
		this.loginPassword = loginPassword;
		this.userRole = userRole;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getuserRole() {
		return userRole;
	}

	public void setuserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", fullname=" + fullname + ", email=" + email + ", phone=" + phone + ", loginName="
				+ loginName + ", loginPassword=" + loginPassword + ", userRole=" + userRole + "]";
	}
}