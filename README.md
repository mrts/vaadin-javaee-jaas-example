# vaadin-javaee-jaas-example

An example Vaadin 8 Java EE application that demonstrates how to authenticate
and authorize users using JAAS and Vaadin CDI add-on, login form and view
navigator.

Tested with WildFly 10.1, but should work equally well with other Java EE 7
application servers (and probably Java EE 6 application servers once you
downgrade the `javaee-api` Maven dependency; you may also need to add
`web.xml` and more configuration).

## Adding users

WildFly has a security realm called *ApplicationRealm* configured by default.

To add a new user to *ApplicationRealm* execute the `add-user.{bat,sh}` script
within the `bin` folder of your WildFly installation and enter the requested
information. Choose *b) Application user* and add the user to the group
*users*.

You may need to restart WildFly if it is currently running to make it pick up
the new users.

## Building and running

You need Maven and Java 8 JDK to build and run the application.

Build the application WAR with `mvn package`, deploy it from
`target/jaasexample-1.0-SNAPSHOT.war` to the application server and open
<http://localhost:8080/jaasexample-1.0-SNAPSHOT/> in the browser.

## References

- [Stack Overflow question about Vaadin Java EE authentication and authorization](http://stackoverflow.com/questions/15619864/vaadin-authentication-and-auhorization)
- [Vaadin+JAAS example that works with JBoss](https://github.com/mstahv/vaadin-cdi-jaas-jbossas-example)
- [Using Vaadin CDI with JAAS authentication](https://vaadin.com/blog/-/blogs/using-vaadin-cdi-with-jaas-authentication) blog post and [wiki page](https://vaadin.com/wiki/-/wiki/Main/Using+Vaadin+CDI+with+JAAS+authentication)
- [Creating Secure Vaadin Applications using JEE6](https://vaadin.com/wiki/-/wiki/Main/Creating+Secure+Vaadin+Applications+using+JEE6) for Vaadin 6, less relevant for Vaadin 8, but thorough and gives good background information on JAAS

