package object;

//使用静态内置类实现单例模式
public class ObjectD {
	
	private static class ObjectDHandler {
		private static ObjectD objectD = new ObjectD();
	}
	
	private ObjectD(){}
	
	public static ObjectD getInstance(){
		return ObjectDHandler.objectD;
	}
}
