package airsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsystem.dao.prototype.PersonalTicketManageDao;
import airsystem.service.prototype.PersonalTicketManageService;
@Service
public class PersonalTicketManageServiceImpl implements PersonalTicketManageService {
	@Autowired
	private PersonalTicketManageDao personalTicket;
	@Override
	public boolean personalReturnTicket(int id) {
		if(personalTicket.presonalReturnTicket(id)) {
			return true;
		}else {
			return false;
		}
	}
}
