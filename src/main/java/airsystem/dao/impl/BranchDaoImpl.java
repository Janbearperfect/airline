package airsystem.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import airsystem.dao.prototype.BranchDao;

import airsystem.entity.Branch;

@Repository
public class BranchDaoImpl implements BranchDao{
	@Autowired
	private JdbcTemplate jdbcTemplate ;

	@Override
	public Branch getBranch(Integer id) {
		
		return jdbcTemplate.queryForObject("select * from branch where id =?",new Object[] {id}, new BeanPropertyRowMapper<Branch>(Branch.class));
	}

	@Override
	public List<Branch> findBrachs(int offset, int pageSize) {
		
		return jdbcTemplate.query("select * from branch limit ?,?",new Object[] {offset,pageSize},new BeanPropertyRowMapper<Branch>(Branch.class));
	}



	@Override
	public void saveOrUpdateBranch(Branch branch) {
		if(branch.getId()==0) {
			jdbcTemplate.update("insert into branch(name,address,telephone,province,bnumber,bpassword) values(?,?,?,?,?,?)",
					             new Object[] {branch.getName(),branch.getAddress(),branch.getTelephone(),branch.getProvince(),branch.getbNumber(),"123456"});
		}else {
			jdbcTemplate.update("update branch set name=?,address=?,telephone=?,province=?, bnumber=?,bpassword=? where id=?",
					             new Object[] {branch.getName(),branch.getAddress(),branch.getTelephone(),branch.getProvince(),branch.getbNumber(),branch.getbPassword(),branch.getId()});
		}
		
	}

	@Override
	public void deleteBranch(int id) {
		jdbcTemplate.update("delete from branch where id=?",id);
		
	}

	@Override
	public int totalItem() {	
		return jdbcTemplate.queryForObject("select count(*) from branch",Integer.class);
	}

	@Override
	public List<Branch> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from branch", new BeanPropertyRowMapper<Branch>(Branch.class));
	}
	@Override
	public int getBranchId(String name) {
		return jdbcTemplate.queryForObject("select id from branch where name=?", new Object[] {name},Integer.class);
	}
	
}
