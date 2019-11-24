package airsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import airsystem.dao.prototype.BranchDao;
import airsystem.dao.prototype.SalesDao;
import airsystem.entity.Flight;
import airsystem.entity.Sales;
import airsystem.service.prototype.SalesService;
@Component
public class SalesSericeImpl implements SalesService {
	@Autowired
	private SalesDao saleDao;
	@Autowired
	private BranchDao branchDao;
	@Override
	public void saveSale(Sales sale) {
		saleDao.saveSale(sale);
	}
	@Override
	public void deleteSale(int id) {
		saleDao.deleteSale(id);
	}
	@Override
	public List<Sales> listSales() {
		return saleDao.listSales();
	}
	@Override
	public Sales getSale(int id) {
		return saleDao.getSale(id);
	}
	@Override
	@Transactional
	public void updateSale(int id, String name, String number, String password, String branchId) {
		int Id = branchDao.getBranchId(branchId);
		saleDao.updateSale(id, name, number, password, Id);
	}
	@Override
	public List<Sales> listSales(int branchId) {
		return saleDao.listSales(branchId);
	}
	@Override
	public Flight getBuyTicket(String id) {
		
		return saleDao.getSaleflightId(id);
	}

	

}	
