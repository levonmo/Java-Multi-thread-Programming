package object1;

public class ObjectJ {

	private ObjectH objectH;
	
	public ObjectJ(ObjectH objectH) {
		this.objectH = objectH;
	}
	
	public void pushService(){
		objectH.push();
	}
	
}
