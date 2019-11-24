package airsystem.service.prototype;

import java.util.List;

import airsystem.entity.Flight;
import airsystem.entity.Sales;

public interface SalesService {
	void saveSale(Sales sale);
	void deleteSale(int id);
	List<Sales> listSales();
	Sales getSale(int id);
	void updateSale(int id, String name, String number, String password, String branchId);
	List<Sales> listSales(int branchId);
	Flight getBuyTicket(String id);
}
