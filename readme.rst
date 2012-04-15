Apache Camel Examples
=====================

This is a set of examples for `Apache Camel <http://camel.apache.org/>`_

Setup
-----
The examples are created using Spring 3.1.1, Apache Camel 2.9.1 and `Apache Acitve MQ <http://activemq.apache.org/>`_ 5.4.3
All dependencies are configured in the Maven pom.

Configure Camel
---------------
To enable Camel in Spring add the following to your spring configuration to enable Camel to read BuilderRoute objects during Spring component scan.

  ::

    <camelContext id="camel">
      <contextScan/>
    </camelContext>

    <context:component-scan base-package="no.kvarud.camel.examples.fruitsorter.routes"/>


Configure ActiveMq
------------------
A very basic ActiveMQ configuration is set by adding a connection factory with a broker url to an embedded broker.

  ::

    <amq:connectionFactory id="jmsFactory" brokerURL="vm://localhost"/>

Add the Camel activemq component

  ::

    <bean id="activemq" class="org.apache.activemq.camel.component.ActiveMQComponent" p:connectionFactory-ref="jmsFactory"/>


Example index
-------------

- FruitSorter

  - This is an example of a content based message router. It is located in the ``no.kvarud.camel.examples.fruitsorter`` package








