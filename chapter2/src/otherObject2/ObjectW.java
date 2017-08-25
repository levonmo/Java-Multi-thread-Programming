package otherObject2;

//只要是对象没有改变，即使是对象的属性发生改变，运行的结果还是同步的
public class ObjectW {
	
	public void methodA(ObjectX objectX){
		synchronized (objectX) {
			try {
				System.out.println(Thread.currentThread().getName());
				objectX.setUsername("abc");
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + "线程退出");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
