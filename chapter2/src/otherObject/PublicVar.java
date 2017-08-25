package otherObject;

//脏读
public class PublicVar {

	private String username = "A";
	private String password = "AA";
	
	synchronized public void setValue(String username,String password){
		try {
			System.out.println("当前线程:" + Thread.currentThread().getName());
			this.username = username;
			Thread.sleep(100);//当一个线程传人值，对username进行了赋值，但是还没有对password进行赋值，就被另一线程调用getValue进行取值了
			this.password = password;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//在取值的方法加上synchronized就不会出现脏读，把synchronized去掉试试效果
	synchronized public void getValue(){
		System.out.println("当前线程:" + Thread.currentThread().getName());
		System.out.println("username=" + username + "password" +  password);
	}
	
}
