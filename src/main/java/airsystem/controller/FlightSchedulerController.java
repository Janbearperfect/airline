package airsystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import airsystem.entity.FlightScheduler;
import airsystem.entity.PersonalTicket;
import airsystem.entity.QueryFlight;
import airsystem.service.prototype.FlightSchedulerService;
import airsystem.service.prototype.QueryFlightService;

/**
 *航班计划
 * @author 赵胜涛
 *
 */

@Controller
public class FlightSchedulerController {
	@Autowired
	private FlightSchedulerService fss;
	@Autowired
	private QueryFlightService qfs;
	
	@RequestMapping("/planflight")
	@ResponseBody
	public ModelAndView listFlightScheduler(){
		ModelAndView mv=new ModelAndView("planflight");
		List<FlightScheduler> flightSchedulers=fss.listFlightSchedulerService();
		mv.addObject("flightSchedulers",flightSchedulers);
		return mv;
	}
	@RequestMapping(value="/getplanflight/{id}",produces="application/json;charset=utf-8")
	@ResponseBody
	public String getFlightScheduler(@PathVariable("id")int id) {
		FlightScheduler getFlight=fss.getFlightScheduler(id);
		return JSON.toJSONString(getFlight);
	}
	//修改
	@RequestMapping("/updateplanflight")
	@ResponseBody
	public void updateFligthScheduler(HttpServletRequest request,HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("flightId"));
		String flightNumber=request.getParameter("flightNumber");
		String startDate=request.getParameter("startDate");
		String endDate=request.getParameter("endDate");
		String fromCity=request.getParameter("fromCity");
		String toCity=request.getParameter("toCity");
		String departureTime=request.getParameter("departureTime");
		String arrivalTime=request.getParameter("arrivalTime");
		String airplane=request.getParameter("airplane");
		String scheduler=request.getParameter("scheduler");
		int sailLength=Integer.parseInt(request.getParameter("sailLength"));
		fss.updateString(id, flightNumber, startDate, endDate, fromCity, toCity, departureTime, arrivalTime, airplane, scheduler, sailLength);
		try {
			response.sendRedirect("planflight");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//添加
	@RequestMapping("/saveplanflight")
	@ResponseBody
	public void saveFligthScheduler(HttpServletRequest request,HttpServletResponse response) {
		String flightNumber=request.getParameter("flightNumber");
		String startDate=request.getParameter("startDate");
		String endDate=request.getParameter("endDate");
		String fromCity=request.getParameter("fromCity");
		String toCity=request.getParameter("toCity");
		String departureTime=request.getParameter("departureTime");
		String arrivalTime=request.getParameter("arrivalTime");
		String airplane=request.getParameter("airplane");
		String scheduler=request.getParameter("scheduler");
		int sailLength=Integer.parseInt(request.getParameter("sailLength"));
		fss.saveFlightScheduler(flightNumber, startDate, endDate, fromCity, toCity, departureTime, arrivalTime, airplane, scheduler, sailLength);
		try {
			response.sendRedirect("planflight");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//删除
	@RequestMapping("/deleteplanflight/{id}")
	@ResponseBody
	public String deleteFlightScheduler(@PathVariable("id")int id) {
		 fss.deleteFlightScheduler(id);
		 return "success";
	}
	
	//查询实时航班
	@RequestMapping("/timeflight")
	@ResponseBody
	public ModelAndView listNowFlightScheduler(){
		ModelAndView mv=new ModelAndView("timeflight");
		List<FlightScheduler> flightSchedulers=fss.listNowFlightService();
		mv.addObject("flightSchedulers",flightSchedulers);
		return mv;
	}
	//查询往期航班
	@RequestMapping("/pastflight")
	@ResponseBody
	public ModelAndView listOutFlightScheduler(){
		ModelAndView mv=new ModelAndView("pastflight");
		List<FlightScheduler> flightSchedulers=fss.listOutFlightService();
		mv.addObject("flightSchedulers",flightSchedulers);
		return mv;
	}
	
	//查询航班
	@RequestMapping("/queryResult")
	@ResponseBody
	public ModelAndView  listQueryFlight(HttpServletRequest request,HttpServletResponse response){
		String fromCity=request.getParameter("from");
		String toCity=request.getParameter("to");
		String startDate=request.getParameter("date");
		ModelAndView mv=new ModelAndView("queryResult");
		List<QueryFlight> queryflights=qfs.listqueryFlight(fromCity, toCity, startDate);
		mv.addObject("queryflights",queryflights);
		return mv;
	}
	
	@RequestMapping("/queryflight")
	public ModelAndView queryFlight(){
		ModelAndView mv=new ModelAndView("queryflight");
		return mv;
	}
	
	//验证个人身份信息
	@RequestMapping("/personalInfo")
	@ResponseBody
	public String personalInfo(HttpServletRequest request) {
		String flag=request.getParameter("ID");
//		System.out.println(flag);
		return qfs.getPersonalInfo(flag);
	}
	
	//查询未出行航班
	@RequestMapping(value="/personalTicketInfo",produces="application/json;charset=utf-8")
	@ResponseBody
	public String listPersonal(HttpServletRequest request,HttpSession session){
		int id = 0;
		try {
			id = (int) session.getAttribute("userId");
			List<PersonalTicket> list=qfs.listPersonalFutureTicketId(id);
			return JSON.toJSONString(list);
		}catch (Exception e) {
			String IdNumber=(String) session.getAttribute("IdNumber");
//			System.out.println(IdNumber+"这是idnumber");
			List<PersonalTicket> list=qfs.listPersonalFutureTicket(IdNumber);
			return JSON.toJSONString(list);
		}
	
	}
	
	@RequestMapping("/personalIdNumber")
	public ModelAndView getPersonal(HttpServletRequest request,HttpSession session) {
		ModelAndView mv=new ModelAndView("personalTicket");
		String IdNumber=request.getParameter("IDNumber");
//		System.out.println("这是id" +IdNumber);
		session.setAttribute("IdNumber", IdNumber);
		mv.addObject("IdNumber", IdNumber);
		return mv;
	}
	@RequestMapping("/personalTicket")
	public String getShowViewP() {
		return "personalTicket";
	}
	//查询游客往期航班
	@RequestMapping(value="/personalTicketInfoBefore",produces="application/json;charset=utf-8")
	@ResponseBody
	public String listBeforePersonal(HttpServletRequest request) {
		String IdNumber=request.getParameter("IDNumber");
		List<PersonalTicket> list=qfs.listPersonalBeforeTicket(IdNumber);
//		System.out.println(list);
		return JSON.toJSONString(list);	
	}
	
//	//我的订单
//	@RequestMapping(value="/personalTicketInfoUser",produces="application/json;charset=utf-8")
//	@ResponseBody
//	public String listUserPersonal(HttpSession session) {
//		int id=(int) session.getAttribute("userId");
//		List<PersonalTicket> list=qfs.listPersonalFutureTicketId(id);
////		System.out.println(list);
//		return JSON.toJSONString(list);	
//	}
	//用户往期订单
	@RequestMapping(value="/personalTicketInfoBeforeUser",produces="application/json;charset=utf-8")
	@ResponseBody
	public String listUserBeforePersonal(HttpSession session) {
		int id=(int) session.getAttribute("userId");
		List<PersonalTicket> list=qfs.listPersonalBeforeTicketId(id);
		return JSON.toJSONString(list);	
	}
	
	
}
