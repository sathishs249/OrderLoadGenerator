/**
 * 
 */
package com.gsot.load;

import java.util.Calendar;
import java.util.Date;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.gsot.personinfo.PersonInfoGenarator;
import com.yantra.yfc.dom.YFCDocument;

/**
 * This class is responsible for generating the Order XML and hitting the
 * application for testing the load.
 * 
 * @author Admin
 * 
 */
public class OrderLoadGenerator {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		process();
	}

	private void generateOrderXML() {

	}

//	private void personInfoGenerator() throws IOException {
//		YFCDocument orderLoadGenerator = YFCDocument.getDocumentForXMLFile("F:\\FromPC\\Sathish\\Performance\\PerformanceDataLoadGenerator\\input\\orderLoadGenerator.xml");
//		PersonInfoGenarator personInfoGen = new PersonInfoGenarator();
//		personInfoGen.process(orderLoadGenerator);
//	}

	private static void process() throws InterruptedException {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:ms");

		int numberOfOrders = 5, ordersPerHour = 60, numberOfThreads = 5, ordersPerThread = 0;
		long waitInterval;
		// if (numberOfOrders > ordersPerHour) {
		// ordersPerThread = numberOfOrders / numberOfThreads;
		// } else {
		// ordersPerThread = numberOfOrders / numberOfThreads;
		// }
		ordersPerThread = numberOfOrders / numberOfThreads;
		waitInterval = (long) ((60 / ordersPerHour) * 1000 * 60 * numberOfThreads);

		System.out
				.println("Process started @ " + dateFormat.format(new Date()));
		for (int i = 0; i < numberOfThreads; i++) {
			PublisherThread publisherThread = new PublisherThread();

			publisherThread.setOrdersPerThread(ordersPerThread);
			publisherThread.setWaitInterval(waitInterval);
			publisherThread.setNumberOfOrders(numberOfOrders);

			System.out.println("Thread -------------------------------> " + i);
			publisherThread.run();

		}

		System.out.println("Process ended @ " + dateFormat.format(new Date()));
	}
}