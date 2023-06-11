package classes;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import classes.bll.RandomNumber;
import classes.dao.JpaService;
import classes.models.MailDetails;
import classes.models.ModelData;
import classes.models.UserDetails;
import classes.models.credentials2;
import classes.models.joinclass;
import classes.models.password;

@Controller
public class MainController {
	JpaService x;
	@Autowired
	RandomNumber rn;
	int i = 0;
	HashMap<String, ModelData> modelattr = new HashMap<String, ModelData>();

	@GetMapping("/HomeProcurement")
	public String getIndex() {
		return "HomeProcurement";
	}
	
	@GetMapping("/grnData")
	public String getGrn() {
		return "grnlist";
	}

	@GetMapping("/createGRN")
	public String createGRN() {
		return "create-grn";
	}

	@GetMapping("/purchaseOrderData")
	public String purchaseOrderData() {
		return "purchase order data";
	}

	@GetMapping("/createPurchaseOrder")
	public String createPurchaseOrder() {
		return "purchase orders";
	}

	@GetMapping("/createNewPurchaseOrders")
	public String createNewPurchaseOrders() {
		return "purchase orders from scratch";
	}

	@GetMapping("/indents")
	public String indents() {
		return "indents";
	}

	@GetMapping("/prnData")
	public String prnData() {
		return "prnlist";
	}

	@GetMapping("/createPRN")
	public String createPRN() {
		return "createprn";
	}

	@GetMapping("/addHSN")
	public String addHSN() {
		return "addHSN";
	}

	@GetMapping("/addProductCategory")
	public String addProductCategory() {
		return "addProductCategory";
	}

	@GetMapping("/addProduct")
	public String addProduct() {
		return "addProduct";
	}

	@GetMapping("/del")
	public String del() {
		return "del";
	}
	@GetMapping("/warehousestock")
	public String warehouse() {
		return "Warehouse";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "Home";
	}

	@Autowired
	public MainController(JpaService cla) {
		x = cla;
	}

	@RequestMapping(value = "/forgotrequest", method = RequestMethod.GET)
	public String request() {
		return "OtpReq";
	}



	@RequestMapping(value = "/changepass", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String changepass(password p) {
		UserDetails s = x.getRow(p);
		System.out.println(s.toString());
		if (!s.getOtp_expiry_time().isAfter(LocalDateTime.now())) {
			System.out.println(s.getOtp_expiry_time());
			return "failed";
		} else if (s.getOtp().equals(p.getOtp())) {
			x.getRow2(p);
			return "success";
		} else {
			return "failed";
		}
	}
    


	

	@RequestMapping(value = "/sendotp", method = RequestMethod.GET)
	public String sendmail(MailDetails md, Model m) throws MessagingException {
		i++;
		System.out.println(i);
		Properties prop = new Properties();
		m.addAttribute("mail", md.getMail());
		prop.put("mail.smtp.host", "smtp-mail.outlook.com");
		prop.put("mail.smtp.port", 587);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
		prop.put("mail.smtp.ssl.ciphersuites", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256");

		Session sess = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("devarmadd5@hotmail.com", "my mother43");
			}

		});
		prop.put("mail.smtp.ssl.trust", "*");
		sess.setDebug(true);
		int number = rn.getNumber();

		Message msg = new MimeMessage(sess);
		msg.setFrom(new InternetAddress("devarmadd5@hotmail.com"));

		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(md.getMail()));
		msg.setSubject("password reset");
		msg.setText("your otp is :" + number);
		Transport.send(msg);
		x.getDat(md, String.valueOf(number));

		return "ChangePassword";

	}

	public MainController() {

	}

	@RequestMapping(value = "/check", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String check(MailDetails md, Model m) throws MessagingException {
		return String.valueOf(x.check(md));

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	@ResponseBody
	public String login(credentials2 md, Model m) throws MessagingException {
		System.out.println("hello");
		System.out.println(x.getAuthent(md));
		return x.getAuthent(md);

	}

	// @RequestMapping(value = "/register", method = RequestMethod.POST)
	// @ResponseBody
	// public String register(UserDetails md, HttpSession s) throws MessagingException {
	//
	// boolean b=x.add(md);
	// if(b)
	// {
	//
	// return "redirect:/sendotp";
	// }
	//
	//
	// }
	@Scheduled(fixedDelay = 100)
	public void removeExpiredAttributes() {
		LocalDateTime currentTime = LocalDateTime.now();

		for (String attributeName : modelattr.keySet()) {
			ModelData attributeData = modelattr.get(attributeName);
			if (currentTime.isAfter(attributeData.getExpire())) {
				modelattr.remove(attributeName);
				System.out.println(attributeName + "deleted");
			}
		}
	}
}