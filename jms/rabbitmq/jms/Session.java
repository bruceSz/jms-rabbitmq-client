package jms.rabbitmq.jms;

import javax.jms.QueueSession;
import javax.jms.TopicSession;

/**
 * @author bruceSz
 *
 */
public interface Session extends TopicSession, QueueSession{

}
