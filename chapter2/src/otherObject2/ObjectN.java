package otherObject2;

//使用new Object()来作为同步代码块的对象
public class ObjectN {

	public void methodA(Object object){
		try {
			synchronized (object) {
				//这里进行无限的循环
				while(true){
					System.out.println("进入当前的线程名称是" + Thread.currentThread().getName());
					Thread.sleep(500);
					System.out.println("退出当前的线程名称是" + Thread.currentThread().getName());
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
