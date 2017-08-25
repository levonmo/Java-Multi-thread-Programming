package otherObject2;

//只要是对象没有改变，即使是对象的属性发生改变，运行的结果还是同步的
public class ObjectX {

	private String username;
	private String password;
	
	public ObjectX(String username,String password) {
		this.username = username;
		this.password = password;
	}
	
	public ObjectX() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
