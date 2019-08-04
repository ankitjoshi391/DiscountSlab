package com.shopping;

public enum CustomerTypeEnum {
	
	REGULAR(1), PREMIUM(2);
	

    private int customerType;

    private CustomerTypeEnum(int s) {
        customerType = s;
    }

    public int getCustomerType() {
        return customerType;
    }

}
