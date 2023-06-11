package classes.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import classes.models.*;

@Component
public class InventDAO {
	// Custom query methods, if needed
	@PersistenceContext
	EntityManager em;
	 @Autowired
	    private ApplicationContext applicationContext;
	 productquant t1;
		ProductName r1;
	
	public ProductName getr1(@Autowired ProductName p)
	{
		return p;
	}
	public productquant gett1(@Autowired productquant p)
	{
		return p;
	}
	
	im_products r;
	im_products_stock t;

	@Transactional
	public boolean persist(UserDetails stud) {
		try {
			em.persist(stud);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Transactional
	public List<joinclass> getAllData() {
		ArrayList<Object[]> s = (ArrayList<Object[]>) em
				.createQuery("SELECT s, p FROM im_products s JOIN im_products_stock p ON s.product_id = p.product_id")
				.getResultList();
		List<joinclass> l = new ArrayList<joinclass>();
		for (Object[] x : s) {
			for (int i = 0; i < x.length; i++) {
				if (i == 0) {
					r = (im_products) x[i];
					System.out.println(r.toString());
					System.out.println("a ra babu");
				} else {
					t = (im_products_stock) x[i];
					System.out.println(t.toString());
				}
			}
			l.add(new joinclass(t, r));
		}

		return l;

	}
	@Transactional
	public List<JoinClass2> getProductsCount() {
		ArrayList<Object[]> s = (ArrayList<Object[]>) em
				.createQuery("SELECT s, p FROM im_products s JOIN im_products_stock p ON s.product_id = p.product_id")
				.getResultList();
	    
		List<JoinClass2> l = new ArrayList<JoinClass2>();
		for (Object[] x : s) {
			System.out.println(x.length);
			

			for (int i = 0; i < x.length; i++) {
				if (i == 0) {
					r=(im_products) x[i];
					r1=applicationContext.getBean(ProductName.class);
					r1.setProduct_name(r.getProduct_name());
					System.out.println(r1.toString());
					System.out.println("a ra babu");
				} else {
					t =  (im_products_stock) x[i];
                    t1=applicationContext.getBean(productquant.class);
                    t1.setProduct_stock(t.getProduct_stock());
					
					System.out.println(t1.toString());
				}
			}
			l.add(new JoinClass2(t1, r1));
		}

		return l;

	}
	@Transactional
	public ArrayList<TotalStock> getTotalStock()
	{
		System.out.println("hello");
		ArrayList<TotalStock> ts=(ArrayList<TotalStock>) em.createQuery("SELECT s FROM TotalStock s ", TotalStock.class).getResultList();
		return ts;
	}
	@Transactional
	public int getCategoriesCount()
	{
		Long val= (Long) em.createQuery("select count(*) from  ProductCategories s").getSingleResult();
		return val.intValue();
				
	}
	@Transactional
	public double getWarehouseValue()
	{
		Long val= (Long) em.createQuery("select sum(s.product_cost) from im_products_stock  s").getSingleResult();
		return val.doubleValue();
				
	}
	@Transactional
	public int getVendorsCount()
	{
		Long val= (Long) em.createQuery("select count(*) from Im_vendor  s").getSingleResult();
		return val.intValue();
				
	}
	@Transactional
	public UserDetails check(MailDetails m) {
		Query q = em.createQuery("select s from UserDetails s where s.user_name=:email", UserDetails.class)
				.setParameter("email", m.getMail());
		UserDetails s = (UserDetails) q.getSingleResult();

		System.out.println(s.toString());
		return s;
	}

	@Transactional
	public void getData(MailDetails m, String num) {
		Query q = em.createQuery("select s from UserDetails s where s.user_name=:email", UserDetails.class)
				.setParameter("email", m.getMail());
		UserDetails s = (UserDetails) q.getSingleResult();
		s.setOtp(num);
		s.setOtp_expiry_time((LocalDateTime.now().plusMinutes(2)));
		System.out.println(s.toString());

	}

	@Transactional
	public UserDetails getRow(password p) {
		Query q = em.createQuery("select s from UserDetails s where s.user_name=:email", UserDetails.class)
				.setParameter("email", p.getMail());
		UserDetails s = (UserDetails) q.getSingleResult();

		System.out.println(s.toString());
		return s;

	}

	@Transactional
	public void getRow2(password p) {
		Query q = em.createQuery("select s from UserDetails s where s.user_name=:email", UserDetails.class)
				.setParameter("email", p.getMail());
		UserDetails s = (UserDetails) q.getSingleResult();
		s.setUser_password(p.getPass());
		System.out.println(p.getPass());
		System.out.println(s.toString());

	}

	@Transactional
	public UserDetails getAuthent(credentials2 s) {
		Query q = em.createQuery(
				"select s from UserDetails s where s.user_name=:email and s.user_password=:password and s.user_type=:usertype",
				UserDetails.class).setParameter("email", s.getUsername()).setParameter("password", s.getPassword())
				.setParameter("usertype", s.getUser_type());
		UserDetails ud = (UserDetails) q.getSingleResult();
		System.out.println(ud.toString());
		return ud;

	}

}
