package no.kvarud.camel.examples.fruitsorter.handlers;

import no.kvarud.camel.examples.fruitsorter.Fruit;
import org.apache.camel.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: stein
 * Date: 4/14/12
 * Time: 2:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class OrangeJuicePress {


    private static final Logger logger = LoggerFactory.getLogger(OrangeJuicePress.class.getName());

    @Handler
    public void press(String body){

        if (Fruit.ORANGE.toString().equalsIgnoreCase(body)){
            logger.info("Creating delicious orange juice!");
        }else{
            logger.warn("Cannot create juice from "+body+".");
        }

    }

}
