package airsystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import airsystem.entity.Ticket;
import airsystem.entity.TicketBo;
import airsystem.service.prototype.FlightService;
import airsystem.service.prototype.TicketService;

/*
 * 票务管理controller类
 * */
@Controller

public class TicketController {
	
	@Autowired
    private TicketService ticketService;
	@Autowired
	private FlightService flightService;
	@RequestMapping("/pay")
	public String changePay() {
		return "pay";
	}
	
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
	@RequestMapping("/pushTicket")
	public ModelAndView pushTicket(HttpServletRequest request , HttpServletResponse response , HttpSession session) {
		String[] names = request.getParameterValues("name");
		List<Ticket> tickets= new ArrayList<>();
		for(int i=0 ; i<names.length;i++) {
			Ticket  ticket = new Ticket(); 
			int userId=0;
			if(request.getSession().getAttribute("userId")!=null) {
				userId=(int) session.getAttribute("userId");
			}
			ticket.setUserId(userId);
			String flightNumber = request.getParameter("flightId");
			int flightId = flightService.searchFlightId(flightNumber);
			ticket.setFlightId(flightId);
			String idNumber = request.getParameter("ID");
			ticket.setIdNumber(idNumber);
			int classes = 0;
			String classesname = request.getParameter("classes");
			if(classesname=="头等舱") {
				classes = 1;
			}else if(classesname=="商务舱"){
				classes = 2;
			}else {
				classes = 3;
			}
			ticket.setClasses(classes);
			int passengerType = Integer.parseInt(request.getParameter("type"+(i+1)));
			ticket.setpassengerType(passengerType);
			int salesId = 0;
			if(request.getSession().getAttribute("salesId")!=null) {
				userId=(int) session.getAttribute("salesId");
			}
			ticket.setSalesId(salesId);
			int status = 1;
			ticket.setStatus(status);
			double price = Double.parseDouble(request.getParameter("price"));
			ticket.settPrice(price);
			tickets.add(ticket);
		}
		ModelAndView mv = new ModelAndView("pay");
		session.setAttribute("tickets", tickets);
		return mv;
	}
	@RequestMapping("/saveTicket")
	@ResponseBody
	public String saveTicket(HttpServletRequest request , HttpServletResponse response , HttpSession session) {
		@SuppressWarnings("unchecked")
		List<Ticket> tickets = (List<Ticket>) session.getAttribute("tickets");
		for(int i=0 ; i<tickets.size();i++) {
			Ticket ticket = new Ticket();
			ticket.setUserId(tickets.get(i).getUserId());
			ticket.setFlightId(tickets.get(i).getFlightId());
			ticket.setIdNumber(tickets.get(i).getIdNumber());
			ticket.setClasses(tickets.get(i).getClasses());
			ticket.setpassengerType(tickets.get(i).getpassengerType());
			ticket.setSalesId(tickets.get(i).getSalesId());
			if(ticketService.saveTicket(tickets.get(i))) {
				flightService.updateFlightSeat(tickets.get(i).getFlightId(), tickets.get(i).getClasses(),1);
			}else {
				return "failure";
			}
		}
		return "success";
	}
	
}
