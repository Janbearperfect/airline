package airsystem.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import airsystem.entity.Sales;
import airsystem.service.prototype.BranchService;
import airsystem.service.prototype.SalesService;

@Controller
public class SalesController {
	@Autowired
	private SalesService salesService;
	@Autowired
	private BranchService branchService;
	@RequestMapping("/sales")
	public ModelAndView showSales() {
		ModelAndView mv = new ModelAndView("sales");
		List<Sales> sales = salesService.listSales();
		mv.addObject("sales", sales);
		return mv; 
	}
	@RequestMapping("/deleteSale/{id}")
	@ResponseBody
	public String airportDelete(@PathVariable("id") int id) {
		salesService.deleteSale(id);
		return "success";
	}
	@RequestMapping(value="/getSale/{id}",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getAirport(@PathVariable("id") int id) {
		Sales sale = salesService.getSale(id);
		return JSON.toJSONString(sale);
	}
	@RequestMapping(value="/updateSale/{id}/{number}/{password}/{name}/{branchId}")
	@ResponseBody
	public String updateAirport(@PathVariable("id") int id,@PathVariable("number") String number,@PathVariable("password") String password,@PathVariable("name") String name,@PathVariable("branchId") String branchId) {
		salesService.updateSale(id, name, number, password, branchId);
		return "success";
	}
	@RequestMapping("/saveSale/{number}/{name}/{password}/{branchId}")
	@ResponseBody
	public String saveAirport(@PathVariable("number") String number,@PathVariable("password") String password,@PathVariable("name") String name,@PathVariable("branchId") String branchId) {
	    int Id = branchService.getBranchId(branchId);
	    Sales sale = new Sales(number,name,password,Id);
		salesService.saveSale(sale);
		return "success";
	}
}




