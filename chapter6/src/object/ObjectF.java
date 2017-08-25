package object;

//使用静态static代码块实现单例模式
public class ObjectF {
	
	private static ObjectF objectF = null;
	
	private ObjectF(){}
	
	static {
		objectF = new ObjectF();
	}
	
	public static ObjectF getIntance(){
		return objectF;
	}
}
