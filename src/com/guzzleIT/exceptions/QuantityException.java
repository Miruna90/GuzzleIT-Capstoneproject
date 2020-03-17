/**
 * 
 */
package com.guzzleIT.exceptions;

/**
 * @author drmir
 *
 */
public class QuantityException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "Quantity should be greater that 0";
	/**
	 * 
	 */

	public QuantityException() {
		this(MESSAGE);
	}
	/**
	 * @param arg0
	 */
	
	
	public QuantityException(String arg0) {
		super(arg0);
	}
}
