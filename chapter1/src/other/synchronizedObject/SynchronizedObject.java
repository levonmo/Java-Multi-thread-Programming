package other.synchronizedObject;

/*
 * 这是测试使用stop()方法释放锁产生的影响
 */
public class SynchronizedObject {

	private String username = "a";
	private String password = "aa";
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
	
	//有一份加锁的方法测试
	synchronized public void printString(String username,String password){
		try {
			this.username = username;
			Thread.sleep(1000);
			this.password = password;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
