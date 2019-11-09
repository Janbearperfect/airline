package airsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import airsystem.dao.prototype.BranchDao;
import airsystem.entity.Branch;
import airsystem.service.prototype.BranchService;

@Service
public class BranchServiceImpl implements BranchService{
	@Autowired
	private BranchDao branch;
	@Override
	public List<Branch> listBranch(int pageNum, int pageSize) {
		int totalItem = branch.totalItem();
		int num = (totalItem+pageSize-1)/pageSize;
		if(pageNum>num) {
			pageNum=num;
		}
		return branch.findBrachs((pageNum-1)*pageSize, pageSize);
	
	}
	@Override
	public Branch getBranch(int id) {
	    return	branch.getBranch(id);
		
	}
	@Override
	public void saveOrUpdateBranch(Branch branch) {
		this.branch.saveOrUpdateBranch(branch);
		
	}
	@Override
	public void deleteBranch(int id) {
		branch.deleteBranch(id);
		
	}
	@Override
	public int totalItem() {
		return branch.totalItem();
	}
	@Override
	public List<Branch> findAll() {
		
		return branch.findAll();
	}



}
