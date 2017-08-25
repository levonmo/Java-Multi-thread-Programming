package object;

//验证blocked
public class ObjectB {
	
	synchronized static public void methodA(){
		try {
			System.out.println(Thread.currentThread().getName() + "进入了methodA");
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
