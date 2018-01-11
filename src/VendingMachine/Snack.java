package VendingMachine;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Snack extends VendingMachine{
	
	public String type;
	public double price;
	
	public Snack(String type, double price){
		this.type = type;
		this.price = price;
	}
	
	public String getType(){
		return type;
	}
	
	public double getPrice(){
		return price;
	}
	
	@Override
	public String toString(){
		NumberFormat formatter = new DecimalFormat("#0.00");     
		return getType() + " : $" + (formatter.format(getPrice()));
	}
}
