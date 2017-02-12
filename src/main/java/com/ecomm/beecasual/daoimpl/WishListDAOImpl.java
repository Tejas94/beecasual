package com.ecomm.beecasual.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.beecasual.dao.WishListDAO;
import com.ecomm.beecasual.model.CartItem;
import com.ecomm.beecasual.model.WishList;

@Repository
public class WishListDAOImpl implements WishListDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public WishListDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	public void addWishList(WishList wishList) {
		sessionFactory.getCurrentSession().saveOrUpdate(wishList);
		
	}
	
	public List<WishList> getWishList() {
		Session session=sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<WishList> wishList=session.createQuery("from WishList").getResultList();
		
		return wishList;}
	public void deleteWhish(int wishListId) {
		WishList wishListToDelete= new WishList();
		wishListToDelete.setWishListId(wishListId);
		sessionFactory.getCurrentSession().delete(wishListToDelete);
		
	}

}
