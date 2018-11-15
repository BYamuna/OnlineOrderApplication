package com.charvikent.onlineorder.dao;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.charvikent.onlineorder.config.KptsUtil;
import com.charvikent.onlineorder.model.Chocolate;
@Repository
@Transactional
public class ChocolateDao 
{
	@PersistenceContext private EntityManager em;
	@Autowired private JdbcTemplate jdbcTemplate;
	@Autowired KptsUtil kptsUtil;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	public void saveChocolates(Chocolate ch)
	{
		logger.info("saving chocolates");
		/*String orderid=kptsUtil.randNum();
		ch.setOrderId(orderid);*/
		em.persist(ch);
	}
	
	@SuppressWarnings("unchecked")
	public Chocolate getChocolateByObject(Chocolate ch) 
	{
		String hql ="from Chocolate where contact='"+ch.getContact()+"'";
		List<Chocolate> choco= em.createQuery(hql).getResultList();
		if(choco.size() > 0)
			return choco.get(0);
		return null;
	}
	
	public Chocolate getChocolateById(String id) 
	{

		return em.find(Chocolate.class, id);
	}
	public void updateChocolate(Chocolate ch) 
	{
		Chocolate choco = getChocolateById(ch.getOrderId());
		choco.setCustomerName(ch.getCustomerName());
		choco.setContact(ch.getContact());
		choco.setDeliveryDate(ch.getDeliveryDate());
		choco.setDeliveryLocation(ch.getDeliveryLocation());
		choco.setDeliveryMode(ch.getDeliveryMode());
		choco.setModel(ch.getModel());
		choco.setModeOfPayment(ch.getModeOfPayment());
		choco.setNotes(ch.getNotes());
		choco.setWeight(ch.getWeight());
		choco.setQuantity(ch.getQuantity());
		/*choco.setOrderId(ch.getOrderId());*/
		/*em.merge(choco);*/
		em.flush();
	}
	
	@SuppressWarnings("unchecked")
	public List<Chocolate> getAllChocolates()
	{
			//String sql="select order_id,chocostatus from chocolateordering";
			/*RowMapper<Chocolate> rowMapper = new BeanPropertyRowMapper<Chocolate>(Chocolate.class);
			return  this.jdbcTemplate.query(sql, rowMapper);	*/
			/*List<Map<String, Object>>  retlist = jdbcTemplate.queryForList(sql,new Object[]{});
			return retlist;*/
			return em.createQuery("from Chocolate").getResultList();
	}

	public List<Chocolate> getChocolatesByOrderId(Chocolate chocolate) 
	{
		String hql="select * from chocolateordering where order_id='"+chocolate.getOrderId()+"'";
		RowMapper<Chocolate> rowMapper = new BeanPropertyRowMapper<Chocolate>(Chocolate.class);
		return  this.jdbcTemplate.query(hql, rowMapper);	
	}
public int updateChocolatesByOrderId(Chocolate chocolate) {
		
		String sql="update chocolateordering set chocostatus='"+chocolate.getChocostatus()+"' where order_id='"+chocolate.getOrderId()+"'";
		System.out.println(sql);
		int  result = jdbcTemplate.update(sql);
		return result;
		
	}
	
	
	
	/*public List<Map<String, Object>> getChocolateStatusCount(Chocolate chocolate) 
	{
	String sql="select ch.chocostatus as orderedstatus, count(ch.chocostatus) as number from chocolateordering ch group by ch.chocostatus";
	
	RowMapper<Chocolate> rowMapper = new BeanPropertyRowMapper<Chocolate>(Chocolate.class);
	return  this.jdbcTemplate.query(sql, rowMapper);	
	List<Map<String, Object>>  retlist = jdbcTemplate.queryForList(sql,new Object[]{});
	return retlist;
	
	}*/
public  List<Map<String, Object>> getChocolateStatusCountbyOrdered(Chocolate chocolate){
	
	String sql="select ch.chocostatus as orderedstatus, count(ch.chocostatus) as number from chocolateordering ch where chocostatus='"+"ordered"+"'";
	
	
	List<Map<String, Object>>  retlist = jdbcTemplate.queryForList(sql,new Object[]{});
	return retlist;
	
	
}
public  List<Map<String, Object>> getChocolateStatusCountbyInprogress(Chocolate chocolate){
	
	String sql="select ch.chocostatus as orderedstatus, count(ch.chocostatus) as number from chocolateordering ch where chocostatus='"+"inprogress"+"'";
	
	
	List<Map<String, Object>>  retlist = jdbcTemplate.queryForList(sql,new Object[]{});
	return retlist;
	
	
}
public  List<Map<String, Object>> getChocolateStatusCountbyDelivered(Chocolate chocolate){
	
	String sql="select ch.chocostatus as orderedstatus, count(ch.chocostatus) as number from chocolateordering ch where chocostatus='"+"delivered"+"'";
	
	
	List<Map<String, Object>>  retlist = jdbcTemplate.queryForList(sql,new Object[]{});
	return retlist;
	
	
}
		
		
		
public List<Map<String, Object>> getTotalChocolateStatus(Chocolate chocolate) {
		String sql="select count(chocostatus) as total from chocolateordering";
		System.out.println(sql);
		
		List<Map<String, Object>>  retlist = jdbcTemplate.queryForList(sql,new Object[]{});
		return retlist;
		
				
	}
	/*public List<Map<String, Object>> getAdvancedOrderCount(Chocolate chocolate) 
	{
	String sql="SELECT ch.chocostatus,count(ch.chocostatus) as number FROM chocolateordering ch WHERE ch.delivery_date BETWEEN '"+chocolate.getDeliveryDate()+"' AND '"+chocolate.getDeliveryDate()+"' and ch.chocostatus='"+chocolate.getChocostatus()+"'";
	//String sql="SELECT chocostatus,count(chocostatus) as number FROM chocolateordering WHERE delivery_date BETWEEN '"+chocolate.getCreatedTime()+"' AND '"+chocolate.getDeliveryDate()+
	RowMapper<Chocolate> rowMapper = new BeanPropertyRowMapper<Chocolate>(Chocolate.class);
	return  this.jdbcTemplate.query(sql, rowMapper);	
	List<Map<String, Object>>  retlist = jdbcTemplate.queryForList(sql,new Object[]{});
	return retlist;
	}*/
	
	
	
}
