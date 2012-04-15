package no.kvarud.camel.examples.fruitsorter.producers;

import no.kvarud.camel.examples.fruitsorter.Fruit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: stein
 * Date: 4/12/12
 * Time: 8:47 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class FruitGeneratorMessageProducer {

    private static final Logger logger = LoggerFactory.getLogger(FruitGeneratorMessageProducer.class);

    @Autowired
    private JmsTemplate template = null;
    private int messageCount = 100;


    private static Random random = new Random();
    /**
     * Generates JMS messages
     */
    @PostConstruct
    public void generateMessages() throws JMSException {
        logger.info("Producing "+messageCount+" messages.");
        for (int i = 0; i < messageCount; i++) {

            template.send(new MessageCreator() {
                public Message createMessage(Session session) throws JMSException {
                    //Create random fruit message
                    Fruit fruit = Fruit.values()[random.nextInt(Fruit.values().length)];
                    TextMessage message = session.createTextMessage(fruit.toString());
                    logger.info("Sending message: " + fruit);
                    return message;
                }
            });
        }
    }

}
