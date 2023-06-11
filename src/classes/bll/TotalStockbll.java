package classes.bll;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import classes.models.*;

@Component
public class TotalStockbll {
	
	public int getTotalStockQuantity(ArrayList<TotalStock> s)
	{
		int sum=0;
		for(TotalStock x:s)
		{
			sum+=x.getProduct_stock();
			
		}
		return sum;
	}

}
