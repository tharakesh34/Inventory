package classes.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import classes.models.JoinClass2;
import classes.models.MailDetails;
import classes.models.ProductCategoryCount;
import classes.models.ProductName;
import classes.models.TotalOverallStock;
import classes.models.TotalStock;
import classes.models.TotalStockv2;
import classes.models.TotalWarehouseVal;
import classes.models.UserDetails;
import classes.models.VendorCount;
import classes.models.credentials2;
import classes.models.joinclass;
import classes.models.password;
import classes.models.productquant;
import classes.bll.*;
@Component
public class JpaService {
	InventDAO sd;
	@Autowired
	VendorCount vc;
    @Autowired
    TotalStockbll tb;
    @Autowired
    ProductCategoryCount pcc;
    @Autowired
    TotalWarehouseVal twv;
    @Autowired
    TotalOverallStock tsc;
	@Autowired
	public JpaService(@Qualifier("InventDAO") InventDAO sd) {
		super();
		this.sd = sd;
	}
	
	
	public TotalOverallStock getTotalStock()
	{
		ArrayList<TotalStock> ts=sd.getTotalStock();
		 
		tsc.setTotal_product_stock(tb.getTotalStockQuantity(ts));
		TotalOverallStock tsc2= tsc;
		return tsc2;
		
	}
	public List<JoinClass2> getProductsCount() {
		

		return sd.getProductsCount();

	}
	
	public TotalWarehouseVal getWarehouseValue()
	{
		double val= sd.getWarehouseValue();
		twv.setTotal_warehouse_value(val);
		return twv;
				
	}
	public ProductCategoryCount getCategoriesCount()
	{
		pcc.setTotal_product_category_count(sd.getCategoriesCount());
		System.out.println(pcc.toString());
		return pcc;
				
	}

	public VendorCount getVendorsCount()
	{
		
		vc.setVendorcount(sd.getVendorsCount());
		return vc;
				
	}

	public boolean add(UserDetails s) {
		return sd.persist(s);
	}

	public List<joinclass> getAllData() {
		return sd.getAllData();
	}

	public boolean check(MailDetails m) {
		try {
			UserDetails s = sd.check(m);
		} catch (NoResultException e) {
			// No entity found, return false
			return false;
		}

		return true;

	}

	public String getAuthent(credentials2 c) {
		try {
			UserDetails s = sd.getAuthent(c);
		} catch (NoResultException e) {
			// No entity found, return false
			return "login failed";
		}

		return "login success";
	}

	public void getDat(MailDetails m, String num) {
		System.out.println("hello");
		sd.getData(m, num);
		System.out.println("hello");
	}

	public UserDetails getRow(password m) {
		return sd.getRow(m);
	}

	public void getRow2(password p) {
		sd.getRow2(p);

	}

}