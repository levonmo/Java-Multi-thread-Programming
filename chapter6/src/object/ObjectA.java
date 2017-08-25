package object;

//立即加载/"饿汉模式"
public class ObjectA {

	private static ObjectA objectA = new ObjectA();
	
	private ObjectA(){
	}

	public static ObjectA getInstance(){
		return objectA;
	}
}

