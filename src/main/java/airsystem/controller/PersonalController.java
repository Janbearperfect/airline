package airsystem.controller;

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
	
	@RequestMapping("/buyticket/{adultNumber}/{bady}/{child}/{flightNumber}/{classes}/{tprice}")
	@ResponseBody
	public ModelAndView listPassengerInfo(@PathVariable("adultNumber")int adult,@PathVariable("bady")int bady,@PathVariable("child")int child,@PathVariable("flightNumber")String flightNumber,@PathVariable("classes")String classes,@PathVariable("tprice")String tprice){
		double price=Double.parseDouble(tprice.substring(0, tprice.length()-1));
		PassengerInfo pif=new PassengerInfo(adult,bady,child, flightNumber,classes, price);
		ModelAndView mv=new ModelAndView("buyticket");
		mv.addObject("numbers",pif);
		System.out.println(adult);
		return mv;
	}
	@RequestMapping("/buyticket")
	public String showBuyTicket(){
	
		return "buyticket";
	}
	
}
