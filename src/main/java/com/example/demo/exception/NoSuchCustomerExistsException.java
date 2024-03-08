package com.example.demo.exception;

	// Step 3: Creating custom exception
	// that can be thrown when
	// user tries to update/delete a 
	// customer that doesn't exists
	

	public class NoSuchCustomerExistsException
		extends RuntimeException {

		private String message;

		public NoSuchCustomerExistsException() {}

		public NoSuchCustomerExistsException(String msg)
		{
			super(msg);
			this.message = msg;
		}
	}


