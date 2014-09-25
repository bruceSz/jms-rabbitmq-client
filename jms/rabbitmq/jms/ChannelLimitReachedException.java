package jms.rabbitmq.jms;

import javax.jms.ResourceAllocationException;

/**
 * @author bruceSz
 *
 */
public class ChannelLimitReachedException extends ResourceAllocationException{

	 private static final String ERROR_CODE = "1";

	 private long _limit;
	    
	 /**
	 * @param limit
	 */
	public ChannelLimitReachedException(long limit) {
		 super("Unable to create session, the maximum number of sessions per connection is " +
	              limit + ". You must either close one or more sessions or increase the " +
	              "maximum number of sessions available per connection.", ERROR_CODE);
		 _limit = limit;
		 
	}
	 
	 /**
	 * @return channe limit.
	 */
	public long getLimit() {
		 return _limit;
	 }
}
