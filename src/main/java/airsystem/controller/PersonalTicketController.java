package airsystem.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
			String toCity = req.getParameter("tocity-yzy");
			int id = Integer.parseInt(req.getParameter("id-yzy"));
			String startDate = req.getParameter("startDate-yzy");
			String fromCity = req.getParameter("fromcity-yzy");
			
			ModelAndView mv = new ModelAndView("againchooseflight");
			String startdate = startDate.substring(0,10);
			String dateyear = startdate.substring(0, 4);
			String datemonth = startdate.substring(5, 7);
			String dateday = startdate.substring(8, 10);
			List<QueryFlight> flights = pts.returnChooseTicket(fromCity, toCity, startdate);
			mv.addObject("ticketId", id);
			mv.addObject("fromCity",fromCity);
			mv.addObject("toCity",toCity);
			mv.addObject("dateday",dateday);
			mv.addObject("dateyear",dateyear);
			mv.addObject("datemoth",datemonth);
			mv.addObject("date",startdate);
			mv.addObject("flights",flights);
			for (QueryFlight queryFlight : flights) {
				System.out.println(queryFlight);
			}
			return mv;
		}
		@PostMapping("/changeTicket")
		@ResponseBody
		public String changeTicket(HttpServletRequest req) {
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
		
		
}
