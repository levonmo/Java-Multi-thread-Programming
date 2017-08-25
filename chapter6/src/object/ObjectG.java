package object;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public enum ObjectG {
	
	connectionFactory;
	
	private Connection connection;
	
	private ObjectG(){
		try {
			System.out.println("调用了ObjectG的构造");
			String url = "jdbc";
			String username = "sa";
			String password = "123";
			String driverName = "com";
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		return connection;
	}
	

}
