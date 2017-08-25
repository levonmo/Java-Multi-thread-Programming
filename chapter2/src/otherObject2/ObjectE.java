package otherObject2;

public class ObjectE {

	public void methodA(ObjectD objectD){
		synchronized (objectD) {
			try {
				System.out.println(Thread.currentThread().getName() + "线程进入" +  "时间为" + System.currentTimeMillis());
				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName() + "线程进入" +  "时间为" + System.currentTimeMillis());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
