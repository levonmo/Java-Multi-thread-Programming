package otherObject;

//可重入锁的父子类继承
public class MyObject5 extends MyObject4{
	
	synchronized public void methodSon(){
		while(i > 0){
			i--;
			System.out.println("methodSon  i=" + i);
			this.methodFather();//this，鸡蛋模型，首先是指外面的蛋壳，就是MyObject4
		}
	}
	
}
