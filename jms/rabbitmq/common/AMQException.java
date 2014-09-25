package jms.rabbitmq.common;

import jms.rabbitmq.protocol.AMQConstant;


public class AMQException extends Exception {

	private AMQConstant _errorCode;
	
	private boolean _isHardError;
	
	 /**
	 * @param errorCode
	 * @param msg
	 * @param cause
	 */
	public AMQException(AMQConstant errorCode, String msg, Throwable cause)
	    {
	        // isHardError is defaulted to true to avoid unnessacery modification to
	        // existing code.
	        this(errorCode,true,msg,cause);
	    }
	 
	 /**
	 * @param errorCode
	 * @param isHardError
	 * @param msg
	 * @param cause
	 */
	public AMQException(AMQConstant errorCode, boolean isHardError, String msg, Throwable cause)
	    {
	        super(((msg == null) ? "" : msg), cause);
	        _errorCode = errorCode;
	        _isHardError = isHardError;
	    }
}
