package com.assetmanagement.exception;

public class OrderItemNotFoundException extends RuntimeException {
	public OrderItemNotFoundException(String msg) {
		super(msg);
	}

}
