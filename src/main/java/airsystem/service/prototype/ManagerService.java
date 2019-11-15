package airsystem.service.prototype;

import airsystem.entity.Branch;
import airsystem.entity.Manager;
import airsystem.entity.Sales;

public interface ManagerService {
	Manager findManager(String number);
	Branch findBranch(String bnumber);
	Sales findSale(String number);
}
