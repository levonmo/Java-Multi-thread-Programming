package otherObject2;

//多线程的死锁问题,就是不同的线程都在等待一个根本不可能被释放的锁,这会造成线程的"假死"现象
public class ObjectQ implements Runnable {

	public String username;
	public Object lock1 = new Object();
	public Object lock2 = new Object();
	
	public void setFlag(String username){
		this.username = username;
	}
	
	//两个方法进行互锁了
	public void run() {
		if (username.equals("a")) {
			synchronized (lock1) {
				try {
					System.out.println("username=" + username);
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (lock2) {
					System.out.println("按lock1-->lock2代码顺序执行了");
				}
			}
			
		}
		
		if(username.equals("b")){
			synchronized (lock2) {
				try {
					System.out.println("username=" + username);
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (lock1) {
					System.out.println("按lock2-->lock1代码顺序执行了");
				}
			}
			
		}
	}
	
}
