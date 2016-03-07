package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;

import chameleon.Account;

public class DatabaseHandler {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private DatabaseUtil DBUtil = new DatabaseUtil();
	
	public int insert(String mac, String psk) {
		int result = 0;
		String record = select(mac);
		
		if (record == null) { //数据库没有记录
			String sql = "insert into account (mac, psk) values (?, ?)";
			try {
				conn = (Connection)DBUtil.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(1, mac);
				ps.setString(2, psk);
				result = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeAll();
			}
		}
		return result;
	}
	
	public int delete(String mac) {
		int result = 0;
		String sql = "delete from account where mac = ?";
		
		try {
			conn = (Connection)DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, mac);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return result;
	}
	
	public int update(String mac, String psk) {
		int result = 0;
		String sql = "update account set psk = ? where mac = ?";
		
		try {
			conn = (Connection)DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, mac);
			ps.setString(2, psk);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return result;
	}
	
	public String select(String mac) {
		String result = null;
		Account account = new Account(); //对象, 必须独一无二
		String sql = "select * from account where mac = ?";
		
		try {
			conn = (Connection)DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, mac);
			rs = ps.executeQuery();
			while (rs.next()) {
				account.setMac(rs.getString("mac"));
				account.setPsk(rs.getString("psk"));
			}
			result = account.toString(account.getMac(), account.getPsk());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return result;
	}
	
	private void closeAll() {
		try {
			if (rs !=null ) { //ResultSet
				rs.close();
			}
			
			if (ps != null) { //PrepareStatement
				ps.close();
			}
			
			if (conn != null) { //Connection
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}