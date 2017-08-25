package object1;
//实现第一次调用ThreadLocal类的get()方法返回值不是null
public class ObjectM extends ThreadLocal {
	
	protected Object initialValue(){
		return "我要默认值，第一次get不再是null";
	}

}
