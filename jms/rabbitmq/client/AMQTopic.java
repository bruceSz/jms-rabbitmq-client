package jms.rabbitmq.client;

import javax.jms.JMSException;
import javax.jms.Topic;

/**
 * @author bruceSz
 *
 */
public class AMQTopic extends AMQDestination implements Topic{

	@Override
	public String getTopicName() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

}
