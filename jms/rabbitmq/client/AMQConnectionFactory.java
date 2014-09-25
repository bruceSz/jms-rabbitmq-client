package jms.rabbitmq.client;

import java.io.Serializable;
import java.util.Hashtable;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.XAConnection;
import javax.jms.XAConnectionFactory;
import javax.jms.XAQueueConnection;
import javax.jms.XAQueueConnectionFactory;
import javax.jms.XATopicConnection;
import javax.jms.XATopicConnectionFactory;
import javax.naming.Context;
import javax.naming.Name;
import javax.naming.NamingException;
import javax.naming.RefAddr;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.naming.StringRefAddr;
import javax.naming.spi.ObjectFactory;


import jms.rabbitmq.common.AMQException;




public class AMQConnectionFactory implements  ConnectionFactory, QueueConnectionFactory, TopicConnectionFactory,
												ObjectFactory, Referenceable, XATopicConnectionFactory,
												XAQueueConnectionFactory, XAConnectionFactory, Serializable{
	private String host;
	
	private int port;
	
	private String virtualHost;
	
	private String userName;
	
	private String passWord;
	
	private boolean sslEnabled;
	
	private String _connectionURL;
	
	AMQConnectionFactory() {
		
		
	}
	
	
	@Override
	public XAConnection createXAConnection() throws JMSException {
		 try {
			return new XAConnectionImpl(host, port, userName, passWord, virtualHost, sslEnabled);
		} catch (AMQException e) {
			JMSException jmse = new JMSException("Error creating XA connection: " + e.getMessage());
            jmse.setLinkedException(e);
            jmse.initCause(e);
            throw jmse;
		}
	}

	@Override
	public XAConnection createXAConnection(String username, String password) throws JMSException {
		try {
			return new XAConnectionImpl(host, port, username, password, virtualHost, sslEnabled);
		} catch (AMQException e) {
			JMSException jmse = new JMSException("Error creating XA connection: " + e.getMessage());
            jmse.setLinkedException(e);
            jmse.initCause(e);
            throw jmse;
		}
	}

	@Override
	public XAQueueConnection createXAQueueConnection() throws JMSException {
		return (XAQueueConnection)createXAConnection();
	}

	@Override
	public XAQueueConnection createXAQueueConnection(String username, String password) throws JMSException {
		return (XAQueueConnection)createXAConnection(username, password);
	}

	@Override
	public XATopicConnection createXATopicConnection() throws JMSException {
		return (XATopicConnection)createXAConnection();
	}

	@Override
	public XATopicConnection createXATopicConnection(String username, String password) throws JMSException {
		return (XATopicConnection)createXAConnection(username, password);
	}

	@Override
	public Reference getReference() throws NamingException {
		return new Reference(
                AMQConnectionFactory.class.getName(),
                new StringRefAddr(AMQConnectionFactory.class.getName(), ""),
                             AMQConnectionFactory.class.getName(), null);          // factory location
	}

	@Override
	public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) throws Exception {
		return null;
		 /*if (obj instanceof Reference)
	        {
	            Reference ref = (Reference) obj;

	            if (ref.getClassName().equals(AMQConnection.class.getName()))
	            {
	                RefAddr addr = ref.get(AMQConnection.class.getName());

	                if (addr != null)
	                {
	                    return new AMQConnection((String) addr.getContent());
	                }
	            }

	            if (ref.getClassName().equals(AMQQueue.class.getName()))
	            {
	                RefAddr addr = ref.get(AMQQueue.class.getName());

	                if (addr != null)
	                {
	                    return new AMQQueue(new AMQBindingURL((String) addr.getContent()));
	                }
	            }

	            if (ref.getClassName().equals(AMQTopic.class.getName()))
	            {
	                RefAddr addr = ref.get(AMQTopic.class.getName());

	                if (addr != null)
	                {
	                    return new AMQTopic(new AMQBindingURL((String) addr.getContent()));
	                }
	            }

	            if (ref.getClassName().equals(AMQConnectionFactory.class.getName()))
	            {
	                RefAddr addr = ref.get(AMQConnectionFactory.class.getName());

	                if (addr != null)
	                {
	                    return new AMQConnectionFactory((String) addr.getContent());
	                }
	            }

	        }
	        return null;*/
	}

	@Override
	public TopicConnection createTopicConnection() throws JMSException {
		return (TopicConnection)createConnection();
	}

	@Override
	public TopicConnection createTopicConnection(String username, String password) throws JMSException {
		return (TopicConnection)createConnection(username, password);
	}

	@Override
	public QueueConnection createQueueConnection() throws JMSException {
		return (QueueConnection)createConnection();
	}

	@Override
	public QueueConnection createQueueConnection(String username, String password) throws JMSException {
		return (QueueConnection)createQueueConnection(username, password);
	}

	/**
	 * @param host
	 * @param port
	 * @param userName
	 * @param passWord
	 * @param virtualHost
	 * @param sslEnabled
	 * @return AMQConnection
	 * @throws JMSException
	 */
	@Override
	public Connection createConnection() throws JMSException{
		return createConnection(host, port, userName, passWord, virtualHost, sslEnabled);
		
	}
	
	@Override
	public Connection createConnection(String username, String password) throws JMSException {
		return createConnection(host, port, username, password, virtualHost, sslEnabled);
	}
	/**
	 * @param host
	 * @param port
	 * @param userName
	 * @param passWord
	 * @param virtualHost
	 * @param sslEnabled
	 * @return AMQConnection
	 * @throws JMSException
	 */
	public Connection createConnection(String host, int port, String userName, String passWord, String virtualHost, boolean sslEnabled) throws JMSException {
		try {
			return new AMQConnection(host, port, userName, passWord, virtualHost, sslEnabled);
		} catch (AMQException e) {
			JMSException jmse = new JMSException("Error creating connection: " + e.getMessage());
            jmse.setLinkedException(e);
            jmse.initCause(e);
            throw jmse;
		}
	}

	/**
	 * @return host
	 */
	public String getHost() {
		return host;
	}


	/**
	 * @param host
	 */
	public void setHost(String host) {
		this.host = host;
	}


	/**
	 * @return port
	 */
	public int getPort() {
		return port;
	}


	public void setPort(int port) {
		this.port = port;
	}


	public String getVirtualHost() {
		return virtualHost;
	}


	public void setVirtualHost(String virtualHost) {
		this.virtualHost = virtualHost;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	public boolean isSslEnabled() {
		return sslEnabled;
	}


	public void setSslEnabled(boolean sslEnabled) {
		this.sslEnabled = sslEnabled;
	}

}
