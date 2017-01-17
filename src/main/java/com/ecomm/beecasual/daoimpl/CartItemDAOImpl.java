package com.ecomm.beecasual.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.beecasual.dao.CartItemDAO;
import com.ecomm.beecasual.model.CartItem;

@Repository
public class CartItemDAOImpl implements CartItemDAO {
		@Autowired
		SessionFactory sessionFactory;
		
		public CartItemDAOImpl(SessionFactory sessionFactory)
		{
			this.sessionFactory=sessionFactory;
		}

		public void addCartItem(CartItem cartItem) {
			sessionFactory.getCurrentSession().saveOrUpdate(cartItem);
			
		}
		
		public CartItem getCartItemListById(int cartItemId ) {
			Session session=sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<CartItem> cartItemListById=session.createQuery("from CartItem where cartItemId="+cartItemId).getResultList();
			return cartItemListById.get(0);
		}
		
		
		public void updateFlag(int cartItemId)
		{
			String hql="update CartItem set flag=TRUE where cartItemId="+cartItemId;
			sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
		
		}
}
