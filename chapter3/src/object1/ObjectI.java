package object1;

public class ObjectI {

	private ObjectH objectH;
	
	public ObjectI(ObjectH objectH) {
		this.objectH = objectH;
	}
	
	public void popService(){
		System.out.println("pop=" + objectH.pop());
	}
	
}
