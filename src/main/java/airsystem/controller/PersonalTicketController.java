package airsystem.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import airsystem.entity.Flight;
import airsystem.entity.QueryFlight;
import airsystem.service.prototype.PersonalTicketService;

@Controller
public class PersonalTicketController {
		@Autowired
		private PersonalTicketService  pts;
		@RequestMapping("/againchooseflight")
		public void againchooseflight() {
			
		}
		@RequestMapping("/success")
		public void success() {
			
		}
		@RequestMapping(value ="/changeFlight" , method = RequestMethod.POST)
		public ModelAndView change(HttpServletRequest req) {
			String IdNumber=req.getParameter("IdNumber");
			String toCity = req.getParameter("tocity-yzy");
			int id = Integer.parseInt(req.getParameter("id-yzy"));
			String startDate = req.getParameter("startDate-yzy");
			String fromCity = req.getParameter("fromcity-yzy");
			ModelAndView mv = new ModelAndView("againchooseflight");
			String startdate = startDate.substring(0,10);
			List<QueryFlight> flights = pts.returnChooseTicket(fromCity, toCity, startdate);
//			for(int i= 0;i<flights.size();i++) {
//				System.out.println(flights.get(i));
//			}
			mv.addObject("IdNumber",IdNumber);
			mv.addObject("ticketId", id);
			mv.addObject("fromCity",fromCity);
			mv.addObject("toCity",toCity);
			mv.addObject("date",startdate);
			mv.addObject("flights",flights);
			return mv;
		}
		@PostMapping("/changeTicket")
		@ResponseBody
		public String changeTicket(HttpServletRequest req , HttpSession session) {
			String flightNumber = req.getParameter("flightId");
			String classesname = req.getParameter("classes");
			int classes=0;
			if(classesname.equals("头等舱")) {
				classes = 1;
			}else if(classesname.equals("商务舱")){
				classes = 2;
			}else {
				classes = 3;
			}
			double price =Double.parseDouble(req.getParameter("price"));
			int ticketId = Integer.parseInt(req.getParameter("Id"));
			pts.changeTicket(flightNumber, classes, price, ticketId);
				return "success";
		}
		//营业员改签选航班
		@PostMapping("/salesChange")
		@ResponseBody
		public String salesChange(HttpServletRequest req,HttpSession session) {
			String toCity = req.getParameter("toCity");
			int id = Integer.parseInt(req.getParameter("id"));
			String startDate = req.getParameter("date");
			String fromCity = req.getParameter("fromCity");
			String startdate = startDate.substring(0,10);
			String passengerType=req.getParameter("passengerType");
			session.setAttribute("toCity", toCity);
			session.setAttribute("id", id);
			session.setAttribute("fromCity",fromCity );
			session.setAttribute("startdate", startdate);
			session.setAttribute("passengerType", passengerType);
			return "success";
			
		}
		@RequestMapping("/saleschooseflight")
		public String showSalesChoose() {
			return "saleschooseflight";
		}
		
		@PostMapping(value="/salesChangeFlight",produces="application/json;charset=utf-8")
		@ResponseBody
		public String salesChangeFlight(HttpSession session) {
			String toCity=(String) session.getAttribute("toCity");
			String fromCity=(String) session.getAttribute("fromCity");
			String date=(String)session.getAttribute("startdate");
			List<QueryFlight> flights = pts.returnChooseTicket(fromCity, toCity, date);
			System.out.println(flights);
			return JSON.toJSONString(flights);
		}
		
		@PostMapping("/saleschangeTicket")
		@ResponseBody
		public String salesChangeTicket(HttpServletRequest req , HttpSession session) {
			String flightNumber = req.getParameter("flightId");
			System.out.println(flightNumber);
			int classes =Integer.parseInt( req.getParameter("classes"));
			Flight flight =pts.getPrice(flightNumber,classes);
			String passengerType=(String)session.getAttribute("passengerType");
			double price=flight.getPrice();
			if(passengerType.equals("儿童票")) {
				price=price*0.8;
			}else if(passengerType.equals("婴儿票")){
				price=price*0.5;
			}
			int ticketId = (int)session.getAttribute("id");
			pts.changeTicket(flightNumber, classes, price, ticketId);
			return "success";
		}
		
}
