package airsystem.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

import airsystem.entity.Branch;
import airsystem.service.prototype.BranchService;


@Controller
public class BranchController {
	@Autowired
	private BranchService branch;

	@RequestMapping("/branch")
	public  ModelAndView getBranch() {
		ModelAndView mv = new ModelAndView("branch");
		List<Branch> brs=branch.findAll();
		
		mv.addObject("brs",brs);
		return mv;
	}

	@RequestMapping(value ="/saleBranch",produces="application/json; charset=utf-8")
	@ResponseBody
	public  String getSaleBranch() {
		List<Branch> brs=branch.findAll();
		return JSON.toJSONString(brs);
	}
	
	@RequestMapping(value="/branchUpdate",produces="application/json;charset=utf-8")
	public void branchUpdate(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
        Integer branchId=Integer.parseInt(request.getParameter("branchId"));
        String branchNumber=new String(request.getParameter("branchNumber"));
		String branchName=new String(request.getParameter("branchName"));
		String branchAddress=new String(request.getParameter("branchAddress"));
		String branchTele=new String(request.getParameter("branchTele"));
		String BranchPro=new String(request.getParameter("BranchPro"));
		String branchPassword="123456";
		Branch b = new Branch();
		b.setId(branchId);
		b.setbNumber(branchNumber);
		b.setbPassword(branchPassword);
		b.setName(branchName);
		b.setAddress(branchAddress);
		b.setTelephone(branchTele);
		b.setProvince(BranchPro);
		branch.saveOrUpdateBranch(b);
		response.sendRedirect("branch");
	}
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public String branchDelete(@PathVariable("id") int id) {
		branch.deleteBranch(id);
		return "success";
	}
	
	@RequestMapping("/addBranch")
	public void addBranch(HttpServletRequest request,HttpServletResponse response) throws IOException {
		    String branchNumber=new String(request.getParameter("branchNumber1"));
			String branchName=new String(request.getParameter("branchName1"));
			String branchAddress=new String(request.getParameter("branchAddress1"));
			String branchTele=new String(request.getParameter("branchTele1"));
			String BranchPro=new String(request.getParameter("BranchPro1"));
			Branch b = new Branch();
			b.setId(0);
			b.setbNumber(branchNumber);
			b.setName(branchName);
			b.setAddress(branchAddress);
			b.setTelephone(branchTele);
			b.setProvince(BranchPro);
			
			branch.saveOrUpdateBranch(b);
			response.sendRedirect("branch");
	}
}
