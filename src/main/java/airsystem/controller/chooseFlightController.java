package airsystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import airsystem.entity.PiaoObject;
import airsystem.entity.QueryFlight;
import airsystem.service.prototype.QueryFlightService;

@Controller
public class chooseFlightController {
	@Autowired
	private QueryFlightService qf;
	
	@RequestMapping("/index")
	public void chooseFlightMainView() {
		
	}
	
	@RequestMapping("/commitChooseView")
    public ModelAndView commitChooseView(HttpServletRequest request,HttpServletResponse reponse) {
		
		ModelAndView mv = new ModelAndView("flight");
		
		String fromCity = request.getParameter("fromCity");
		String toCity = request.getParameter("toCity");
		String goDate = request.getParameter("goDate");
		String adult = request.getParameter("adult");
		String child = request.getParameter("child");
		String baby = request.getParameter("baby");
		
		
		String[] date = goDate.split("-");
		
		List<QueryFlight> qfs=qf.listqueryFlight(fromCity, toCity, goDate);
	
		List<PiaoObject> piao = new ArrayList<>();
		for(int i=0;i<qfs.size();i++) {
			PiaoObject pj = new PiaoObject();
			
			String at=qfs.get(i).getDepartureTime().toString();
			String a=qfs.get(i).getArrivalTime().toString();
			
			String [] at2 =at.split(" ");
			String [] a2 = a.split(" ");
			String n=at2[1].substring(0,at2[1].lastIndexOf(":"));
		    String n2 =a2[1].substring(0,a2[1].lastIndexOf(":"));
			pj.setArrival_time(n2);
			pj.setDeparture_time(n);
			pj.setEnd_date(a2[0]);
			piao.add(pj);
			
		}
		
		
		mv.addObject("fromCity",fromCity);
		mv.addObject("toCity",toCity);
		mv.addObject("date",date);
		mv.addObject("qfs",qfs);
		mv.addObject("baby",baby);
		mv.addObject("child",child);
		mv.addObject("adult",adult);
	
		mv.addObject("piao",piao);
	
		return mv;
		
	
	}
	
	
}
