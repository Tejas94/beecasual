package com.ecomm.beecasual.daoimpl;




import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.beecasual.dao.UserDetailsDAO;
import com.ecomm.beecasual.model.BillingAddress;
import com.ecomm.beecasual.model.Cart;
import com.ecomm.beecasual.model.ShippingAddress;
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

	public UserDetails getUserByName(String userName) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from UserDetails where userName = "+"'"+userName+"'";
		@SuppressWarnings("unchecked")
		List<UserDetails> userDetailsListByName=session.createQuery(hql).getResultList();
		
			return userDetailsListByName.get(0);
		
		
	}
	
	
	public void addRegUserDetails(UserDetails userDetails) {
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
		
		
		userDetails.setUserId(user.getUserId());
		userDetails.setCartId(cart.getUserId());
		session.saveOrUpdate(userDetails);
		
		
		session.flush();
	}
	
	
	public ShippingAddress getShippingListById(int userId) {
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ShippingAddress> shippingListById=session.createQuery("from ShippingAddress where Userdetails_UserId="+userId).getResultList();
		return shippingListById.get(0);
	}

	public BillingAddress getBillingListById(int userId) {
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<BillingAddress> billingListById=session.createQuery("from BillingAddress where Userdetails_UserId="+userId).getResultList();
		return billingListById.get(0);
	}
	
	public void addShippingAddress(ShippingAddress shippingAddress) {
		sessionFactory.getCurrentSession().saveOrUpdate(shippingAddress);
		
	}

	public void addBillingAddress(BillingAddress billingAddress) {
		sessionFactory.getCurrentSession().saveOrUpdate(billingAddress);
		
	}
	
	public int checkUser(String userName)
	{
		
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<UserDetails> usernamecheck=session.createQuery("from UserDetails where userName='"+userName+"'").getResultList();
		int count=usernamecheck.size();
		return count;
	}

}
