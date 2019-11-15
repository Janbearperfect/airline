package airsystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import airsystem.entity.FinancialChange;
import airsystem.entity.FinancialClasses;
import airsystem.entity.FinancialType;
import airsystem.service.prototype.FinancialService;

@Controller
public class FinancialController {
	
	@Autowired
	private FinancialService financialService;
	
	@RequestMapping(value="/dailyfinancial",produces = "application/json; charset=utf-8")
	public ModelAndView listFinancialView() {
		ModelAndView mv=new ModelAndView("dailyfinancial");
		List<FinancialClasses> list=financialService.listFinancialClass();
		mv.addObject("classes",list);
		List<FinancialType> list1=financialService.listFinancialType();
		mv.addObject("type",list1);
		double num=financialService.financialTotal();
		mv.addObject("num",num);
		return  mv;
	}
	@RequestMapping(value="/quarterfinancial",produces = "application/json; charset=utf-8")
	public ModelAndView quarterfinancial() {
		ModelAndView mv=new ModelAndView("quarterfinancial");
		List<FinancialClasses> list=financialService.listFinancialClassQuarter();
		mv.addObject("classes",list);
		List<FinancialType> list1=financialService.listFinancialTypeQuarter();
		mv.addObject("type",list1);
		double num=financialService.financialQuarterTotal();
		mv.addObject("num",num);
		return mv;
	}
	@RequestMapping(value="/yearlyfinancial",produces = "application/json; charset=utf-8")
	public ModelAndView yearlyfinancial() {
		ModelAndView mv=new ModelAndView("yearlyfinancial");
		List<FinancialClasses> list=financialService.listFinancialClassYear();
		mv.addObject("classes",list);
		List<FinancialType> list1=financialService.listFinancialTypeYear();
		mv.addObject("type",list1);
		double num=financialService.financialYearTotal();
		mv.addObject("num",num);
		return mv;
	}
	@RequestMapping(value="/dailyfinancialdata",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String listFinancialData() {
				List<FinancialClasses> list=financialService.listFinancialClass();
				FinancialChange financialChange = new FinancialChange ();
				List<FinancialChange> list1 = new ArrayList();
				for (FinancialClasses financialClasses : list) {
					String name ="";
					if(financialClasses.getClasses()==1) {
						name="头等舱";
					}else  if(financialClasses.getClasses()==2)  {
						name="商务舱";
					}else {
						name="经济舱";
					}
					list1.add(new FinancialChange(name,financialClasses.getPrice())); 
				}
				
				return JSON.toJSONString(list1);
	}
	@RequestMapping(value="/dailyfinancialdata2",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String listFinancialData1() {
		List<FinancialType> list=financialService.listFinancialType();
		FinancialChange financialChange=new FinancialChange();
		List<FinancialChange> list1=new ArrayList();
		for (FinancialType financialType : list) {
			String name="";
			if(financialType.getType()==1) {
				name="成人票";
			}else if(financialType.getType()==2) {
				name="儿童票";
			}else {
				name="婴儿票";
			}
			list1.add(new FinancialChange(name,financialType.getPrice()));
		}
		return JSON.toJSONString(list1);
		
	}
	@RequestMapping(value="/quarterfinancialdata",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String quarterfinancialData() {
				List<FinancialClasses> list=financialService.listFinancialClassQuarter();
				FinancialChange financialChange = new FinancialChange ();
				List<FinancialChange> list1 = new ArrayList();
				for (FinancialClasses financialClasses : list) {
					String name ="";
					if(financialClasses.getClasses()==1) {
						name="头等舱";
					}else  if(financialClasses.getClasses()==2)  {
						name="商务舱";
					}else {
						name="经济舱";
					}
					list1.add(new FinancialChange(name,financialClasses.getPrice())); 
				}
				
				return JSON.toJSONString(list1);
	}
	@RequestMapping(value="/quarterfinancialdata2",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String quarterfinancialData1() {
		List<FinancialType> list=financialService.listFinancialTypeQuarter();
		FinancialChange financialChange=new FinancialChange();
		List<FinancialChange> list1=new ArrayList();
		for (FinancialType financialType : list) {
			String name="";
			if(financialType.getType()==1) {
				name="成人票";
			}else if(financialType.getType()==2) {
				name="儿童票";
			}else {
				name="婴儿票";
			}
			list1.add(new FinancialChange(name,financialType.getPrice()));
		}
		return JSON.toJSONString(list1);
		
	}
	//
	@RequestMapping(value="/yearlyfinancialdata",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String yearlyfinancialData() {
				List<FinancialClasses> list=financialService.listFinancialClassYear();
				FinancialChange financialChange = new FinancialChange ();
				List<FinancialChange> list1 = new ArrayList();
				for (FinancialClasses financialClasses : list) {
					String name ="";
					if(financialClasses.getClasses()==1) {
						name="头等舱";
					}else  if(financialClasses.getClasses()==2)  {
						name="商务舱";
					}else {
						name="经济舱";
					}
					list1.add(new FinancialChange(name,financialClasses.getPrice())); 
				}
				
				return JSON.toJSONString(list1);
	}
	@RequestMapping(value="/yearlyfinancialdata2",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String yearlyfinancialData1() {
		List<FinancialType> list=financialService.listFinancialTypeYear();
		FinancialChange financialChange=new FinancialChange();
		List<FinancialChange> list1=new ArrayList();
		for (FinancialType financialType : list) {
			String name="";
			if(financialType.getType()==1) {
				name="成人票";
			}else if(financialType.getType()==2) {
				name="儿童票";
			}else {
				name="婴儿票";
			}
			list1.add(new FinancialChange(name,financialType.getPrice()));
		}
		return JSON.toJSONString(list1);
		
	}
	
	
	
	
}
