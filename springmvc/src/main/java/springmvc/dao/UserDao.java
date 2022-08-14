package springmvc.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import springmvc.model.User;

@Repository
public class UserDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	@Transactional // use to apply operarion in write mode;
	
	public int  saveUser(User user) {
		Integer id = (Integer) this.hibernateTemplate.save(user);
		return id;
	}
}
