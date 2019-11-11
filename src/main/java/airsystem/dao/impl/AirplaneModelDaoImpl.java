package airsystem.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import airsystem.dao.prototype.AirplaneModelDao;
import airsystem.entity.AirplaneModel;

@Repository
public class AirplaneModelDaoImpl implements AirplaneModelDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public AirplaneModel getAirportModel(String airplane) {
		return jdbcTemplate.queryForObject("select * from airplane_model where airplane = ?",new Object[] {airplane},
				new BeanPropertyRowMapper<AirplaneModel>(AirplaneModel.class));
		 
	}

	@Override
	public List<AirplaneModel> findAirportModel(int offset, int pageSize) {
		
		return jdbcTemplate.query("select * from airplane_model limit ?,?",new Object[] {offset,pageSize},
				new BeanPropertyRowMapper<AirplaneModel>(AirplaneModel.class));
	}

	@Override
	public void Update(AirplaneModel am) {
		
		
			jdbcTemplate.update("update airplane_model set model=?,max_sail_length=?,first_class_seats=?,business_class_seats=?,economy_class_seats=? where airplane=?",
					new Object[] {am.getModel(),am.getMax_sail_length(),am.getFirst_class_seats(),am.getBusiness_class_seats(),am.getEconomy_class_seats(),am.getAirplane()});
		
		
	}
	@Override
	public void save(AirplaneModel am) {

		jdbcTemplate.update("insert into airplane_model values(?,?,?,?,?,?)",
				new Object[] {am.getAirplane(),am.getModel(),am.getMax_sail_length(),am.getFirst_class_seats(),am.getBusiness_class_seats(),am.getEconomy_class_seats()});
	}
	@Override
	public void deleteAirportModel(String airplane) {
		jdbcTemplate.update("delete from airplane_model where airplane=?",airplane);
		
	}

	@Override
	public int totalItem() {
		
		return jdbcTemplate.queryForObject("select count(*) from airplane_model",Integer.class);
	}

	@Override
	public List<AirplaneModel> findAll() {
		return jdbcTemplate.query("select * from airplane_model", new BeanPropertyRowMapper<AirplaneModel>(AirplaneModel.class));
		
	}
	
}
