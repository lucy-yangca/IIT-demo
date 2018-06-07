/**
 * 
 */
package com.accenture.metrolinx.iit.demo.lib.exception;

/**
 * An exception represet the error during initialize test environment, such as cannot load properties files
 * @author lucy.yang
 *
 */
public class SeleniumGridException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String MSG = "Failed to launch WebDriver from Selenium Grid";
	
	public SeleniumGridException()
	{
		super(MSG);
	}
	
	public SeleniumGridException(String msg)
	{
		super(msg);
	}
	
	public SeleniumGridException(Throwable e)
	{
		super(MSG, e);
	}


}
