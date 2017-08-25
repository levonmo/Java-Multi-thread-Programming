package object1;

//多生产与多消费:操作值-假死
public class ObjectF {
	
	 private String lock;
	 
	 public ObjectF(String lock) {
		 this.lock = lock;
	 }
	 
	 public void setValue(){
		  try {
			synchronized (lock) {
				  while (!ObjectD.VALUE.equals("")) {
					  System.out.println("生产者" + Thread.currentThread().getName() + "线程" + "waiting了★");
					  lock.wait();
				}
				System.out.println("生产者" + Thread.currentThread().getName() + "线程" + "running了");
				String value = System.currentTimeMillis() + "_" + System.nanoTime();
				ObjectD.VALUE = value;
				lock.notify();
//				lock.notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	 }
	 
}
