package object1;

//生产者
public class ObjectC {
	
	private String lock;
	
	public ObjectC(String lock) {
		this.lock = lock;
	}
	
	public void setValue() {
		synchronized (lock) {
			try {
				if (!ObjectD.VALUE.equals("")) {
//					System.out.println("wait_set");
					lock.wait();
				}
				String value = System.currentTimeMillis() + "_" + System.nanoTime();
				System.out.println("set的值是" + value);
				ObjectD.VALUE = value;
				lock.notify();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
