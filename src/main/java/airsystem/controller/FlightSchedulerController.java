package airsystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import airsystem.entity.FlightScheduler;
import airsystem.service.prototype.FlightSchedulerService;

/**
 *航班计划
 * @author 赵胜涛
 *
 */

@Controller
public class FlightSchedulerController {
	@Autowired
	private FlightSchedulerService fss;
	
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
	
}
