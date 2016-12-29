package com.ecomm.becasual.daoimpl;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.becasual.dao.UserDetailsDAO;
import com.ecomm.beecasual.model.Cart;
import com.ecomm.beecasual.model.User;
import com.ecomm.beecasual.model.UserDetails;
import com.ecomm.beecasual.model.UserRole;
@Repository
public class UserDetailsDAOImpl implements UserDetailsDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public UserDetailsDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	public void addUserDetails(UserDetails userDetails) {
		Session session=sessionFactory.getCurrentSession(); 
		
		User user=new User();
		user.setUserId(userDetails.getUserId());
		user.setUserName(userDetails.getUserName());
		user.setUserPassword(userDetails.getPassword());
		user.setEnabled(true);
		session.saveOrUpdate(user);
		
		
		
		Cart cart=new Cart();
		cart.setCartId(user.getUserId());
		cart.setUserId(user.getUserId());
		session.saveOrUpdate(cart);
		
		UserRole userRole=new UserRole();
		userRole.setRoleId(1);
		userRole.setUserId(user.getUserId());
		session.saveOrUpdate(userRole);
		
		userDetails.setBillingAddress(userDetails.getBillingAddress());
		userDetails.setShippingAddress(userDetails.getShippingAddress());
		
		session.saveOrUpdate(userDetails.getBillingAddress());
		session.saveOrUpdate(userDetails.getShippingAddress());
		
		userDetails.setUserId(user.getUserId());
		userDetails.setCartId(cart.getUserId());
		session.saveOrUpdate(userDetails);
		
		
		session.flush();
		
		
		
		
		
		
	}

}
