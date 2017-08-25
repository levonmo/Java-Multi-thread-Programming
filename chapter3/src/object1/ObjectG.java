package object1;

//多生产与多消费:操作值-假死
public class ObjectG {

	private String lock;
	
	public ObjectG(String lock) {
		this.lock = lock;
	}
	
	public void geValue(){
		try {
			synchronized (lock) {
				while (ObjectD.VALUE.equals("")) {
					System.out.println("消费者" + Thread.currentThread().getName() + "线程" + "waiting了★★");
					lock.wait();
				}
				System.out.println("消费者" + Thread.currentThread().getName() + "线程" + "running了");
				
				ObjectD.VALUE = "";
				lock.notify();
//				lock.notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
