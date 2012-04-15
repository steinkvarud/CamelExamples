package no.kvarud.camel.examples.fruitsorter.handlers;

import org.apache.camel.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: stein
 * Date: 4/14/12
 * Time: 3:02 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class DefaultHandler {

    Logger logger = LoggerFactory.getLogger(DefaultHandler.class);

    @Handler
    public void handleErrors(String body){



        logger.error("No way to handle this message. " + body);



    }
}
