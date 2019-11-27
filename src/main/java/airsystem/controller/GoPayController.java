package airsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GoPayController {
    

	@PostMapping("/gopay")
	public ModelAndView pay() {
		
		ModelAndView mv=new ModelAndView("alipay.trade.page.pay");
		return mv;
		
	}
}
