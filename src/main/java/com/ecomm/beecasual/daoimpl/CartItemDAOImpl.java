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
		
		public List<CartItem> getCartItemList(int userId) {
			Session session=sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<CartItem> cartItemList=session.createQuery("from CartItem where userId="+userId+"and Flag=false").getResultList();
			
			return cartItemList;
		}
		
		public void deleteCartItem(int cartItemId) {
			CartItem cartItemToDelete= new CartItem();
			cartItemToDelete.setCartItemId(cartItemId);
			sessionFactory.getCurrentSession().delete(cartItemToDelete);
			
		}
		
		public int getCartOnce(int productId,String productSize,int userId)
		{
			Session session=sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<CartItem> cartItemProduct=session.createQuery("from CartItem where productId="+productId+"and productSize='"+productSize+"' and userId="+userId).getResultList();
			int count=cartItemProduct.size();
			return count;
		}
		
		public CartItem getCartOnceName(int productId,String productSize,int userId)
		{
			Session session=sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			List<CartItem> cartItemProduct=session.createQuery("from CartItem where productId="+productId+"and productSize='"+productSize+"' and userId="+userId).getResultList();
			return cartItemProduct.get(0);
		}
		
		public void updateQuantity2(int productId,int quantity)
		{
			
			String hql="update CartItem set productQuantity= productQuantity +"+quantity+" where productId="+productId;
			sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
		}
}
