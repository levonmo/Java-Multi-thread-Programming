package otherObject2;

//同步方法与同步代码块会相互阻塞吗
public class MyObject6 {

	public void methodA(){
		synchronized (this) {
			try {
				System.out.println("线程" + Thread.currentThread().getName() + "进入了同步代码块区" );
				Thread.sleep(1000);
				System.out.println("线程" + Thread.currentThread().getName() + "离开了同步代码块区" );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	synchronized public void methodB(){
			System.out.println("线程" + Thread.currentThread().getName() + "进入同步方法区");
			System.out.println("线程" + Thread.currentThread().getName() + "进入了同步方法区" );
	}
	
}
