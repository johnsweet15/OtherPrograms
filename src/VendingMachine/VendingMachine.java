package VendingMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachine {
	
	private ArrayList<Snack> snacks;
	private double totalCost;

	public VendingMachine(){
		snacks = new ArrayList<Snack>();
		totalCost = 0.0;
	}
	
	public void addSnacks(){
		Scanner scn = new Scanner(System.in);
		String type = "";
		double price = 0.0;
		
		while(true){
			System.out.println("Enter a type of snack with which to stock the vending machine : ");
			type = scn.next();
			
			char first = type.charAt(0);
			if(Character.isLowerCase(first))
				first = Character.toUpperCase(first);
			
			if(!(type.equalsIgnoreCase("done"))){
				System.out.println("Enter the price of the snack : ");
				price = scn.nextDouble();
				
				Snack snack = new Snack(type, price);
				snacks.add(snack);
				System.out.println(snacks.size());
			}
			else{
				break;
			}
		}
		scn.close();
	}
	
	public void makeVendingMachine(){
		System.out.println("Choose your food : ");
		for(int i = 0; i < snacks.size(); i++){
			System.out.println((i + 1) + ") " + snacks.get(i).toString());
		}
	}
	
	public double getTotalCost(){
		return totalCost;
	}
	
	public void chooseSnack(int num){
		System.out.println("Giving you " + snacks.get(num).getType());
		totalCost += snacks.get(num).getPrice();
	}
	
	public static void main(String[] args){
		VendingMachine vend = new VendingMachine();
		vend.addSnacks();
		vend.makeVendingMachine();
		
		Scanner scn = new Scanner(System.in);
		int choice = scn.nextInt();
		
		vend.chooseSnack(choice);
		
		scn.close();
	}
}
