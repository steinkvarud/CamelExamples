package no.kvarud.camel.examples.fruitsorter.routes;

import no.kvarud.camel.examples.fruitsorter.Fruit;
import no.kvarud.camel.examples.fruitsorter.handlers.DefaultHandler;
import no.kvarud.camel.examples.fruitsorter.handlers.OrangeJuicePress;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: stein
 * Date: 4/14/12
 * Time: 5:54 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class ContentBasedRouter extends SpringRouteBuilder {
    @Override
    public void configure() throws Exception {

        from("activemq:queue:fruits").choice().
                when(body().isEqualTo(Fruit.BANANA)).to("activemq:queue:banana").
                when(body().isEqualTo(Fruit.PEAR)).to("activemq:queue:pears").
                when(body().isEqualTo(Fruit.ORANGE)).bean(OrangeJuicePress.class).otherwise().bean(DefaultHandler.class);
    }
}
