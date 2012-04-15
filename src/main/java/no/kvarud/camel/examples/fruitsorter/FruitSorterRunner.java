package no.kvarud.camel.examples.fruitsorter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: stein
 * Date: 4/14/12
 * Time: 4:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class FruitSorterRunner {

    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("fruitsorter-context.xml");
    }

}
