package other.login;

public class Alogin extends Thread {
	
	@Override
	public void run() {
		LoginServlet.dopost("a", "aa");
	}

}	
