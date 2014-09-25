package jms.rabbitmq.client;

import javax.jms.JMSException;
import javax.jms.XAConnection;
import javax.jms.XAQueueConnection;
import javax.jms.XAQueueSession;
import javax.jms.XASession;
import javax.jms.XATopicConnection;
import javax.jms.XATopicSession;

import jms.rabbitmq.common.AMQException;


public class XAConnectionImpl  extends AMQConnection implements XAConnection, XAQueueConnection, XATopicConnection{

	/**
	 * @param host
	 * @param port
	 * @param userName
	 * @param passWord
	 * @param virtualHost
	 * @param sslEnabled
	 * @throws JMSException 
	 */
	public XAConnectionImpl(String host, int port, String userName, String passWord, String virtualHost, boolean sslEnabled) throws AMQException {
		super(host, port, userName, passWord, virtualHost, sslEnabled);
	}

	@Override
	public XATopicSession createXATopicSession() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XAQueueSession createXAQueueSession() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XASession createXASession() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

}
