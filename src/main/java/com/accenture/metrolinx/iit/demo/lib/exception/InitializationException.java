/**
 * 
 */
package com.accenture.metrolinx.iit.demo.lib.exception;

/**
 * An exception represet the error during initialize test environment, such as cannot load properties files
 * @author lucy.yang
 *
 */
public class InitializationException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String MSG = "Something wrong during initialize test environment";
	
	public InitializationException()
	{
		super(MSG);
	}
	
	public InitializationException(Throwable e)
	{
		super(MSG, e);
	}


}
