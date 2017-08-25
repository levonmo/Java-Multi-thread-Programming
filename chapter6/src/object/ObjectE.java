package object;

import java.io.Serializable;

//序列化与反序列化的单例模式实现
public class ObjectE implements Serializable {
	
	private static final long serialVersionUID = 888L;
	
	//内部类方式
	private static class ObjectEHandler{
		private static final ObjectE objectE = new ObjectE();
	}
	
	private ObjectE(){}
	
	public ObjectE getInstance(){
		return ObjectEHandler.objectE;
	}
	
}
