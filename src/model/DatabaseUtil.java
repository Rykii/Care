package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	private Connection conn = null;
	
	public Connection getConnection() throws SQLException {
		if (conn == null) { //判断资源是否存在
			try {
				//加载驱动
				Class.forName("com.mysql.jdbc.Driver");
				
				//建立连接
				conn = DriverManager.getConnection(DatabaseConf.URL, DatabaseConf.USER, DatabaseConf.PASSWORD);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
}