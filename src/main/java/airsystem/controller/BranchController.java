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
	
	@RequestMapping("/branchUpdate")
	public void branchUpdate(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
        Integer branchId=Integer.parseInt(request.getParameter("branchId"));
		String branchName=new String(request.getParameter("branchName").getBytes("8859_1"),"utf-8");
		String branchAddress=new String(request.getParameter("branchAddress").getBytes("8859_1"),"utf-8");
		String branchTele=new String(request.getParameter("branchTele").getBytes("8859_1"),"utf-8");
		String BranchPro=new String(request.getParameter("BranchPro").getBytes("8859_1"),"utf-8");
		
		Branch b = new Branch();
		b.setId(branchId);
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
		    
			String branchName=new String(request.getParameter("branchName").getBytes("8859_1"),"utf-8");
			String branchAddress=new String(request.getParameter("branchAddress").getBytes("8859_1"),"utf-8");
			String branchTele=new String(request.getParameter("branchTele").getBytes("8859_1"),"utf-8");
			String BranchPro=new String(request.getParameter("BranchPro").getBytes("8859_1"),"utf-8");
			Branch b = new Branch();
			b.setId(0);
			b.setName(branchName);
			b.setAddress(branchAddress);
			b.setTelephone(branchTele);
			b.setProvince(BranchPro);
			
			branch.saveOrUpdateBranch(b);
			response.sendRedirect("branch");
	}
}
