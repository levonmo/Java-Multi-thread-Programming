package otherObject2;

//将任意对象作为对象监视器
public class MyObject5 {

	private String username;
	private String password;
	
	private String anything = new String();
	
	public void methodA(){
		try {
			//锁非this对象
			synchronized (anything) {
				System.out.println("线程" + Thread.currentThread().getName() + "进入了代码块" + "当前时间为" + System.currentTimeMillis());
				Thread.sleep(1000);
				System.out.println("线程" + Thread.currentThread().getName() + "离开了代码块" + "当前时间为" + System.currentTimeMillis());
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
}
