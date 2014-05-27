/**
 * 
 */
package com.gsot.load;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.jms.JMSException;
import javax.naming.NamingException;

import com.gsot.utils.JMSPublisher;

/**
 * This class is responsible for publishing Order XML to the queue configured
 * using threads.
 * 
 * @author Admin
 * 
 */
class PublisherThread implements Runnable {
	long waitInterval;
	
	int numberOfOrders;
	int ordersPerThread;
	Date currentTime = new Date();
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:ms");
	Calendar calendar = Calendar.getInstance();
	Thread t;

	public PublisherThread() {

	}
	@Override
	public void run() {
		JMSPublisher publisher = new JMSPublisher();
		
		for (int i = 0; i < ordersPerThread; i++) {
			System.out.println("Publish the message - " + i);
			String message="";
			try {
				publisher.publishMessage(message);
			} catch (JMSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (NamingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {

				System.out.println("Sleep started @ "
						+ dateFormat.format(new Date()));
				Thread.sleep(waitInterval);

				System.out.println("Sleep  ended @ "
						+ dateFormat.format(new Date()));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	public void setWaitInterval(long waitInterval) {
		this.waitInterval = waitInterval;
	}

	public void setNumberOfOrders(int numberOfOrders) {
		this.numberOfOrders = numberOfOrders;
	}

	public void setOrdersPerThread(int ordersPerThread) {
		this.ordersPerThread = ordersPerThread;
	}

}


