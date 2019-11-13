package airsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsystem.dao.prototype.ManagerDao;
import airsystem.entity.Manager;
import airsystem.service.prototype.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService{
	@Autowired
	private ManagerDao md;
	
	@Override
	public Manager findManager(String number) {
		
		return md.findManager(number);
	}
	

}
