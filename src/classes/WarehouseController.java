package classes;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import classes.bll.RandomNumber;
import classes.dao.JpaService;
import classes.models.JoinClass2;
import classes.models.MailDetails;
import classes.models.ModelData;
import classes.models.ProductCategoryCount;
import classes.models.TotalOverallStock;
import classes.models.TotalWarehouseVal;
import classes.models.UserDetails;
import classes.models.VendorCount;
import classes.models.credentials2;
import classes.models.joinclass;
import classes.models.password;

@Controller
public class WarehouseController {
	JpaService x;
	

	

	@Autowired
	public WarehouseController(JpaService cla) {
		x = cla;
	}

	

	@RequestMapping(value = "/stockgraph", method = RequestMethod.GET)
	public String stockdata() {

		return "OtpReq";
	}

	

	@RequestMapping(value = "/getStock", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getStock() throws JsonProcessingException {
		ObjectMapper ob = new ObjectMapper();
		List<joinclass> l = x.getAllData();
		System.out.println(ob.writeValueAsString(l));
		return ob.writeValueAsString(l);

	}

	@RequestMapping(value = "/graphs", method = RequestMethod.GET)
	public String getGraph() {
		System.out.println("hello");
		return "graphs";
	}
	@RequestMapping(value = "/getTotalProductsCount", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getTotalProductsCount() throws JsonProcessingException {
		TotalOverallStock s=x.getTotalStock();
		ObjectMapper ob = new ObjectMapper();
		System.out.println(ob.writeValueAsString(s));
		return ob.writeValueAsString(s);
		
	}
	@RequestMapping(value = "/getProductsCount", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getProductsCount() throws JsonProcessingException {
		ObjectMapper ob = new ObjectMapper();
		List<JoinClass2> l=x.getProductsCount(); 
		System.out.println(ob.writeValueAsString(l));
		return ob.writeValueAsString(l);

	}
	@RequestMapping(value = "/getCategoriesCount", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getCategoriesCount() throws JsonProcessingException {
		ObjectMapper ob = new ObjectMapper();
		ProductCategoryCount l=x.getCategoriesCount(); 
		System.out.println(ob.writeValueAsString(l));
		return ob.writeValueAsString(l);

	}
	@RequestMapping(value = "/getWarehouseValue", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getWarehouseValue() throws JsonProcessingException {
		ObjectMapper ob = new ObjectMapper();
		TotalWarehouseVal l=x.getWarehouseValue();
		System.out.println(ob.writeValueAsString(l));
		return ob.writeValueAsString(l);

	}
	@RequestMapping(value = "/getVendorsCount", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getVendorsCount() throws JsonProcessingException {
		ObjectMapper ob = new ObjectMapper();
		VendorCount l=x.getVendorsCount(); 
		System.out.println(ob.writeValueAsString(l));
		return ob.writeValueAsString(l);

	}

	public WarehouseController() {

	}

	

	

	

}