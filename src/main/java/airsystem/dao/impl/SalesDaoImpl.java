package airsystem.dao.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import airsystem.dao.prototype.SalesDao;
import airsystem.entity.Flight;
import airsystem.entity.Sales;
@Component
public class SalesDaoImpl implements SalesDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public void saveSale(Sales sale) {
		jdbcTemplate.update("insert into sales(sale_name,number,password,branch_id) values(?,?,?,?)", new Object[] {sale.getSaleName(),sale.getNumber(),sale.getPassword(),sale.getBranchId()});
	}
	@Override
	public void deleteSale(int id) {
		jdbcTemplate.update("delete from sales where id=?",new Object[] {id});
	}
	@Override
	public List<Sales> listSales() {
		return jdbcTemplate.query("select sales.id,sale_name,number,password,branch_id,name from sales left join branch on sales.branch_id=branch.id", new BeanPropertyRowMapper<Sales>(Sales.class));
	}
	@Override
	public Sales getSale(int id) {
		return jdbcTemplate.queryForObject("select sales.id,sale_name,number,password,branch_id,name  from sales left join branch on sales.branch_id=branch.id where sales.id=?", new Object[] {id},new BeanPropertyRowMapper<Sales>(Sales.class));
	}
	@Override
	public void updateSale(int id, String saleName, String number, String password, int branchId) {
		jdbcTemplate.update("update sales set sale_name=?,number=?,password=?,branch_id=? where id=?", new Object[] {saleName,number,password,branchId,id});
	}
	@Override
	public List<Sales> listSales(int branchId) {
		return jdbcTemplate.query("select * from sales where branch_id=?",new Object[] {branchId}, new BeanPropertyRowMapper<Sales>(Sales.class));
	}
	@Override
	public Flight getSaleflightId(String id) {
		return jdbcTemplate.queryForObject("select * from flight join flight_scheduler on flight_scheduler.flight_number=flight.flight_number where flight_scheduler.id=?", new Object[] {id},new BeanPropertyRowMapper<Flight>(Flight.class));
//		return null;
	}

//		return jdbcTemplate.query("select branch_id where branchName=?",new Object[] {branchName},new BeanPropertyRowMapper());
}
