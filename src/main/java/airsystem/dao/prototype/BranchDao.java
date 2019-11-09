package airsystem.dao.prototype;

import java.util.List;

import airsystem.entity.Branch;

public interface BranchDao {
	//获取单个营业点
	Branch getBranch(int id);
	
	//分页获取营业点
	List<Branch> findBrachs(int offset,int pageSize);
	
	void saveOrUpdateBranch(Branch branch);
	
	void deleteBranch(int id);
	
	int totalItem();
	List<Branch> findAll();
}
