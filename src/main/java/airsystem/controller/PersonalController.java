package airsystem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import airsystem.entity.PassengerInfo;

/**
 * 查询航班跳只填写信息页面
 * @author 赵胜涛
 *
 */
@Controller
public class PersonalController {
	
	@RequestMapping("/buyticket")
	@ResponseBody
	public ModelAndView listPassengerInfo(HttpServletRequest request,HttpServletResponse response){
		int adult=Integer.parseInt(request.getParameter("adultNumber"));
		int bady=Integer.parseInt(request.getParameter("baby"));

		int child=Integer.parseInt(request.getParameter("child"));

		String flightNumber=request.getParameter("flightNumber");

		String classes=request.getParameter("classes");

		String tprice=request.getParameter("tprice");

		double price=Double.parseDouble(tprice.substring(1,tprice.length()));
		PassengerInfo pif=new PassengerInfo(adult,bady,child, classes, price,flightNumber);
		ModelAndView mv=new ModelAndView("buyticket");
		mv.addObject("numbers",pif);
		System.out.println(adult);
		return mv;
	}
	@RequestMapping("/buyticketinfo")
	public String showBuyTicket(){
	
		return "buyticket";
	}
	
}
