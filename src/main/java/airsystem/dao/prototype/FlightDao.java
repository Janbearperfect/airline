package airsystem.dao.prototype;

import java.util.List;

import airsystem.entity.Flight;
/**
 * 航空表接口
 * @author 赵胜涛
 *
 */
public interface FlightDao {
	Flight getFlight(int id); //根据航班id查询
	Flight getFlight(String flightNumber); //航班编号
	List<Flight> listFlight(); //所有的航班查询
	int totalItems();    // 总条数
	String delete(int id);  //删除 返回success
	String saveOrUpdate(Flight flight); //更新或者插入

}
