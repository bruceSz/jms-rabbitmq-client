package jms.rabbitmq.client;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author bruceSz
 *
 */
public abstract class Closable {

	/**
	 * Using AtomicBoolean class instead of using synchronized block 
	 * related method.
	 */
	private final AtomicBoolean _closed = new AtomicBoolean(false);
	
	/**
	 * Used when in process of closing. Enable further monitoring
	 * of the object.
	 */
	private final AtomicBoolean _closing = new AtomicBoolean(false);
	
}
