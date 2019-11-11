package airsystem.service.prototype;

import java.util.List;

import airsystem.entity.Branch;

public interface BranchService {
	
	List<Branch> listBranch(int pageNum,int pageSize);
	
    Branch getBranch(int id);
	
	
	void saveOrUpdateBranch(Branch branch);
	
	void deleteBranch(int id);
	
	int totalItem();
	
	List<Branch> findAll();
	int getBranchId(String name);
}
