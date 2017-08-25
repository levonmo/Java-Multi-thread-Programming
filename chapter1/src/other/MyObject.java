package other;

//suspend与resume方法的缺点--数据不同步
public class MyObject {

	private String username = "a";
	private String password = "aa";
	
	public void setUsernameAndPassword(String username,String password){
		this.username = username;
		if(Thread.currentThread().getName().equals("a")){
			Thread.currentThread().suspend();//当 线程的名字是a的话，就进入该if语句，然后暂停
		}
		this.password = password;
	}
	
	public void print(){
		System.out.println(username + password);
		
	}
	
}
