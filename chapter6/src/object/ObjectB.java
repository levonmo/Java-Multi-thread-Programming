package object;

//延时加载/"懒汉模式"
public class ObjectB {

	private static ObjectB objectB;
	
	private ObjectB(){}
	
	public static ObjectB getInstance(){
		//延时加载
		if (objectB == null) {
			objectB = new ObjectB();
		}
		return objectB;
	}
	
}
