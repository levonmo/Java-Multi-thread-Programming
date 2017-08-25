package object;

//使用DCL双检查锁机制 来实现多线程环境中的延时加载单例设计模式
public class ObjectC {
	
	private volatile static ObjectC objectC;
	
	private ObjectC(){}
	
	public static ObjectC getInstance(){
		if (objectC != null) {
			/*
			 * 这里使用了volatile关键字，所有的线程是可见的
			 * 	只要一创建了objectC对象，它就不会走下面的synchronized代码块，这样就大大增大了效率
			 */
		} else {
			synchronized (ObjectC.class) {
				if(objectC == null){
					objectC = new ObjectC();
				}
			}
		}
		return objectC;
	}
	
}
