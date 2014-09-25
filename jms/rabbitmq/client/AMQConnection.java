package jms.rabbitmq.client;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.jms.ConnectionConsumer;
import javax.jms.ConnectionMetaData;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueSession;
import javax.jms.ServerSessionPool;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicSession;
import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jms.rabbitmq.common.AMQException;
import jms.rabbitmq.jms.Connection;
import jms.rabbitmq.protocol.AMQConstant;

import com.rabbitmq.client.ConnectionFactory;

/**
 * @author bruceSz
 *
 */
public class AMQConnection extends Closable implements Connection, QueueConnection, TopicConnection, Referenceable {

	private static final Logger _logger = LoggerFactory.getLogger(AMQConnection.class);
	
	private com.rabbitmq.client.Connection _connection;
	
	public AMQConnection(String host, int port, String userName, String passWord, String virtualHost, boolean sslEnabled) throws AMQException {

		ConnectionFactory connectionFac = new ConnectionFactory();
		connectionFac.setHost(host);
		connectionFac.setPort(port);
		connectionFac.setUsername(userName);
		connectionFac.setPassword(passWord);
		connectionFac.setVirtualHost(virtualHost);
		
			try {
				if (sslEnabled) {
					connectionFac.useSslProtocol();
				}
				_connection = connectionFac.newConnection();
				
			} catch (KeyManagementException e) {
				AMQException amqe = new AMQException(AMQConstant.CONNECTION_FAIL,"Error init SSLContext, key management error : " + e.getMessage(),e);
	            throw amqe;
			} catch (NoSuchAlgorithmException e) {
				AMQException amqe = new AMQException(AMQConstant.CONNECTION_FAIL,"Error init SSLContext, no algorithm error : " + e.getMessage(),e);
	            throw amqe;
			} catch (IOException e) {
				AMQException amqe = new AMQException(AMQConstant.CONNECTION_FAIL,"Error creating new connection: " + e.getMessage(),e);
	            throw amqe;
			}
		
	}

	@Override
	public void close() throws JMSException {
		try {
			_connection.close();
		} catch (IOException e) {
			JMSException jmse = new JMSException("Error creating closing connection : " + e.getMessage());
            jmse.setLinkedException(e);
            jmse.initCause(e);
            throw jmse;
		}
		
	}

	@Override
	public ConnectionConsumer createConnectionConsumer(Destination arg0, String arg1, ServerSessionPool arg2, int arg3) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConnectionConsumer createDurableConnectionConsumer(Topic arg0, String arg1, String arg2, ServerSessionPool arg3, int arg4) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Session createSession(boolean arg0, int arg1) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getClientID() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExceptionListener getExceptionListener() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConnectionMetaData getMetaData() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setClientID(String arg0) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setExceptionListener(ExceptionListener arg0) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start() throws JMSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() throws JMSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ConnectionConsumer createConnectionConsumer(Topic arg0, String arg1, ServerSessionPool arg2, int arg3) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TopicSession createTopicSession(boolean arg0, int arg1) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConnectionConsumer createConnectionConsumer(Queue arg0, String arg1, ServerSessionPool arg2, int arg3) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueueSession createQueueSession(boolean arg0, int arg1) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reference getReference() throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

}
