package airsystem.dao.prototype;

import airsystem.entity.Branch;
import airsystem.entity.Manager;
import airsystem.entity.Sales;

public interface ManagerDao {
	Manager findManager(String number);
	Branch findBranch(String bnumber);
	Sales findSale(String number);
}
