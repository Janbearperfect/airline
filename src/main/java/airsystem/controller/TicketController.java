package airsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import airsystem.entity.Ticket;
import airsystem.entity.TicketBo;
import airsystem.service.prototype.TicketService;

/*
 * 票务管理controller类
 * */
@Controller
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
    private TicketService ticketService;
	
	@RequestMapping("/sellticket")
	public ModelAndView listTicketView() {
	   ModelAndView mv=new ModelAndView("sellticket");
	   List<TicketBo> listTicket=ticketService.listPaged(); 
	  mv.addObject("ticket", listTicket);
	 
	 return mv;		
	}
	
	@RequestMapping("/changeticket")
	public ModelAndView listChangeTicketView() {
	   ModelAndView mv=new ModelAndView("changeticket");
	   List<TicketBo> listTicket=ticketService.listPagedChange();
	  mv.addObject("ticket", listTicket);
	  
	 return mv;		
	}
	
	
	@RequestMapping("/refundticket")
	public ModelAndView listRefundTicketView() {
	   ModelAndView mv=new ModelAndView("refundticket");
	   List<TicketBo> listTicket=ticketService.listPagedRefund();
	  mv.addObject("ticket", listTicket);
	  
	 return mv;		
	}
}
