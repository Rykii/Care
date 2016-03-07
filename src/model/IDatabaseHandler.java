package model;

/**
 * <code>IDatabaseHandler</code> 接口, 定义了数据库增删改查行为.
 * 
 * @author Aken
 * @Date 2015-1-9
 * @version 1.0
 */
public interface IDatabaseHandler {

	/**
	 * 添加 mac 地址和 psk 密码.
	 * 
	 * @param String mac 硬件地址.
	 * @param String psk 密码.
	 * 
	 * @return int 插入记录的行号.
	 */
	public int insert(String mac, String psk);
	
	/**
	 * 删除 mac 地址和 psk 密码.
	 * 
	 * @param String mac 硬件地址.
	 *
	 * @return int 删除记录的行号.
	 */
	public int delete(String mac);
	
	/**
	 * 更新 psk 密码.
	 * 
	 * @param String mac 硬件地址.
	 * @param String psk 密码.
	 * 
	 * @return int 更新记录的行号. 
	 */
	public int update(String mac, String psk);
	
	/**
	 * 查询 psk 密码.
	 * 
	 * @param String mac 硬件地址.
	 * 
	 * @return String 查询的记录.
	 */
	public String select(String mac);
}
