package com.gsot.utils;

import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.TextMessage;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JMSPublisher {
public  void publishMessage(String message) throws JMSException,
NamingException {
final Context ic = getInitialContext();
System.out.println("*** CONTEXT =");
final QueueConnectionFactory qcf = (QueueConnectionFactory)ic.lookup("jms:SCF");
// Lookup should specify the queue name that is mentioned as "mappedName" in MessageDriven Bean.
final Queue destQueue = (Queue)ic.lookup("jms:SDQ");
ic.close();
final QueueConnection connection = qcf.createQueueConnection();
try {
final QueueSession session = connection.createQueueSession(false, 0);
final QueueSender sender = session.createSender(destQueue);
final TextMessage msg = session.createTextMessage("Hello from Lichtenau - fans of FCN");
sender.send(msg);
} catch (Exception ex) {
ex.printStackTrace();
} finally {
connection.close();
}
}

private static Context getInitialContext() throws NamingException {
Hashtable env = new Hashtable();
// Add InitialContext property assignments here.
env.put( Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory" );
// Note that by default WebLogic server is not created with security, so credentials are not needed.
// TODO: Verify the server address and port number
env.put(Context.PROVIDER_URL, "t3://localhost:7011");
env.put(Context.SECURITY_PRINCIPAL, "weblogic");
env.put(Context.SECURITY_CREDENTIALS, "weblogic1"); 
return new InitialContext( env );
}
}
