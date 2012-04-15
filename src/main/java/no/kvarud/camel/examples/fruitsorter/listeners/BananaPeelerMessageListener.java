package no.kvarud.camel.examples.fruitsorter.listeners;


import no.kvarud.camel.examples.fruitsorter.Fruit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


/**
 * Created with IntelliJ IDEA.
 * User: stein
 * Date: 4/12/12
 * Time: 8:50 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class BananaPeelerMessageListener implements MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(BananaPeelerMessageListener.class.getName());

    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                TextMessage tm = (TextMessage)message;
                String msg = tm.getText();
                if(Fruit.BANANA.toString().equalsIgnoreCase(msg)){
                    logger.info("Peeling "+msg+"!");
                }else{
                    logger.warn("Cannot peel "+msg+".");
                }
            }else{
                logger.error("Unexpected message type "+message.getClass());
            }
        } catch (JMSException e) {
            logger.error(e.getMessage(), e);

        }
    }


}
