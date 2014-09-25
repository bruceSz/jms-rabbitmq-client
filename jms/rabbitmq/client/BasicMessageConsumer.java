package jms.rabbitmq.client;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import jms.rabbitmq.jms.MessageConsumer;

/**
 * @author bruceSz
 *
 */
public abstract class BasicMessageConsumer extends Closable implements MessageConsumer {

	@Override
	public void close() throws JMSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MessageListener getMessageListener() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMessageSelector() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message receive() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message receive(long arg0) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message receiveNoWait() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setMessageListener(MessageListener arg0) throws JMSException {
		// TODO Auto-generated method stub
		
	}

}
