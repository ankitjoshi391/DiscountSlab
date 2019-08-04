package com.shopping;

import java.util.Scanner;

public class InitialTrigger {
	
	public static void main(String args[]) {
		
		startProgram();
		
	}

	private static void startProgram() {
		Scanner input = new Scanner(System.in);
		boolean selected;
		do {
			selected = triggerCustomerType(input);
		} while (!selected);
	}

	private static boolean triggerCustomerType(Scanner input) {
		boolean isSelected = true;
		double netPayableAmt;
		System.out.print("Enter an Customer Type: \n 1. Regular \n 2. Premium \n");
		int customerTypeInput = input.nextInt();
		
		if(CustomerTypeEnum.REGULAR.getCustomerType() == customerTypeInput) {
			System.out.println("You are " + CustomerTypeEnum.REGULAR.toString() +" Customer");
			netPayableAmt= triggerDiscountCalculations(input,CustomerTypeEnum.REGULAR.getCustomerType());
			System.out.println("Total Payment Amount for Your Order is " + netPayableAmt);
			programTermination(input);
		}else if(CustomerTypeEnum.PREMIUM.getCustomerType() == customerTypeInput) {
			System.out.println("You are " + CustomerTypeEnum.PREMIUM.toString() +" Customer");
			netPayableAmt=triggerDiscountCalculations(input, CustomerTypeEnum.PREMIUM.getCustomerType());
			System.out.println("Total Payment Amount for Your Order is " + netPayableAmt);
			programTermination(input);
		}else {
			isSelected= false;
			System.out.println("Please Select correct Option either 1 or 2\n");
		}
		return isSelected;
	}
	
	private static void programTermination(Scanner input) {
		// TODO Auto-generated method stub
		System.out.print("Enter an Customer Type: \n 1. Recalcuate \n 2. Exit \n");
		int continueOption = input.nextInt();
		if(continueOption == 1) {
			startProgram();
		}else {
			System.out.print("Thank you!!");
			System.exit(0);
		}
	}

	private static double triggerDiscountCalculations(Scanner input, int customerType) {
		System.out.print("Enter an Order Amount: \n");
		double discountPer = 0.0;
		int orderValue = input.nextInt();
		double netPayAmt=0.0;
		if(containsOnlyNumbers(String.valueOf(orderValue))){
			netPayAmt=orderValue;
//			if(CustomerTypeEnum.REGULAR.getCustomerType() == customerType) {
//				if(0<orderValue && orderValue <= 5000) {
//					discountPer = 0.0;
//				}else if(5000<orderValue && orderValue<=10000){
//					discountPer = 10.0;
//				}else if(orderValue > 10000){
//					discountPer = 20.0;
//				}
//			}else if(CustomerTypeEnum.PREMIUM.getCustomerType() == customerType) {
//				if(0<orderValue && orderValue <= 4000) {
//					discountPer = 10.0;
//				}else if(4000<orderValue && orderValue<=8000){
//					discountPer = 15.0;
//				}else if(8000<orderValue && orderValue<=12000){
//					discountPer = 20.0;
//				}else if(orderValue > 12000){
//					discountPer = 30.0;
//				}
//			}
			
//			discountedValue = (orderValue*discountPer)/100;
			double discountedValueDouble = calculateDiscount(orderValue, customerType);
			netPayAmt=orderValue-discountedValueDouble;
			System.out.println("Total Order Amount is " + orderValue);
			System.out.println("\nTotal Discount ("+discountPer+"%) Amount is " + discountedValueDouble);
		}else {
			triggerDiscountCalculations(input, customerType);
		}
		return netPayAmt;
	}
	
	public static double calculateDiscount(float orderValue, int customerType){
		float discount = 0;
		if(CustomerTypeEnum.REGULAR.getCustomerType() == customerType) {
			if (orderValue <= 5000) {
				discount = 0;
			}else if (orderValue <= 10000.00) {
				discount = discount + (orderValue - 5000.00F) * 10 / 100;
			} else
				discount = discount + (orderValue - 10000.00F) * 20 / 100 + 500;
		} else if(CustomerTypeEnum.PREMIUM.getCustomerType() == customerType) {
			if (orderValue <= 4000)
				discount = discount + (orderValue) * 10 / 100;
			else if (orderValue <= 8000.00)
				discount = discount + (orderValue - 4000.00F) * 15 / 100 + 400;
			else if (orderValue <= 12000.00)
				discount = discount + (orderValue - 8000.00F) * 20 / 100 + 400 + 600;
			else
				discount = discount + (orderValue - 12000.00F) * 30 / 100 + 400 +600 + 800;
		}
		return discount;
	}
	
	private static boolean containsOnlyNumbers(String str)
	{
	    try {
	        Integer num = Integer.valueOf(str);
	        System.out.println("is a number");
	        return true;
	    } catch (NumberFormatException e) {
	        // TODO: handle exception
	        System.out.println("is not a number");
	        return false;
	    }

	}

}